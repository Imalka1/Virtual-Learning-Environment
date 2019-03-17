import {Injectable} from '@angular/core';
import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {Email} from "../../../dtos/email";
import {Student} from "../../../dtos/student";
import {Degree} from "../../../dtos/degree";
import {UndergraduateDetails} from "../../../dtos/registration/undergraduate-details";
import {PostgraduateDetails} from "../../../dtos/registration/postgraduate-details";
import {Registration} from "../../../dtos/registration/registration";
import {CashPayment} from "../../../dtos/payments/cash-payment";
import {CardPayment} from "../../../dtos/payments/card-payment";
import {ChequePayment} from "../../../dtos/payments/cheque-payment";
import {RegistrationCarrier} from "../../../dtos/registration/registration-carrier";
import {Payment} from "../../../dtos/payments/payment";
import {LoginStatus} from "../../../classes/login-status";

const URL = "/api/v1/student";

@Injectable()
export class StudentRegistrationService {
  student: Student = new Student();
  fee: number;
  degree: Degree = new Degree();
  registration: Registration = new Registration();
  underGraduate: UndergraduateDetails = new UndergraduateDetails();
  postGraduate: PostgraduateDetails = new PostgraduateDetails();
  cashPayment: CashPayment = new CashPayment();
  cardPayment: CardPayment = new CardPayment();
  chequePayment: ChequePayment = new ChequePayment();
  email: Email = new Email();
  graduationType: string;
  paymentType: string;

  constructor(private http: HttpClient) {
    this.registration.degree = new Degree();
  }

  setStudent(student: Student) {
    this.student = student;
  }

  getStudent() {
    return this.student;
  }

  setRegistration(underGraduate: UndergraduateDetails, postGraduate: PostgraduateDetails, graduationType: string, registration: Registration) {
    this.underGraduate = underGraduate;
    this.postGraduate = postGraduate;
    this.graduationType = graduationType;
    this.underGraduate.registration.student = this.student;
    this.postGraduate.registration.student = this.student;
    this.registration = registration;
  }

  setPayment(cashPayment: CashPayment, cardPayment: CardPayment, chequePayment: ChequePayment, paymentType: string) {
    this.cashPayment = cashPayment;
    this.cardPayment = cardPayment;
    this.chequePayment = chequePayment;
    this.paymentType = paymentType;
  }

  getFee() {
    return this.registration.degree.courseFee;
  }

  submitStudentRegistration(): Observable<Email> {
    let registrationCarrier = new RegistrationCarrier();
    registrationCarrier.underGraduate = this.underGraduate;
    registrationCarrier.postGraduate = this.postGraduate;
    registrationCarrier.graduationType = this.graduationType;
    registrationCarrier.cashPay = this.cashPayment;
    registrationCarrier.cardPay = this.cardPayment;
    registrationCarrier.chequePay = this.chequePayment;
    registrationCarrier.payType = this.paymentType;
    if (LoginStatus.getLoginStatus() == 5) {
      registrationCarrier.submitType = "Free";
    } else if (LoginStatus.getLoginStatus() == 2) {
      registrationCarrier.submitType = "Student";
    }
    console.log(registrationCarrier)
    return this.http.post<Email>(environment.backend_url + URL + "/submitStudentRegistration", registrationCarrier);
  }

  updateStudent(student: Student): Observable<boolean> {
    return this.http.post<boolean>(environment.backend_url + URL + "/updateStudent", student);
  }

  getAllStudentData(): Observable<Array<Student>> {
    return this.http.get<Array<Student>>(environment.backend_url + URL + "/getAllStudentData");
  }

  setEmailReply(email: Email) {
    this.email = email;
  }

  getEmailReply(): Email {
    return this.email;
  }

  setRegistrationId(id: string) {
    this.registration.registrationId = id;
  }

  getRegistrationId() {
    return this.registration.registrationId;
  }

  getRegistration(){
    return this.registration;
  }

  getAllRegistrationData(studentId: string): Observable<Array<Registration>> {
    return this.http.get<Array<Registration>>(environment.backend_url + URL + "/getAllStudentRegistrations?studentId=" + studentId);
  }

  getUndergraduateData(regId: string): Observable<UndergraduateDetails> {
    return this.http.get<UndergraduateDetails>(environment.backend_url + URL + "/getUndergraduateData?regId=" + regId);
  }

  getPostgraduateData(regId: string): Observable<PostgraduateDetails> {
    return this.http.get<PostgraduateDetails>(environment.backend_url + URL + "/getPostgraduateData?regId=" + regId);
  }

  getPaymentData(regId: string): Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(environment.backend_url + URL + "/getPaymentData?regId=" + regId);
  }

  getGraduationType() {
    return this.graduationType;
  }

  // setUndergraduate(underGraduate: UndergraduateDetails) {
  //   this.underGraduate = underGraduate;
  //   this.graduationType = "Undergraduate";
  //   this.underGraduate.registration.student = this.student;
  // }
  //
  // setPostgraduate(postGraduate: PostgraduateDetails) {
  //   this.postGraduate = postGraduate;
  //   this.graduationType = "Postgraduate";
  //   this.postGraduate.registration.student = this.student;
  // }
  // savePostGraduateRegistration_FreePortal() {
  //   console.log(this.postGraduate)
  //   return this.http.post<Email>(environment.backend_url + URL + "/saveStudentPostgraduate-freePortal", this.postGraduate);
  // }

  // getDataToPayments(): Registration {
  //   if (this.degree.graduationType == "Undergraduate") {
  //     this.underGraduate.registration.student = this.student;
  //     return this.underGraduate.registration;
  //   } else {
  //     this.postGraduate.registration.student = this.student;
  //     return this.postGraduate.registration;
  //   }
  // }

  // saveStudentFreePortal(): Observable<Email> {
  //   if (this.degree.graduationType == "Undergraduate") {
  //     this.underGraduate.registration.student = this.student;
  //     console.log(this.underGraduate);
  //     return this.http.post<Email>(BackendUrl.getMainUrl() + URL + "/saveStudentUndergraduate-freePortal", this.underGraduate);
  //   } else {
  //     this.postGraduate.registration.student = this.student;
  //     console.log(this.postGraduate)
  //     return this.http.post<Email>(BackendUrl.getMainUrl() + URL + "/saveStudentPostgraduate-freePortal", this.postGraduate);
  //   }
  // }
}
