package com.project.stockmanagement.service;

import com.project.stockmanagement.model.entity.Person;
import com.project.stockmanagement.repository.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private IPersonDao personDao;
    public void addPerson(Person pPerson) {
        personDao.save(pPerson);
    }
    public List<Person> getAllPersons() {
        return personDao.findAll();
    }
    public Person getPersonById(Long id) {
        return personDao.getById(id);
    }
}
