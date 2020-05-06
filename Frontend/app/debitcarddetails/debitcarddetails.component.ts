import { Component, OnInit } from '@angular/core';
import { EwalletService } from '../ewallet.service';
import { Transactiondetails } from '../transactiondetails';

@Component({
  selector: 'app-debitcarddetails',
  templateUrl: './debitcarddetails.component.html',
  styleUrls: ['./debitcarddetails.component.css']
})
export class DebitcarddetailsComponent implements OnInit {
  transactionhistroy:Transactiondetails[];
  showtransactionhistroydetails:boolean;
  constructor(private eser:EwalletService) { }

  ngOnInit(): void {
    this.eser.gettransactionhistroy().subscribe(data=>
      {
      this.transactionhistroy=data;
     if(this.transactionhistroy.length>0)
     this.showtransactionhistroydetails=true;
     else
     this.showtransactionhistroydetails=false;
      console.log(data);

    },
      error=>
      {
        console.log("error occured",error);
      }
    );
  }

}
