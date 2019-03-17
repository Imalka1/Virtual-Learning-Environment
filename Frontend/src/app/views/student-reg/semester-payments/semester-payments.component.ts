import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {DegreeService} from "../../../services/common/degree/degree.service";
import {StudentRegistrationService} from "../../../services/student-reg/student-registration/student-registration.service";
import {WizardColorService} from "../../../services/common/wizard-color/wizard-color.service";
import {LoginStatus} from "../../../classes/login-status";
import {CashPayment} from "../../../dtos/payments/cash-payment";
import {CardPayment} from "../../../dtos/payments/card-payment";
import {ChequePayment} from "../../../dtos/payments/cheque-payment";
import {FacultyService} from "../../../services/common/faculty/faculty.service";
import {RegistrationCarrier} from "../../../dtos/registration/registration-carrier";
import {Registration} from "../../../dtos/registration/registration";
import {Payment} from "../../../dtos/payments/payment";

declare var loadDatatable: any;

@Component({
  selector: 'app-semester-payments',
  templateUrl: './semester-payments.component.html',
  styleUrls: ['./semester-payments.component.css']
})
export class SemesterPaymentsComponent implements OnInit {
  p: number = 1;
  selectedRow: string = "";
  studentName: string;
  paymentType: string;
  totalFee: number;
  paymentId: string;
  payingAmount: number;
  cashPayment: CashPayment = new CashPayment();
  cardPayment: CardPayment = new CardPayment();
  chequePayment: ChequePayment = new ChequePayment();
  registrationCarrier: RegistrationCarrier = new RegistrationCarrier();
  payments: Array<Payment> = new Array();

  constructor(private router: Router, private degreeService: DegreeService, private studentRegistrationService: StudentRegistrationService, private wizardColor: WizardColorService) {

  }

  ngOnInit() {
    this.studentName = this.studentRegistrationService.getStudent().nameWithInitials;
    this.totalFee = this.studentRegistrationService.getFee();
    this.paymentType = "Card";
    if (this.router.isActive('/root/main/student-reg/student-payments', false)) {
      this.loadStudentPaymentData();
    } else if (this.router.isActive('/root/main/student-reg/semester-payments', false)) {

    }
  }

  previousPage(): void {
    if (this.router.isActive('/root/main/student-reg/student-payments', false)) {
      this.wizardColor.setStudentWizardGreen(1);
      this.router.navigate(['/root/main/student-reg/student-registrations']);
    }
    if (this.router.isActive('/root/main/student-reg/semester-payments', false)) {
      this.wizardColor.setStudentWizardGreen(3);
      this.router.navigate(['/root/main/student-reg/semester-registrations']);
    }
  }

  savePayment() {
    if (this.paymentType == 'Card') {
      this.cardPayment.totalFee = this.totalFee;
      this.cardPayment.amount = this.payingAmount;
    } else if (this.paymentType == 'Cash') {
      this.cashPayment.totalFee = this.totalFee;
      this.cashPayment.amount = this.payingAmount;
    } else if (this.paymentType == 'Cheque') {
      this.chequePayment.totalFee = this.totalFee;
      this.chequePayment.amount = this.payingAmount;
    }
    this.studentRegistrationService.setPayment(this.cashPayment, this.cardPayment, this.chequePayment, this.paymentType);
    this.studentRegistrationService.submitStudentRegistration().subscribe((email) => {
      this.studentRegistrationService.setEmailReply(email);
      if (this.loginStatus() != 5) {
        this.wizardColor.setStudentWizardGreen(5);
      } else {
        this.wizardColor.setStudentWizardGreen(3);
      }
      this.router.navigate(['/root/main/student-reg/student-summary']);
    })
  }

  resetId() {
    this.paymentId = undefined;
    this.payingAmount = undefined;
    this.cashPayment = new CashPayment();
    this.cardPayment = new CardPayment();
    this.chequePayment = new ChequePayment();
  }

  isActivePaymentStudent() {
    return this.router.isActive('/root/main/student-reg/student-payments', false)
  }

  nextPage(): void {
    if (this.router.isActive('/root/main/student-reg/student-payments', false)) {
      this.wizardColor.setStudentWizardGreen(3);
      this.router.navigate(['/root/main/student-reg/semester-registrations']);
    }
    // } else if (this.router.isActive('/root/main/student-reg/semester-payments', false)) {
    //   this.wizardColor.setStudentWizardGreen(4);
    //   this.router.navigate(['/root/main/student-reg/student-summary']);
    // }
    // this.router.navigate(['/root/main/student-reg/student-summary']);
  }

  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }

  loadStudentPaymentData() {
    this.studentRegistrationService.getPaymentData(this.studentRegistrationService.getRegistrationId()).subscribe((result) => {
      this.payments = result;
      loadDatatable();
    });
  }

  selectPayment(tableData: Payment) {
    this.selectedRow = tableData.payId;
    // this.graduationType = tableData.degree.graduationType;
  }
}

// this.studentRegistrationService.setPayment(this.amountToPay)
// if (this.studentRegistrationService.getGraduationType() == "Undergraduate") {
//   this.studentRegistrationService.saveUnderGraduateRegistration_FreePortal().subscribe(
//     (result) => {
//       this.studentRegistrationService.setEmailReply(result);
//       this.wizardColor.setStudentWizardGreen(3);
//       this.router.navigate(['/root/main/student-reg/student-summary']);
//     }
//   );
// } else {
//   this.studentRegistrationService.savePostGraduateRegistration_FreePortal().subscribe(
//     (result) => {
//       this.studentRegistrationService.setEmailReply(result);
//       this.wizardColor.setStudentWizardGreen(3);
//       this.router.navigate(['/root/main/student-reg/student-summary']);
//     }
//   );
// }
