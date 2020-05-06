import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EwalletService } from '../ewallet.service';
import { Debitcard } from '../debitcard';


@Component({
  selector: 'app-addingmode',
  templateUrl: './addingmode.component.html',
  styleUrls: ['./addingmode.component.css']
})
export class AddingmodeComponent implements OnInit {
  choosenoption:String;
  msg:String;
  errormsg:String;
  bank:boolean;
  debitcard:boolean;
  debitcardinfo:Debitcard=new Debitcard();
  name:String;
 transactionid:String
 walletbalance:String;
  constructor(private eser:EwalletService,private router: Router) { }

  ngOnInit(): void {
    
  }
  gotobankinfo(pageName:string)
  {
   
    this.bank=true;
    this.walletbalance=this.eser.amount;
    this.eser.bank=true;
    this.eser.debitcard=false;
    this.debitcard=false;
  
  }

  gotodebitinfo(pageName:string)
  {
    this.walletbalance=this.eser.amount;
    this.bank=false;
    this.eser.debitcard=true;
    this.eser.bank=false;  this.debitcard=true;
    
    
  }
  gotoaddmoney(pagename:String)
  {
    this.eser.debitcardinfo.cvv=this.debitcardinfo.cvv;
    console.log(this.eser.debitcardinfo.cvv);
    this.eser.debitcardinfo.expiremonth=this.debitcardinfo.expiremonth;
    this.eser.debitcardinfo.expireyear=this.debitcardinfo.expireyear;
    this.eser.debitcardinfo.debitid=this.debitcardinfo.debitid;

    if(this.eser.bank)
    {
      this.eser.addmoneyviabank().subscribe(data=>
        {
        this.transactionid=data;
        console.log(this.transactionid);
        this.eser.transactionid=this.transactionid;
        console.log(this.eser.transactionid);
        this.errormsg=undefined;
        this.router.navigate([`${pagename}`]);
      },
        error=>
        {
          console.log("error occured",error);
          this.errormsg=JSON.parse(error.error).message;
          console.log(error);
          this.msg=undefined;
        
        }
      );
    }
    else{
    this.eser.addmoneyviadebitcard().subscribe(data=>
      {
      this.transactionid=data;
      this.eser.transactionid=this.transactionid;
      
      this.router.navigate([`${pagename}`]);
    },
      error=>
      {
        console.log("error occured",error);
        this.errormsg=JSON.parse(error.error).message;
        console.log(error);
        this.msg=undefined;
       
      }
    );
    }
  }

}
