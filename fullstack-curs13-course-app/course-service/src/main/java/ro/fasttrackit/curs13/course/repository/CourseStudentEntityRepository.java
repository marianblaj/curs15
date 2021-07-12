package ro.fasttrackit.curs13.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs13.course.model.CourseStudentEntity;

import java.util.List;

public interface CourseStudentEntityRepository extends JpaRepository<CourseStudentEntity, Long> {
    int deleteAllByStudentId(String studentId);

    List<CourseStudentEntity> findAllByStudentId(String studentId);
}
