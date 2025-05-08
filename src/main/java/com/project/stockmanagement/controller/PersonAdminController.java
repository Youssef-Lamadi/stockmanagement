package com.project.stockmanagement.controller;

import com.project.stockmanagement.model.entity.Person;
import com.project.stockmanagement.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/common")
public class PersonAdminController {
    @Autowired
    private IPersonService personService;
    @GetMapping ("managePersons")
    public String managePersons(Model model) {
        model.addAttribute("personList", personService.getAllPersons());
        /*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAccount userAccount = ((UserPrincipal) principal).getUser();
        model.addAttribute("role", userAccount.getRole().getRoleName());*/
        return "common/createPersons";
    }

    @PostMapping("createAccounts")
    public String createAccounts(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String email) {
        Person person = new Person();
        //person.setIdPerson(System.currentTimeMillis());
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        personService.addPerson(person);
        return "redirect:/common/managePersons";
    }

}

































