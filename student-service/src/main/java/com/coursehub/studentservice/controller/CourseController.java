package com.coursehub.studentservice.controller;

import com.coursehub.studentservice.response.CourseResponse;
import com.coursehub.studentservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/all-course")
    public ResponseEntity<List<CourseResponse>> getAllCourse(){
        List<CourseResponse> courseResponseList = courseService.getAllCourses();
       return new ResponseEntity<>(courseResponseList, HttpStatus.OK);
    }

}
