package com.aaiss.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String startPage() {
        return "main";
    }

    @GetMapping("/project/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/project/notice")
    public String notice() {
        return "notice";
    }

    @GetMapping("/project/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/project/center")
    public String center() {
        return "center";
    }

    @GetMapping("/admin")
    public String adminPage(HttpSession session) {
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        if (isAdmin != null && isAdmin) {
            return "admin";
        } else {
            return "redirect:/project/main";
        }
    }
}