package qc.colval.demodbfirst.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private long cityId;

    @Column(name = "city")
    private String city;

    @Column(name = "country_id")
    private long countryId;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getCityId() {
        return this.cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
