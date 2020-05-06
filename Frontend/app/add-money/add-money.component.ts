import { Component, OnInit } from '@angular/core';
import { EwalletService } from '../ewallet.service';
import { Transactiondetails } from '../transactiondetails';
import { Router } from '@angular/router';

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
  constructor(private eser:EwalletService,private router: Router) { }

  ngOnInit(): void {
    this.eser.gettransactiondetail(this.eser.transactionid).subscribe(data=>
      {
        this.transactionid=this.eser.transactionid;
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
    this.router.navigate([`${"/detail/transactionhistory"}`]);
  }
}
