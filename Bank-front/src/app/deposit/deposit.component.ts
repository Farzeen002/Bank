import { Component } from '@angular/core';
import { CreateService } from '../create.service';
import { Accounts } from '../accounts';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent {

  // accounts!: Accounts[];

  // acctID!: number;
  // money!: number;

  data1={
    acctID:"number",
    balance:"number"
  }

  constructor(private createService: CreateService){}


  onDeposit(){

    this.createService.depositAccount(this.data1).subscribe(data=>{
      console.log('Deposit successful');
        // Add any other actions you want to take on success
      }, error => {
        console.error('Deposit failed', error);
    });

  }

}

// ondelete(){

//   this.createService.deleteAccount(this.delacc).subscribe(data => {
//     console.log(`Account with ID ${this.delacc} has been deleted`);
//   },
//     error => {

//       console.error(error);
//   });
    
//   }
