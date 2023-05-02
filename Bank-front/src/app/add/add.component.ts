import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CreateService } from '../create.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit{
  
  customer: Customer = new Customer();

  constructor(private createService: CreateService, private router: Router) {}

    ngOnInit(): void{

    }

    saveAccount(){
      this.createService.addAccount(this.customer).subscribe(
        data=>{
          console.log(data);
          this.goToCreateList();
        },
        error => console.log(error));
      
    }

    goToCreateList(){
      this.router.navigate(['/create']);

    }

    onAdd(){
    console.log(this.customer);
    this.saveAccount();
    
  }

}


