package bll.models.entities;

import lombok.Data;

@Data
public class Address {
    private int civicNumber;
    private String streetName;
    private String postalCode;

    public Address(int civicNumber, String streetName, String postalCode) {
        this.civicNumber = civicNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }
}
