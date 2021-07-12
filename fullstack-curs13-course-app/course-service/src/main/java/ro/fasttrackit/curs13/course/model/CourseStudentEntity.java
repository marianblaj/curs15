package ro.fasttrackit.curs13.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CourseEntity course;

    private String studentId;
    private String studentName;
}
