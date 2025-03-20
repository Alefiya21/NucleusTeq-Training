package com.example.HRPortal.controller;

import com.example.HRPortal.service.HRService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hr")
public class HRController {

    @Autowired
    private HRService hrService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returns login.html from templates/
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        if (hrService.login(email, password).equals("Login Successful")) {
            session.setAttribute("hrEmail", email);
            return "redirect:/employees"; // Redirect to Employee Dashboard
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/hr/login";
    }
}
