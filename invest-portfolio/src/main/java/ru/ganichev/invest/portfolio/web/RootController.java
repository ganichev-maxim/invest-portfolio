package ru.ganichev.invest.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ganichev.invest.portfolio.AuthorizedUser;
import ru.ganichev.invest.portfolio.service.PortfolioService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    private final PortfolioService portfolioService;

    public RootController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/")
    public ModelAndView root() {
        return new ModelAndView("index");
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        return "redirect:portfolios";
    }

    @GetMapping("/portfolios")
    public String meals(Model model) {
        model.addAttribute("portfolios",
                portfolioService.getAll(AuthorizedUser.id()));
        return "meals";
    }
}
