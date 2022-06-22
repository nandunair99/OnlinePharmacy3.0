package com.narola.pharmacy.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/test")
    public String test()
    {
        return "test";
    }

    @GetMapping("/ShowAdminHome")
    public String ShowAdminHome()
    {
        return "home";
    }
}
