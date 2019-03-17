import {UndergraduateDetails} from "./undergraduate-details";
import {PostgraduateDetails} from "./postgraduate-details";
import {CardPayment} from "../payments/card-payment";
import {CashPayment} from "../payments/cash-payment";
import {ChequePayment} from "../payments/cheque-payment";

export class RegistrationCarrier {
  submitType: string;
  registrationId: string;
  graduationType: string;
  payType: string;
  underGraduate: UndergraduateDetails;
  postGraduate: PostgraduateDetails;
  cardPay: CardPayment;
  cashPay: CashPayment;
  chequePay: ChequePayment;
}
