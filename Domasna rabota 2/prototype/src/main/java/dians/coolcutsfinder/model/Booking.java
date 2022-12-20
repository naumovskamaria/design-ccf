package dians.coolcutsfinder.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Booking {
    @Id
    public Long Id;

    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Date reservationDate;
}
