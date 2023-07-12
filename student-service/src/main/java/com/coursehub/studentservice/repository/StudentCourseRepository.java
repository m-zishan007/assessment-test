package com.coursehub.studentservice.repository;

import com.coursehub.studentservice.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    List<StudentCourse> findAllByCourseId(long courseId);
    void deleteAllByStudentId(long studentId);

}
