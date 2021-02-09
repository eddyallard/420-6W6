package qc.colval.banksystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import qc.colval.banksystem.entities.enums.MaritalStatus;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "income")
    private double income;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "nip")
    private int nip;

    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Account> accounts;
}
