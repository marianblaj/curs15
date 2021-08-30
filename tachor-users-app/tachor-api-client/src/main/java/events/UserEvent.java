package events;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dto.AppUserApi;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = UserEvent.UserEventBuilder.class)
public class UserEvent {
    AppUserApi product;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserEventBuilder {
    }
}
