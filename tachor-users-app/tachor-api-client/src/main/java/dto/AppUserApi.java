package dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = AppUserApi.UserBuilder.class)
public class AppUserApi {
    Long id;
    String email;
    String role;


    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {
    }
}
