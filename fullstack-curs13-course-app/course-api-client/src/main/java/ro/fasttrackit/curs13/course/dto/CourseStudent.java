package ro.fasttrackit.curs13.course.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = CourseStudent.CourseStudentBuilder.class)
public class CourseStudent {
    Long courseId;
    String studentId;
    String studentName;
    int grade;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CourseStudentBuilder {
    }
}
