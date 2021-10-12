package com.example.firstspring.repository;

import com.example.firstspring.entity.CustomerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepo {

    @PersistenceContext
    private EntityManager emCus;

    public List<CustomerEntity>findAll(){
        Query q = emCus.createQuery("from Customer");
        return q.getResultList();
    }

    public CustomerEntity findById(@PathVariable int id){
        return emCus.find(CustomerEntity.class, id);
    }

    @Transactional
    public CustomerEntity save(CustomerEntity customer) {
        emCus.persist(customer); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
        return customer;
    }

    @Transactional
    public void delete(Integer id) {
        CustomerEntity customer = emCus.find(CustomerEntity.class, id); // ค ้นหาตาม id ที่ต ้องการลบ
        emCus.remove(customer); // เริ่มลบจริง
    }
}
