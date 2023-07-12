package com.coursehub.studentservice.request;

import lombok.Data;

import java.util.List;

@Data
public class StudentCourseRequest {

    private Long studentId;
    private List<Long> courseIds;
}
