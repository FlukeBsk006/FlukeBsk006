package com.example.firstspring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity (name="Customer") //กรณีมีตารางอยู่แล้ว
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ให้เจนเนอเรท auto id
    private Integer id;
//    @Column(name="column_name") //กรณีมีตรางอยู่แล้ว
    private String firstname;
    private String lastname;
    private Integer age;
    private String skills;
}
