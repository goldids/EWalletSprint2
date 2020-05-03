import { Walletuser } from './walletuser';

export class Transactiondetails {
    transid:number;
    amount:number;
    bankname:String;
    accountNo:String;
    walletid:Walletuser[]=[];
    trans_time:Date;

}
