import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TempComponent} from './temp/temp.component';
import { DetailsComponent } from './details/details.component';
import { BankdetailsComponent } from './bankdetails/bankdetails.component';
import { AddMoneyComponent } from './add-money/add-money.component';
import { DebitcarddetailsComponent } from './debitcarddetails/debitcarddetails.component';
import { AddingmodeComponent } from './addingmode/addingmode.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ShowbalanceComponent } from './showbalance/showbalance.component';


const routes: Routes = [
  {path:'',component: HomepageComponent,children:[
    {path:'',component: TempComponent},
    {path:'addmoney',component:AddMoneyComponent},
    {path:'detail/bankdetails',component:BankdetailsComponent},
    {path:'detail',component: DetailsComponent},
    {path:'detail/transactionhistory',component:DebitcarddetailsComponent},
    {path:'availablebalance',component:ShowbalanceComponent},
    {path:'detail/mode',component:AddingmodeComponent}
  ]},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
