import { Bank } from './bank';
import { Transactiondetails } from './transactiondetails';

export class Walletuser {
    walletid:number;
    amount:number;
    acc_no:String;
    bank_acc:Bank;
    trans_id:Transactiondetails[]=[];
}
