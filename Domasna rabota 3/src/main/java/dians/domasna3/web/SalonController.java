package dians.domasna3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalonController {

    @GetMapping("/salon")
    public String landingPage(Model model){
        return "master-page";
    }
}
