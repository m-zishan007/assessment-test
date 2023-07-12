package com.coursehub.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_course")
    private Long id;

    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "course_id")
    private Long courseId;
}
