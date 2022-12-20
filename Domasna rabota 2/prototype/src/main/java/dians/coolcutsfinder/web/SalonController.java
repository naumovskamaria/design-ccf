package dians.coolcutsfinder.web;

import dians.coolcutsfinder.model.Salon;
import dians.coolcutsfinder.service.SalonService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("bodyContent","salons");
        return "master-page";
    }

    @GetMapping("/salons/{id}")
    public String viewSalonInfo(Model model, @PathVariable Long id){
        List<Salon> salonList = SalonService.getAllSalons();
        Salon salon = this.SalonService.getSalonById(id);
        model.addAttribute("salonList",salonList);
        model.addAttribute("salon",salon);
        model.addAttribute("bodyContent","salonInfo");
        return "master-page";
    }

    @GetMapping("/add-salon")
    @PreAuthorize("hasRole('ADMIN')")
    public String addSalonPage(Model model) {
        List<Salon> salons = this.SalonService.getAllSalons();
        model.addAttribute("bodyContent", "add-salon");
        return "master-page";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveSalon(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String address) {
        if (id != null) {
            Salon s = new Salon(name,address);
            this.SalonService.updateSalon(id,s);
        } else {
            Salon s = new Salon(name,address);
            this.SalonService.createSalon(s);
        }
        return "redirect:/salons";
    }
}
