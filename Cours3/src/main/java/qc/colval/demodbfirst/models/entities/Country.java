package qc.colval.demodbfirst.models.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryId;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
