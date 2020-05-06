import { Component, OnInit } from '@angular/core';
import { EwalletService } from '../ewallet.service';
import { Walletuser } from '../walletuser';

@Component({
  selector: 'app-showbalance',
  templateUrl: './showbalance.component.html',
  styleUrls: ['./showbalance.component.css']
})
export class ShowbalanceComponent implements OnInit {

  constructor(private eser:EwalletService) { }
walletbalance:number;
wallet:Walletuser;
  ngOnInit(): void {
    this.eser.getwalletId().subscribe(data=>
      {
     this.wallet=data;
     this.walletbalance=this.wallet.amount;
    },
      error=>
      {
        console.log("error occured",error);
      
      }
    );
  }

}
