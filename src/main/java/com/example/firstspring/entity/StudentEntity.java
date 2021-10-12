package com.example.firstspring.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name="Student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
