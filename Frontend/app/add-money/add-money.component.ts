import { Component, OnInit } from '@angular/core';
import { EwalletService } from '../ewallet.service';
import { Transactiondetails } from '../transactiondetails';

@Component({
  selector: 'app-add-money',
  templateUrl: './add-money.component.html',
  styleUrls: ['./add-money.component.css']
})
export class AddMoneyComponent implements OnInit {
  transactiondetail:Transactiondetails;
  msg:String;
  errormsg:String;
  amount:number;
  transactionid:String;
  showtransactiondetail:boolean;
  transactionhistroy:Transactiondetails[];
  showtransactionhistroydetails:boolean;
  constructor(private eser:EwalletService) { }

  ngOnInit(): void {
    this.eser.gettransactiondetail(this.eser.transactionid).subscribe(data=>
      {
      this.transactiondetail=data;
      console.log(this.transactiondetail);
      this.showtransactiondetail=true;
    },
      error=>
      {
        console.log("error occured",error);
      }
    );
    
  }
  gettransactionhistroy()
  {
   
    this.eser.gettransactionhistroy().subscribe(data=>
      {
      this.transactionhistroy=data;
     
      console.log(data);
   
      this.showtransactionhistroydetails=true;
    },
      error=>
      {
        console.log("error occured",error);
      }
    );
  }
}
