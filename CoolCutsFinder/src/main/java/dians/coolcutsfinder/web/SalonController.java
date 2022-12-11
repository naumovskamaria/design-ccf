package dians.coolcutsfinder.web;

import dians.coolcutsfinder.model.Salon;
import dians.coolcutsfinder.service.SalonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class SalonController {

    private final SalonService SalonService;

    public SalonController(SalonService SalonService) {
        this.SalonService = SalonService;
    }

    @GetMapping("/salons")
    public String showSalons(Model model){
        model.addAttribute("salons",SalonService.getAllSalons());
        return "salons";
    }

    @GetMapping("/salons/{id}")
    public String viewSalonInfo(Model model, @PathVariable Long id){
        List<Salon> salonList = SalonService.getAllSalons();
        Salon salon = this.SalonService.getSalonById(id);
        model.addAttribute("salonList",salonList);
        model.addAttribute("salon",salon);
        return "salonInfo";
    }
}
