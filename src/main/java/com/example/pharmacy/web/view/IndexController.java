package com.example.pharmacy.web.view;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/")
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to our digital pharmacy!";
        model.addAttribute("welcome", welcomeMessage);
        return "index";
    }
}
