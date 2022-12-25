package dians.d3final.web;

import dians.d3final.model.Salon;
import dians.d3final.service.ReservationService;
import dians.d3final.service.SalonService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/salons")
public class SalonController {

    private final SalonService salonService;
    private final ReservationService reservationService;

    public SalonController(SalonService salonService, ReservationService reservationService) {
        this.salonService = salonService;
        this.reservationService = reservationService;
    }


    @GetMapping
    public String getSalonPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Salon> salons = this.salonService.getAllSalons();
        model.addAttribute("salons", salons);
        model.addAttribute("bodyContent", "salons");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteSalon(@PathVariable Long id) {
        this.salonService.deleteById(id);
        return "redirect:/salons";
    }

    @GetMapping("/info/{id}")
    @PreAuthorize("isAuthenticated()")
    public String showSalonInfo(@PathVariable Long id,Model model){
        if (this.salonService.getSalonById(id).isPresent()) {
            Salon salon = this.salonService.getSalonById(id).get();
            model.addAttribute("salon", salon);
            model.addAttribute("bodyContent", "salonInfo");
            return "master-template";
        }
        return "redirect:/salons?error=SalonNotFound";
    }

    @GetMapping("/edit-salon/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editSalonPage(@PathVariable Long id, Model model) {
        if (this.salonService.getSalonById(id).isPresent()) {
            Salon salon = this.salonService.getSalonById(id).get();
            model.addAttribute("salon", salon);
            model.addAttribute("bodyContent", "add-salon");
            return "master-template";
        }
        return "redirect:/salons?error=SalonNotFound";
    }

    @GetMapping("/add-salon")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addSalonPage(Model model) {
        model.addAttribute("bodyContent", "add-salon");
        return "master-template";
    }

//    @PostMapping("/reserve")
//    public String makeReservation(@RequestParam Long id,@RequestParam Date reservationDate,Model model){
//        model.addAttribute("salonId",id);
//        model.addAttribute("reservationDate",reservationDate);
//        Optional<Salon> s = this.salonService.getSalonById(id);
//        this.reservationService.createReservation(s);
//
//        return "redirect:/salons";
//    }

    @PostMapping("/add")
    public String saveSalon(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String address) {
        if (id != null) {
            this.salonService.edit(id, name, address);
        } else {
            this.salonService.save(name,address);
        }
        return "redirect:/salons";
    }

}
