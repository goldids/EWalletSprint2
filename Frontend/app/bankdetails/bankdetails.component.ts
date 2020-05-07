import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EwalletService } from '../ewallet.service';
import { Bank } from '../bank';
import { Walletuser } from '../walletuser';

@Component({
  selector: 'app-bankdetails',
  templateUrl: './bankdetails.component.html',
  styleUrls: ['./bankdetails.component.css']
})
export class BankdetailsComponent implements OnInit {

  banklinked:String;
  flag:boolean;
  askaccountNo:boolean;
  accountno:String;
  msg:String;
  errormsg:String;
  bankdetail:Bank = new Bank();
  wallet:Walletuser;
  showbankdetails:boolean;
  constructor(private route:Router,private eser:EwalletService) { }
  ngOnInit(): void {
    this.eser.linkbankcheck().subscribe(data=>
      {
      this.banklinked=data;
     this.wallet=this.eser.wallet;
     console.log(data);
     this.askaccountNo=false;
    },
      error=>
      {
        this.askaccountNo=true;

        console.log("error occured",error);

      }
    );
   
  }
  linkyourbankaccount():void{
    this.eser.linkyourbank(this.accountno).subscribe(data=>
      {
     this.msg=data;
     
    },
      error=>
      {
        this.errormsg=JSON.parse(error.error).message;
        console.log("error occured",error);

      }
    );

  } 
  askaccountdeatil():void
  {
this.flag=true;
  }
  getbankdetail():void{
    this.eser.getbankdetail().subscribe(data=>
      {
       
     this.bankdetail=data;
     console.log(this.bankdetail);
     this.showbankdetails=true;
     
    },
      error=>
      {
        this.errormsg=JSON.parse(error.error).message;
        console.log("error occured",error);

      }
    );
  }

}
