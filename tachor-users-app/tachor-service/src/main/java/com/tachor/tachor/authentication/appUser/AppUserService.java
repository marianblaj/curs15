package com.tachor.tachor.authentication.appUser;

import com.tachor.tachor.authentication.registration.token.ConfirmationToken;
import com.tachor.tachor.authentication.registration.token.ConfirmationTokenRepository;
import com.tachor.tachor.authentication.registration.token.ConfirmationTokenService;
import com.tachor.tachor.events.EventPublisher;
import com.tachor.tachor.model.mapper.AppUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EventPublisher eventPublisher;
    private final AppUserMapper appUserMapper;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {

            AppUser databaseUser = appUserRepository.findByEmail(appUser.getEmail()).orElseThrow();

            if (databaseUser.isEnabled()) {
                throw new IllegalStateException("email already taken");
            } else {
                confirmationTokenRepository.deleteByAppUser_Id(databaseUser.getId());
                appUserRepository.deleteByEmail(appUser.getEmail());
            }
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

      //  eventPublisher.sendAppUserAddedEvent(appUserMapper.toApi(appUser));
        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;
    }

    public void enableAppUser(String email) {
        appUserRepository.enableAppUser(email);
    }
}
