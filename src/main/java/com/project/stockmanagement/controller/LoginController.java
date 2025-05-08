package com.project.stockmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showLoginForm() {

        return "loginForm";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }

    @GetMapping("/user/userHome")
    public String showUserHomePage() {

        return "user/userHomePage";

    }

    @GetMapping("/admin/adminHome")
    public String showAdminHome() {

        return "admin/adminHome";

    }

}
