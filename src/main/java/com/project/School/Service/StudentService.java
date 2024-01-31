package com.project.School.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.School.Entity.student;
import com.project.School.Repository.Repository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class StudentService implements ServiceInterface{

	
	
	@Autowired
	private Repository repo;
	
	


	@Override
	public List<student> getAllStudent() {
		// TODO Auto-generated method stub
		
		List<student>liststudent=repo.findAll();		
		return liststudent;
	}




	@Override
	public student addStudent(student stud) {
		// TODO Auto-generated method stub
		
		student savestud=repo.save(stud);
		return savestud;
	}




	@Override
	public void deletestudent(Long idL) {
		// TODO Auto-generated method stub
		repo.deleteById(idL);
	}




	@Override
	public student updateStudent(Long id, student updatedStudent) {
		// TODO Auto-generated method stub
		 student existingStudent = repo.findById(id).orElse(null);

		    if (existingStudent != null) {
		    	existingStudent.setGrade(updatedStudent.getGrade());
		    	
	

		        return repo.save(existingStudent);
		    } else {
		
		        throw new EntityNotFoundException("student not found with id: " + id);
		    }
		
	}

}
