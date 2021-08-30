package ro.tachor.notificationservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Product.ProductBuilder.class)
public class Product {
     Long id;
     String title;
     double price;
     String description;
     String category;
     String image;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ProductBuilder {
    }
}
