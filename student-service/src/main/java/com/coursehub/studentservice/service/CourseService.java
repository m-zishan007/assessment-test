package com.coursehub.studentservice.service;

import com.coursehub.studentservice.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseService {


    RestTemplate restTemplate;
    public List<CourseResponse> getAllCourses(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType((MediaType.APPLICATION_JSON));

        HttpEntity<Object> requestEneity = new HttpEntity<>(headers);

        ResponseEntity<List<CourseResponse>> listResponseEntity = new RestTemplate()
                .exchange("http://localhost:8081/course/all-course", HttpMethod.GET,requestEneity, new ParameterizedTypeReference<List<CourseResponse>>() {});

        return listResponseEntity.getBody();
    }




}
