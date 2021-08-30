package events;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = ProductEvent.ProductEventBuilder.class)
public class ProductEvent {
    dto.Product product;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ProductEventBuilder {
    }
}
