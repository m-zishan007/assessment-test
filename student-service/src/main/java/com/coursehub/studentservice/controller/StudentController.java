package com.coursehub.studentservice.controller;

import com.coursehub.studentservice.model.Student;
import com.coursehub.studentservice.request.StudentCourseRequest;
import com.coursehub.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try{
            Student student = studentService.getStudentById(id);
            map.put("message", 1);
            map.put("data", student);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception ex){
            map.clear();
            map.put("status", 0);
            map.put("message", "student not found with given id");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try{
            Student student = studentService.getStudentById(studentId);
            studentService.deleteStudent(student);
            map.put("status", 1);
            map.put("message", "Student is deleted successfully!");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch(Exception ex){
            map.clear();
            map.put("status", 0);
            map.put("message", "student not found with provided id");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/student/")
    public ResponseEntity<?>  studentCourses(@RequestBody StudentCourseRequest studentCourseRequest){
        studentService.studentCourses(studentCourseRequest);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
