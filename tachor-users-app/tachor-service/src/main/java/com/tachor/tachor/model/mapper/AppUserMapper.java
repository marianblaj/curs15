package com.tachor.tachor.model.mapper;

import com.tachor.tachor.authentication.appUser.AppUser;
import com.tachor.tachor.authentication.appUser.Roles;
import dto.AppUserApi;
import org.springframework.stereotype.Component;
import utils.ModelMappers;

import java.util.Objects;

@Component
public class AppUserMapper {


//    public AppUserApi toApi(AppUser source) {
//        return AppUserApi.builder()
//                .id(source.getId())
//                .email(source.getEmail())
//                .role(source.getRole().name())
//                .build();
//    }
//
//    public AppUser toDb(AppUserApi source) {
//        return AppUser.builder()
//                .id(source.getId())
//                .email(source.getEmail())
//                .role(Objects.equals(source.getRole(), Roles.ROLE_USER.name()) ? Roles.ROLE_USER : Roles.ROLE_ADMIN)
//                .build();
//    }

}
