package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Long> {

}
