import { Component, OnInit } from '@angular/core';
import { Accounts } from '../accounts';
import { CreateService } from '../create.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  accounts1!: any[];
  accnew!: number;
  accactive!: boolean;
  acctID!:number;
  acctStatus!:number;
  balance!:number;

  constructor(private createService: CreateService){}

    ngOnInit(): void {
      this.accactive = false;
      // this.getviewBalance();

    }

    // private getviewBalance(){
    //   this.createService.viewBal().subscribe(data =>{
    //     console.log(data);
    //     // this.customers.push(data);

    //     this.accounts1 = data;
    //     console.log(this.accounts1);
    //   })
    // }

    onview(){
      this.createService.viewBal(this.accnew).subscribe(
        data=>{
          this.accactive = true;
          console.log(data.acctID);
          this.accounts1 = data;
          this.acctID = data.acctID;
          this.acctStatus = data.acctStatus;
          this.balance = data.balance;
          console.log(this.accounts1)

        }
      )

      // private getcreateAccounts(){
      //   this.createService.getcreate().subscribe(data =>{
      //     console.log(data);
      //     // this.customers.push(data);
  
      //     this.customers = data;
      //     console.log(this.customers);
      //   })
      // }
    
    }


  }
