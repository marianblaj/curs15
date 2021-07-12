package ro.fasttrackit.curs13.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs13.course.model.CourseEntity;
import ro.fasttrackit.curs13.course.repository.CourseRepository;

import java.util.List;

@SpringBootApplication(scanBasePackages = {
        "ro.fasttrackit.curs13.course",
        "ro.fasttrackit.curs13.student.client"
})
public class CourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(CourseRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    CourseEntity.builder()
                            .discipline("info1")
                            .description("java")
                            .build(),
                    CourseEntity.builder()
                            .discipline("info2")
                            .description("java")
                            .build(),
                    CourseEntity.builder()
                            .discipline("info3")
                            .description("java")
                            .build(),
                    CourseEntity.builder()
                            .discipline("mate")
                            .description("analiza numerica")
                            .build()
            ));
        };
    }
}
