package ro.fasttrackit.curs13.course.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs13.course.dto.Course;
import ro.fasttrackit.curs13.course.model.CourseEntity;
import ro.fasttrackit.curs13.course.model.CourseStudentEntity;
import ro.fasttrackit.curs13.course.repository.CourseRepository;
import ro.fasttrackit.curs13.course.repository.CourseStudentEntityRepository;
import ro.fasttrackit.curs13.exceptions.ResourceNotFoundException;
import ro.fasttrackit.curs13.student.client.StudentApiClient;
import ro.fasttrackit.curs13.student.dto.Student;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    private final CourseStudentEntityRepository courseStudentEntityRepository;
    private final StudentApiClient studentClient;

    public List<CourseEntity> getAll() {
        return repository.findAll();
    }

    public CourseStudentEntity addStudentToCourse(long courseId, String studentId) {
        CourseEntity course = repository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find course with id " + courseId));

        Student student = studentClient.getById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find student with id " + studentId));
        log.info("Adding " + student.getName() + " to " + course.getDiscipline());
        return courseStudentEntityRepository.save(CourseStudentEntity.builder()
                .course(course)
                .studentId(student.getId())
                .studentName(student.getName())
                .build());
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    public CourseEntity addCourse(CourseEntity newCourse) {
        return repository.save(newCourse);
    }
}
