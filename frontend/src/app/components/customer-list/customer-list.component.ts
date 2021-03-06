import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers: Customer[] = [];

  constructor(
    private customerService: CustomerService
  ) { }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe({
      next: customers => this.customers = customers.body
    });
  }

}
