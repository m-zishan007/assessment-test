package com.coursehub.studentservice.service;

import com.coursehub.studentservice.model.Student;
import com.coursehub.studentservice.model.StudentCourse;
import com.coursehub.studentservice.repository.StudentCourseRepository;
import com.coursehub.studentservice.repository.StudentRepository;
import com.coursehub.studentservice.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;


    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }


    public Student registration(Student student) {
        return  studentRepository.save(student);
    }

    public void courseAssignation(Set<Long> courseIds, long studentId) {
        System.out.println("student id :"+ studentId);
        if (studentRepository.existsById(studentId)) {
            System.out.println("inside if");
            saveStudentCourse(courseIds, studentId);
        }else {
            System.out.println("inside else");
            throw new RuntimeException("Student does not exits");
        }
    }

    private void saveStudentCourse(Set<Long> courseIds, long studentId) {
        for(long cid: courseIds){
            StudentCourse course = new StudentCourse();
            course.setCourseId(cid);
            course.setStudentId(studentId);
            studentCourseRepository.save(course);
        }
    }

    public void courseAssignationUpdate(Set<Long> courseIds, long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentCourseRepository.deleteAllByStudentId(studentId);
            saveStudentCourse(courseIds, studentId);
        }else {
            throw new RuntimeException("Student does not exits");
        }
    }

    public List<Student> getAllStudentWithCourseId(long id) {


        List<Long> studentList = studentCourseRepository.findAllByCourseId(id).stream()
                .map(c -> c.getStudentId())
                .collect(Collectors.toList());

        return studentRepository.findAllById(studentList);

    }
}
