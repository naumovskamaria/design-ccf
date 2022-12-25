package dians.d3final.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    public Salon salon;


}
