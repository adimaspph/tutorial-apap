package apap.tutorial.cineplux.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String home(
            Model model,
            Authentication authentication
    ) {
        model.addAttribute("isAdmin", authentication.getAuthorities().iterator().next().getAuthority().equals("ADMIN"));
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
