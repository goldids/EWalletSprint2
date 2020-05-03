import { Component, OnInit } from '@angular/core';
import { EwalletService } from '../ewallet.service';
import { Walletuser } from '../walletuser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-temp',
  templateUrl: './temp.component.html',
  styleUrls: ['./temp.component.css']
})
export class TempComponent implements OnInit {

  constructor(private eser:EwalletService,private router: Router) { }

  walletidd:String;
  w:Walletuser;
  msg:String;
  errormsg:String;
  
  details(pageName:String)
  {
    this.eser.walletid=this.walletidd;
     this.router.navigate([`${pageName}`]);
  }
  ngOnInit(): void {
  
  }
  }
