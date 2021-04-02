import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = "http://localhost:8080/api/customer";
  
  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<HttpResponse<Customer[]>>{
    return this.http.get<Customer[]>(this.API_URL, { observe: 'response'});
  }
}
