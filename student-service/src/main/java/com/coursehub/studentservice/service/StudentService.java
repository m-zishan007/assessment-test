package com.coursehub.studentservice.service;

import com.coursehub.studentservice.model.Student;
import com.coursehub.studentservice.repository.StudentRepository;
import com.coursehub.studentservice.request.StudentCourseRequest;
import com.coursehub.studentservice.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;
    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }

    public void studentCourses(StudentCourseRequest studentCourseRequest){
        Optional<Student> student = studentRepository.findById(studentCourseRequest.getStudentId());
        List<CourseResponse> courseResponseList = courseService.getAllCourses();
        List<Long> studentCourseRequests = studentCourseRequest.getCourseIds();

        for(int i=0; i <studentCourseRequests.size(); i++ ){

        }

    }
}
