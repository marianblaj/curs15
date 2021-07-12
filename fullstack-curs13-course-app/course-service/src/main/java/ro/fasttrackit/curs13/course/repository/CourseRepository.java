package ro.fasttrackit.curs13.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs13.course.dto.Course;
import ro.fasttrackit.curs13.course.model.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
