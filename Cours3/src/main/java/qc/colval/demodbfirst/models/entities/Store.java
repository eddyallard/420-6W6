package qc.colval.demodbfirst.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id")
    private long storeId;

    @Column(name = "manager_staff_id")
    private long managerStaffId;

    @Column(name = "address_id")
    private long addressId;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getStoreId() {
        return this.storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getManagerStaffId() {
        return this.managerStaffId;
    }

    public void setManagerStaffId(long managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
