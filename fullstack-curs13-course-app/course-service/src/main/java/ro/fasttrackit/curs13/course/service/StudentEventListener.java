package ro.fasttrackit.curs13.course.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs13.course.model.CourseStudentEntity;
import ro.fasttrackit.curs13.student.events.StudentEvent;

import java.util.List;

import static ro.fasttrackit.curs13.student.events.StudentEventType.DELETED;

@Slf4j
@Component
@RequiredArgsConstructor
public class StudentEventListener {
    private final CourseStudentService courseStudentService;

    @RabbitListener(queues = "#{studentQueue.name}")
    void processStudentEvent(StudentEvent event) {
        if (event.getType() == DELETED) {
            List<CourseStudentEntity> deletedCourses = courseStudentService.deleteCoursesForStudent(event.getStudent().getId());
            log.info("Deleted all courses for " + event.getStudent().getName() + " : " + deletedCourses);
        }
    }
}
