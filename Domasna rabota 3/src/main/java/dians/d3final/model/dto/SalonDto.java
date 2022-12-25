package dians.d3final.model.dto;

import lombok.Data;

@Data
public class SalonDto {

    private String name;

    private String address;

    public SalonDto() {
    }

    public SalonDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}