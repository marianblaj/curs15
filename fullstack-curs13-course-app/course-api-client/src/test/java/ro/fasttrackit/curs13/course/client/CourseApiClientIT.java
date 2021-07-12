package ro.fasttrackit.curs13.course.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseApiClientIT {
    private CourseApiClient client;

    @BeforeEach
    void setup() {
        this.client = new CourseApiClient("http://localhost:8001");
    }

    @Test
    void addStudentToCourse() {
        System.out.println(client.addStudentToCourse("60be720dbc270d075d89a7e3", 1));
    }

}
