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
  bankaccountNo:String;
  name:String;
  debitcardinfo:Debitcard=new Debitcard();
  bank:boolean;
  debitcard:boolean;
  constructor(private http:HttpClient) { }
  getwalletId():Observable<any>
 {
   let url="http://localhost:1079/Ewallet/wallet/"+this.walletid;

   return this.http.get("http://localhost:1079/Ewallet/wallet/"+this.walletid);
 }
 addmoneyviabank():Observable<any>
 {
   
   return this.http.get("http://localhost:1079/Ewallet/addmoney/"+this.walletid+"/"+this.amount,{responseType:'text'});
 }
 addmoneyviadebitcard():Observable<any>
 {
   
   return this.http.get("http://localhost:1079/Ewallet/addmoneydebit/"+this.walletid+"/"+this.amount+"/"+this.debitcardinfo.debitid+"/"+this.debitcardinfo.cvv+"/"+this.debitcardinfo.expiremonth+"/"+this.debitcardinfo.expireyear,{responseType:'text'});
 }

 gettransactiondetail(transaction:String):Observable<any>
 {
   return this.http.get("http://localhost:1079/Ewallet/transaction/"+transaction);
 }
 gettransactionhistroy():Observable<any>
 {
   return this.http.get("http://localhost:1079/Ewallet/transactiondetails/"+this.walletid);
 }
 checkamount():Observable<any>
 {
   return this.http.get("http://localhost:1079/Ewallet/amount/"+this.amount,{responseType:'text'});
 }
 linkyourbank(accountNo:String):Observable<any>
 {
  return this.http.get("http://localhost:1079/Ewallet/linkbankaccount/"+this.walletid+"/"+accountNo,{responseType:'text'});
 }
 linkbankcheck():Observable<any>
 {
  return this.http.get("http://localhost:1079/Ewallet/checklink/"+this.walletid,{responseType:'text'});
 }
 getbankdetail():Observable<any>
 {
   alert(this.wallet.bankuser.accountNo);
  return this.http.get("http://localhost:1079/Ewallet/bankdetail/"+this.wallet.bankuser.accountNo);
 }
}
