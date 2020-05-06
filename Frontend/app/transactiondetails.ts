import { Walletuser } from './walletuser';

export class Transactiondetails {
    transid:number;
    amount:number;
    bankname:string;
    accountNo:String;
    walletid:Walletuser[]=[];
    trans_time:Date;

}
