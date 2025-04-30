package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountDao extends JpaRepository<UserAccount, Long> {
    UserAccount getUserByUsername(String username);
}
