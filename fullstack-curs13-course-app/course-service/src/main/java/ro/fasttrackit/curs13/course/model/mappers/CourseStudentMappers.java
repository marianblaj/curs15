package ro.fasttrackit.curs13.course.model.mappers;

import org.springframework.stereotype.Component;
import ro.fasttrackit.curs13.course.dto.CourseStudent;
import ro.fasttrackit.curs13.course.model.CourseEntity;
import ro.fasttrackit.curs13.course.model.CourseStudentEntity;
import ro.fasttrackit.curs13.utils.ModelMappers;

import static java.util.Optional.ofNullable;

@Component
public class CourseStudentMappers implements ModelMappers<CourseStudent, CourseStudentEntity> {
    @Override
    public CourseStudent toApi(CourseStudentEntity source) {
        return CourseStudent.builder()
                .courseId(ofNullable(source.getCourse())
                        .map(CourseEntity::getId)
                        .orElse(null))
                .studentId(source.getStudentId())
                .studentName(source.getStudentName())
                .build();
    }

    @Override
    public CourseStudentEntity toDb(CourseStudent source) {
        return CourseStudentEntity.builder()
                .course(CourseEntity.builder()
                        .id(source.getCourseId())
                        .build())
                .studentId(source.getStudentId())
                .studentName(source.getStudentName())
                .build();
    }
}
