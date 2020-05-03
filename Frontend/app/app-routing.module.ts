import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TempComponent} from './temp/temp.component';
import { DetailsComponent } from './details/details.component';
import { BankdetailsComponent } from './bankdetails/bankdetails.component';
import { AddMoneyComponent } from './add-money/add-money.component';
import { DebitcarddetailsComponent } from './debitcarddetails/debitcarddetails.component';
import { AddingmodeComponent } from './addingmode/addingmode.component';


const routes: Routes = [
  {path:'',component: TempComponent},
  {path:'addmoney',component:AddMoneyComponent},
  {path:'detail/mode',component:AddingmodeComponent,
  children: [
    {path:'bankdetails',component:BankdetailsComponent},
    {path:'debitcarddetails',component:DebitcarddetailsComponent}
  ]
},
  {path:'detail',component: DetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
