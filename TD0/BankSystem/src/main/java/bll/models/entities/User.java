package bll.models.entities;

import lombok.Data;

@Data
public abstract class User {
    private static int AUTO_ID = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String sex;
    private Address mainAddress;

    //Constructeur de base nécessaire pour que Lombok fonctionne sur les classes qui héritent de User.
    public User(){
        this.id = AUTO_ID++;
    }

    public User(String firstName, String lastName, String phoneNumber, String email, String sex, Address mainAddress) {
        this.id = AUTO_ID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
        this.mainAddress = mainAddress;
    }

}
