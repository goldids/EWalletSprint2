import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bank } from './bank';
import { Transactiondetails } from './transactiondetails';
import { Debitcard } from './debitcard';
import { Walletuser } from './walletuser';

@Injectable({
  providedIn: 'root'
})
export class EwalletService {

  walletid:String;
  amount:String;
  transactionid:String;
  transactions:Transactiondetails;
  transactionhistory:Transactiondetails[]=[];
  wallet:Walletuser;
  name:String;
  debitcardinfo:Debitcard=new Debitcard();
  bank:boolean;
  debitcard:boolean;
  constructor(private http:HttpClient) { }
  getwalletId():Observable<any>
 {
   let url="http://localhost:1078/Ewallet/wallet/"+this.walletid;

   return this.http.get("http://localhost:1078/Ewallet/wallet/"+this.walletid);
 }
 addmoneyviabank():Observable<any>
 {
   
   return this.http.get("http://localhost:1078/Ewallet/addmoney/"+this.walletid+"/"+this.amount,{responseType:'text'});
 }
 addmoneyviadebitcard():Observable<any>
 {
   
   return this.http.get("http://localhost:1078/Ewallet/addmoneydebit/"+this.walletid+"/"+this.amount+"/"+this.debitcardinfo.debitid+"/"+this.debitcardinfo.cvv+"/"+this.debitcardinfo.expiremonth+"/"+this.debitcardinfo.expireyear,{responseType:'text'});
 }

 gettransactiondetail(transaction:String):Observable<any>
 {
   return this.http.get("http://localhost:1078/Ewallet/transaction/"+transaction);
 }
 gettransactionhistroy():Observable<any>
 {
   return this.http.get("http://localhost:1078/Ewallet/transactiondetails/"+this.walletid);
 }
 checkamount():Observable<any>
 {
   return this.http.get("http://localhost:1078/Ewallet/amount/"+this.amount,{responseType:'text'});
 }
//  linkyourbank():Observable<any>
//  {
//   return this.http.get("http://localhost:1078/Ewallet/linkbankaccount/"+this.walletid+"/"+,{responseType:'text'});
//  }
}
