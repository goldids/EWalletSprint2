import { Bank } from './bank';
import { Transactiondetails } from './transactiondetails';

export class Walletuser {
    walletid:number;
    amount:number;
    acc_no:String;
    bankuser:Bank;
    trans_id:Transactiondetails[]=[];
}
