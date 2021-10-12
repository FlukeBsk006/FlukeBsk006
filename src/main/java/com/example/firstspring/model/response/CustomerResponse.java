package com.example.firstspring.model.response;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse <T> {
    private String firstname;
    private String lastname;
    private Integer age;
    private  T skills;
}


