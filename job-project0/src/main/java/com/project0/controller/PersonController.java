package com.project0.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project0.data.PersonRepository;
import com.project0.model.Person;


@RestController
@Transactional
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable int id) {
		return personRepository.getPersonById(id);
	}
	
	@GetMapping("/person")
	public ArrayList<Person> getAllPerson(){
		return (ArrayList<Person>) personRepository.findAll();
	}
	
	
}
