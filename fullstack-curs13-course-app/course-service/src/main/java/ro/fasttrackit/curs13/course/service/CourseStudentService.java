package ro.fasttrackit.curs13.course.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs13.course.model.CourseStudentEntity;
import ro.fasttrackit.curs13.course.repository.CourseStudentEntityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseStudentService {
    private final CourseStudentEntityRepository repository;

    @Transactional
    public List<CourseStudentEntity> deleteCoursesForStudent(String studentId) {
        List<CourseStudentEntity> result = repository.findAllByStudentId(studentId);
        log.info("Deleted course refs : " + repository.deleteAllByStudentId(studentId));
        return result;
    }
}
