package com.project.stockmanagement.service;

import com.project.stockmanagement.model.entity.Person;

import java.util.List;

public interface IPersonService {
    public void addPerson(Person pPerson);
    public List<Person> getAllPersons();
    public Person getPersonById(Long id);
}
