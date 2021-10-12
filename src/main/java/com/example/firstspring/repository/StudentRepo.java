package com.example.firstspring.repository;

import com.example.firstspring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
    StudentEntity findById(int id);
//    List<StudentEntity> findByIdList(int id);
}
