package ro.fasttrackit.curs13.course.model.mappers;

import org.springframework.stereotype.Component;
import ro.fasttrackit.curs13.course.dto.Course;
import ro.fasttrackit.curs13.course.model.CourseEntity;
import ro.fasttrackit.curs13.utils.ModelMappers;

@Component
public class CourseMappers implements ModelMappers<Course, CourseEntity> {
    @Override
    public Course toApi(CourseEntity source) {
        return Course.builder()
                .id(source.getId())
                .discipline(source.getDiscipline())
                .description(source.getDescription())
                .build();
    }

    @Override
    public CourseEntity toDb(Course source) {
        return CourseEntity.builder()
                .id(source.getId())
                .discipline(source.getDiscipline())
                .description(source.getDescription())
                .build();
    }
}
