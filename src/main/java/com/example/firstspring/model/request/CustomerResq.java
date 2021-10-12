package com.example.firstspring.model.request;


import lombok.Data;

import java.util.List;

@Data
public class CustomerResq {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private List<SkillRequest> skills;
}
