package com.example.firstspring.repository;

import com.example.firstspring.entity.SkillEntity;
import com.example.firstspring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepo extends JpaRepository<SkillEntity, Integer> {
    SkillEntity findById(int id);
//    List<StudentEntity> findByIdList(int id);
}
