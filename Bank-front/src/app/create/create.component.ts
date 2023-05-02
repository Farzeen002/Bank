import { Component , OnInit} from '@angular/core';
import { Customer } from '../customer';
import { CreateService } from '../create.service';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  customers!: Customer[];

  

  constructor(private createService: CreateService, private dialog : MatDialog){}

  // constructor (private dialog : MatDialog){}

  ngOnInit(): void {
    this.getcreateAccounts();
  }

    private getcreateAccounts(){
      this.createService.getcreate().subscribe(data =>{
        console.log(data);
        // this.customers.push(data);

        this.customers = data;
        console.log(this.customers);
      })
    }
  

  }




