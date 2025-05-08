package com.project.stockmanagement.controller;

import com.project.stockmanagement.model.entity.UserAccount;
import com.project.stockmanagement.service.IPersonService;
import com.project.stockmanagement.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class PersonAdminController {
    @Autowired
    private IPersonService personService;
    @RequestMapping("managePersons")
    public String managePersons(Model model) {
        model.addAttribute("personList", personService.getAllPersons());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAccount userAccount = ((UserPrincipal) principal).getUser();
        model.addAttribute("role", userAccount.getRole().getRoleName());
        return "common/listPersons";
    }
}
