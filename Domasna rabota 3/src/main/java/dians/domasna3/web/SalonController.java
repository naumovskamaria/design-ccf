package dians.domasna3.web;

import dians.domasna3.model.Salon;
import dians.domasna3.service.SalonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SalonController {

    private final SalonService salonService;

    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @GetMapping("/salons")
    public String showAllSalons(Model model){
        List<Salon> salonList = this.salonService.getAllSalons();
        model.addAttribute("bodyContent","salons");
        model.addAttribute("salonList",salonList);
        return "master-page";
    }
}
