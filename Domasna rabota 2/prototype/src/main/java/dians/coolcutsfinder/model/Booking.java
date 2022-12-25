package dians.coolcutsfinder.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @OneToOne
    @JoinColumn(name = "salon_id")
    public Salon salon;

    public Date reservationDate;

    public Booking(Salon salon, Date reservationDate) {
        this.salon = salon;
        this.reservationDate = reservationDate;
    }

    public Booking() {

    }
}
