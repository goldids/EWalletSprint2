import { Bank } from './bank';
import { Walletuser } from './walletuser';

export class Debitcard {
    debitid:String;
    cvv:number;
    expiremonth:number;
    expireyear:number;
    acc_no:Bank;
    wallet:Walletuser;
}
