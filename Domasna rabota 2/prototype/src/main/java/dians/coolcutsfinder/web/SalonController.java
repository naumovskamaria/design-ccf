package dians.coolcutsfinder.web;

import dians.coolcutsfinder.model.Booking;
import dians.coolcutsfinder.model.Salon;
import dians.coolcutsfinder.model.User;
import dians.coolcutsfinder.service.BookingService;
import dians.coolcutsfinder.service.SalonService;
import dians.coolcutsfinder.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
public class SalonController {

    private final SalonService SalonService;
    private final BookingService bookingService;
    private final UserService userService;

    public SalonController(SalonService SalonService, BookingService bookingService, UserService userService) {
        this.SalonService = SalonService;
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/salons")
    public String showSalons(Model model){
        model.addAttribute("salons",SalonService.getAllSalons());
        model.addAttribute("bodyContent","salons");
        return "master-page";
    }

    @GetMapping("/salons/{id}/book")
    @PreAuthorize("hasRole('ADMIN')")
    public String makeBooking(Model model, @PathVariable Long id){
        model.addAttribute("bodyContent","booking");
        model.addAttribute("salonId",id);
        return "master-page";
    }

    @GetMapping("/successBooking")
    public String successBooking(Model model, @RequestParam Long id){
        model.addAttribute("bodyContent","successBooking");
        model.addAttribute("salonId",id);
        return "master-page";
    }

    @PostMapping("/finishedBooking")
    @PreAuthorize("hasRole('ADMIN')")
    public String makeReservation(@RequestParam Long id,@RequestParam Date reservationDate,Model model){
        Salon s = this.SalonService.getSalonById(id);
        Booking b = new Booking(s,reservationDate);
        this.bookingService.createBooking(b);
        return "redirect:/successBooking";
    }

    @GetMapping("/salons/{id}")
    public String viewSalonInfo(Model model, @PathVariable Long id){
        List<Salon> salonList = SalonService.getAllSalons();
        Salon salon = this.SalonService.getSalonById(id);
        model.addAttribute("salonList",salonList);
        model.addAttribute("salon",salon);
        model.addAttribute("bodyContent","salonInfo");
        model.addAttribute("salonId",id);
        return "master-page";
    }

    @GetMapping("/add-salon")
    @PreAuthorize("hasRole('ADMIN')")
    public String addSalonPage(Model model) {
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
