package com.example.firstspring.service;

import com.example.firstspring.entity.CustomerEntity;
import com.example.firstspring.entity.SkillEntity;
import com.example.firstspring.model.request.CustomerResq;
import com.example.firstspring.model.response.CustomerResponse;
import com.example.firstspring.model.response.SkillResponse;
import com.example.firstspring.repository.CustomerRepo;
import com.example.firstspring.repository.SkillRepo;
import com.example.firstspring.repository.StudentRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomseService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    SkillRepo skillRepo;

    public List<CustomerEntity> findAll() {
        CustomerEntity customer = new CustomerEntity();
        List<CustomerEntity> customerEntities = customerRepo.findAll();
        return customerEntities;
    }

    public CustomerEntity findById(Integer id) {
//        CustomerResponse response = new CustomerResponse();
        return customerRepo.findById(id);
    }

    public CustomerEntity save(CustomerEntity customerEntity) {
        return customerRepo.save(customerEntity);
    }

    public void delete(Integer id) {
    }

    public CustomerResponse save2(CustomerResq resq) {

//        CustomerEntity customer = new CustomerEntity();
        CustomerEntity customer = customerRepo.findById(resq.getId());
        customer.setId(resq.getId());
        customer.setFirstname(resq.getFirstname());
        customer.setLastname(resq.getLastname());
        customer.setAge(resq.getAge());

        List<SkillResponse> list = new ArrayList<>();
        resq.getSkills().forEach(skillRequest -> {
            SkillResponse skill = new SkillResponse();
            skill.setSkillId(skillRequest.getSkillId());
            skill.setSkillName(skillRequest.getSkillName());
            list.add(skill);
        });

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        customer.setSkills(jsonString);
        customerRepo.save(customer);

        CustomerResponse response = new CustomerResponse();
        response.setFirstname(resq.getFirstname());
        response.setLastname(resq.getLastname());
        response.setAge(resq.getAge());

        List<SkillResponse> outputList = gson.fromJson(gson.toJson(list), ArrayList.class);
        response.setSkills(outputList);

        return response;

    }
}
