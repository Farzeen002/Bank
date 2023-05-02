import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { Accounts } from './accounts';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  private baseURL = "http://localhost:8080/customer"

  private baseURL1 = "http://localhost:8080/account"


  constructor(private httpClient: HttpClient) { }

  getcreate(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.baseURL}`);

  }

  addAccount(customer: Customer): Observable<Object>{
      return this.httpClient.post(`${this.baseURL}`,customer);
  }

  viewBal(accid:number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL1}/${accid}/balance`);

}

  deleteAccount(accid : number): Observable<object>{
    return this.httpClient.delete(`${this.baseURL1}/${accid}`)
  }

  depositAccount(data1:any): Observable<object>{

    return this.httpClient.put(`${this.baseURL1}/${data1.acctID}/deposit/${data1.balance}`,data1)
  }

  withdrawAccount(data1:any): Observable<object>{

    return this.httpClient.put(`${this.baseURL1}/${data1.acctID}/withdraw/${data1.balance}`,data1)
  }

  transferAccount(data1:any): Observable<object>{

    return this.httpClient.put(`${this.baseURL1}/${data1.acctID}/transfer/${data1.destinationacctID}/${data1.balance}`,data1)
  }
}
