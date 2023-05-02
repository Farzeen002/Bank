import { NgModule, createComponent } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule , routingComponents} from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContentComponent } from './content/content.component';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ViewComponent } from './view/view.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { TransferComponent } from './transfer/transfer.component';
import { DeleteComponent } from './delete/delete.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateComponent } from './create/create.component';
import {MatDialogModule} from '@angular/material/dialog';
import { AddComponent } from './add/add.component';
import { FormsModule } from '@angular/forms';





@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    HomeComponent,
    NavbarComponent,
    ContentComponent,
    ViewComponent,
    DepositComponent,
    WithdrawComponent,
    TransferComponent,
    DeleteComponent,
    CreateComponent,
    AddComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatDialogModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
