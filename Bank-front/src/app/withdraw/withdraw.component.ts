import { Component } from '@angular/core';
import { CreateService } from '../create.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {
  data1={
    acctID:"number",
    balance:"number"
  }

  constructor(private createService: CreateService){}

  onWithdraw(){

    this.createService.withdrawAccount(this.data1).subscribe(data=>{
      console.log('Withdraw successful');
        // Add any other actions you want to take on success
      }, error => {
        console.error('Withdraw failed', error);
    });

  }

}
