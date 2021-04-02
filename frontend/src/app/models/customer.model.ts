export class Customer {
    public customerId: number;
    public firstName: string;
    public lastName: string;
    public email: string;
    public active: boolean;
    public createDate: Date;
    public lastUpdate: Date;
    public addressId: number;
    public storeId: number;
  
    // tslint:disable-next-line:max-line-length
    constructor(customerId: number, firstName: string, lastName: string, email: string, active: boolean, createDate: Date, lastUpdate: Date, addressId: number, storeId: number) {
      this.customerId = customerId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.active = active;
      this.createDate = createDate;
      this.lastUpdate = lastUpdate;
      this.addressId = addressId;
      this.storeId = storeId;
    }
}
