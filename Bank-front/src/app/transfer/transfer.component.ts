import { Component } from '@angular/core';
import { CreateService } from '../create.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent {

  data1={
    acctID:"number",
    destinationacctID:"number",
    balance:"number"
  }

  constructor(private createService: CreateService){}

  onTransfer(){
    this.createService.transferAccount(this.data1).subscribe(data=>{
      console.log('Transfer successful');
        // Add any other actions you want to take on success
      }, error => {
        console.error('Transfer failed', error);
    });

  }
  }


