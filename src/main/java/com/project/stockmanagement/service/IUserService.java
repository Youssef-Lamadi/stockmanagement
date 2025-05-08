package com.project.stockmanagement.service;

import com.project.stockmanagement.model.entity.Role;
import com.project.stockmanagement.model.entity.UserAccount;

import java.util.List;

public interface IUserService {
    public List<Role> getAllRoles();
    public List<UserAccount> getAllAccounts();
    public String createUser(Long idRole, Long idPerson);
}
