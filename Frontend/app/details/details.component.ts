import { Component, OnInit } from '@angular/core';
import {NgModule } from '@angular/core';
import { EwalletService } from '../ewallet.service';
import { Walletuser } from '../walletuser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  constructor(private eser:EwalletService,private router: Router) { }
  wallet:Walletuser;
  amount:String;
  editflag:boolean=false;
  walletbal:number;
  choosenoption:String;
  msg:String;
  errormsg:String;
  fun1(pageName)
  {
    
    this.eser.amount=this.amount;
  
   
      this.eser.checkamount().subscribe(data=>
        {
        this.amount=data;
        
        this.router.navigate([`${"detail/"+pageName}`]);
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
 
  
  ngOnInit(): void {
    this.eser.getwalletId().subscribe(data=>
      {
      this.wallet=data;
      console.log(data);
      this.eser.wallet=this.wallet;
      this.walletbal=this.wallet.amount;
      
    },
      error=>
      {
        console.log("error occured",error);
      }
    );
  }

}
