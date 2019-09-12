package com.project0.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project0.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	public Person getPersonById(int id);
}
