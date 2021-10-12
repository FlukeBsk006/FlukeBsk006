package com.example.firstspring.controller;

import com.example.firstspring.entity.CustomerEntity;
import com.example.firstspring.model.request.CustomerResq;
import com.example.firstspring.model.response.CustomerResponse;
import com.example.firstspring.service.CustomseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class CustomerRestController {
    @Autowired
    CustomseService customseService;

    @GetMapping("/customers")
    public List<CustomerEntity> getAllCustomer(){
        return customseService.findAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerEntity getCustomer(@PathVariable("id") Integer id) {
        return customseService.findById(id);
    }
//    @PostMapping("/customers")
//    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
//        return customseService.save(customer);
//    }

    @PostMapping("/customers")
    public CustomerResponse skillsTest(@RequestBody CustomerResq resq){
//        System.out.println(resq);
      return customseService.save2(resq);
    }

    @PutMapping("/customers")
    public CustomerEntity editCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity editCustomer = customseService.findById(customer.getId());
        editCustomer.setFirstname(customer.getFirstname());
        editCustomer.setLastname(customer.getLastname());
        editCustomer.setAge(customer.getAge());
        return customseService.save(editCustomer);
    }
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        customseService.delete(id);
        return "Delect Complete";
    }

}

