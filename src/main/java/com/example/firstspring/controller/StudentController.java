package com.example.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("/student")
    public String listStudent(){
//    public String listStudent(Model model){
//        model.addAttribute("sname", "เค้ก ฝน");
        return "list";
    }
}
