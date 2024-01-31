package com.project.School.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.School.Entity.student;
import com.project.School.Service.ServiceInterface;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/Student")
public class controller {
	
	@Autowired
	private ServiceInterface serviceInterface;

	
	//get All student
	
	
	@GetMapping("/allStudent")
	public ResponseEntity<List<student>>getAll()
	{
		List<student> listStudent=serviceInterface.getAllStudent();
		return new ResponseEntity<List<student>>(listStudent,HttpStatus.ACCEPTED);
	}
	
	
	//Add student 
		@PostMapping("/Add")
		public ResponseEntity<?>addBook(@RequestBody student  stud){
			student studentsaved=serviceInterface.addStudent(stud);
			return new ResponseEntity<student>(studentsaved,HttpStatus.CREATED);
		}
	
		

		//delete student
		
		@DeleteMapping("/Delete/{id}")
		public ResponseEntity<Void>deletestudent(@PathVariable("id")Long idL)
		{
			serviceInterface.deletestudent(idL);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		
		//update student
		
		@PutMapping("/Update/{id}")
		 public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody student updatedStudent) {
	        try {
	            student updatedStudentResult = serviceInterface.updateStudent(id, updatedStudent);
	            return new ResponseEntity<>(updatedStudentResult, HttpStatus.OK);
	        } catch (EntityNotFoundException e) {
	            return new ResponseEntity<>("student not found with id: " + id, HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error updating student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
		
}
