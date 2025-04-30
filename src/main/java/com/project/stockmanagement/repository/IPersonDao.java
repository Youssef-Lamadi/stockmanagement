package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDao extends JpaRepository<Person, Long> {

}
