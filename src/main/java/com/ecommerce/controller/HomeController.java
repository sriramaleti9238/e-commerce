package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        model.addAttribute("currentPath", "/");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model, HttpServletRequest request) {
        model.addAttribute("currentPath", "/about");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model, HttpServletRequest request) {
        model.addAttribute("currentPath", "/contact");
        return "contact";
    }
}


