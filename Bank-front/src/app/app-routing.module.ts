import { NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { HomeComponent } from './home/home.component';
import { ContentComponent } from './content/content.component';
import { ViewComponent } from './view/view.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { TransferComponent } from './transfer/transfer.component';
import { DeleteComponent } from './delete/delete.component';
import { AddComponent } from './add/add.component';


const routes: Routes = [

{
  path:"create",
  component:CreateComponent

},
{
  path:"add",
  component:AddComponent

},

{
  path:"view",
  component:ViewComponent

},
{
  path:"deposit",
  component:DepositComponent

},
{
  path:"withdraw",
  component:WithdrawComponent

},
{
  path:"transfer",
  component:TransferComponent

},
{
  path:"delete",
  component:DeleteComponent

},

{
  path:"home",
  component:ContentComponent
},

{
  path:'',
  component:ContentComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [CreateComponent,AddComponent,ViewComponent,DepositComponent,WithdrawComponent,TransferComponent,DeleteComponent]
