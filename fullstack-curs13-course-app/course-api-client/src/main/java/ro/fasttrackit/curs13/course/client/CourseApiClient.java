package ro.fasttrackit.curs13.course.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ro.fasttrackit.curs13.course.dto.CourseStudent;

import java.util.Optional;

import static java.lang.String.valueOf;

public class CourseApiClient {
    private final String baseUrl;
    private final RestTemplate rest;

    public CourseApiClient(@Value("${course.service.location:NOT_DEFINED}") String baseUrl) {
        this.baseUrl = baseUrl;
        this.rest = new RestTemplate();
    }

    public Optional<CourseStudent> addStudentToCourse(String studentId, long courseId) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/courses/")
                .path(valueOf(courseId))
                .path("/students/")
                .path(studentId)
                .toUriString();
        try {
            return Optional.ofNullable(rest.postForObject(url, null, CourseStudent.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

}
