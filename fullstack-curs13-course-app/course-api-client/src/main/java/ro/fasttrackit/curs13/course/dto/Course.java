package ro.fasttrackit.curs13.course.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Course.CourseBuilder.class)
public class Course {
    Long id;
    String discipline;
    String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CourseBuilder {
    }
}
