import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddMoneyComponent } from './add-money/add-money.component';
import { TempComponent } from './temp/temp.component';
import { DetailsComponent } from './details/details.component';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BankdetailsComponent } from './bankdetails/bankdetails.component';
import { DebitcarddetailsComponent } from './debitcarddetails/debitcarddetails.component';
import { AddingmodeComponent } from './addingmode/addingmode.component';

@NgModule({
  declarations: [
    AppComponent,
    AddMoneyComponent,
    TempComponent,
    DetailsComponent,
    BankdetailsComponent,
    DebitcarddetailsComponent,
    AddingmodeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
