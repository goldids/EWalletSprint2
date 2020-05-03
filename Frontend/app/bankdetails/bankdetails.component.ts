import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bankdetails',
  templateUrl: './bankdetails.component.html',
  styleUrls: ['./bankdetails.component.css']
})
export class BankdetailsComponent implements OnInit {

  constructor(private route:Router) { }

  fun1(pagename:String)
  {
    this.route.navigate([`${pagename}`]);
  }
  ngOnInit(): void {
  }

}
