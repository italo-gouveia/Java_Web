package com.italo.firstspringdata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.italo.firstspringdata.entity.Student;
import com.italo.firstspringdata.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentyRepository;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public List<Student> listStudent(){
		return this.studentyRepository.findAll();
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		return this.studentyRepository.save(student);
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public Optional<Student> findById(@PathVariable String id) {
		return this.studentyRepository.findById(id);
	}
	
	@RequestMapping(value="/student/{name}/name", method= RequestMethod.GET)
	public List<Student> findByName(@PathVariable String name){
		return this.studentyRepository.findByNameLikeIgnoreCase(name);
	}
}
