package ru.ganichev.invest.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

    @GetMapping("/welcome.html")
    public ModelAndView root() {
        return new ModelAndView("index");
    }
}
