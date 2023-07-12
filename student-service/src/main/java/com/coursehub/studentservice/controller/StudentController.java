package com.coursehub.studentservice.controller;

import com.coursehub.studentservice.model.Student;
import com.coursehub.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
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

            ex.printStackTrace();

            map.clear();
            map.put("status", 0);
            map.put("error", ex.getMessage());
            map.put("message", "student not found with given id");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/student/{studentId}")
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

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody  Student student){
        Student response = studentService.registration(student);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/student/{studentId}/course")
    public ResponseEntity<?> courseAssignation(@RequestBody Set<Long> courseIds, @PathVariable long studentId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            studentService.courseAssignation(courseIds, studentId);
            map.put("status", 1);
            map.put("message", "Course assignation successful");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            map.clear();
            map.put("status", 0);
            map.put("error",exception.getMessage());
            map.put("message", "student not found with provided id");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/student/{studentId}/course")
    public ResponseEntity<?> courseUpdate(@RequestBody Set<Long> courseIds, @PathVariable long studentId){

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            studentService.courseAssignationUpdate(courseIds, studentId);
            map.put("status", 1);
            map.put("message", "Courses updated successful");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception exception){
            map.clear();
            map.put("status", 0);
            map.put("message", "student not found with provided id");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/course/{courseId}/student")
    public ResponseEntity<?> getAllStudentWithCourseId(@PathVariable long courseId){

        List<Student> students = studentService.getAllStudentWithCourseId(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


}
