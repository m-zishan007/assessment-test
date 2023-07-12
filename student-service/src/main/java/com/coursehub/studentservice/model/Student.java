package com.coursehub.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    private Long id;
    @Column(name = "full_name_english")
    private String fullNameEnglish;
    @Column(name = "full_name_arabic")
    private String fullNameArabic;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "address")
    private String address;
}
