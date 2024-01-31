package com.project.School.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.School.Entity.student;


public interface Repository extends JpaRepository<student,Long>{

}
