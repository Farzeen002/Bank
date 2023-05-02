import { Component, OnInit } from '@angular/core';
import { Accounts } from '../accounts';
import { CreateService } from '../create.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  delete : Accounts = new Accounts ();
  delacc!: number;

  constructor(private createService: CreateService){}

  ngOnInit(): void {
    
  }

  ondelete(){

    this.createService.deleteAccount(this.delacc).subscribe(data => {
      console.log(`Account with ID ${this.delacc} has been deleted`);
    },
      error => {

        console.error(error);
    });
      
    }


    // onDeleteAccount(accountId: number) {
    //   this.deleteAccount(accountId).subscribe(
    //     () => {
    //       // Handle success here
    //       console.log(`Account with ID ${accountId} has been deleted`);
    //     },
    //     error => {
    //       // Handle error here
    //       console.error(error);
    //     }
    //   );
    // }
    

  }


