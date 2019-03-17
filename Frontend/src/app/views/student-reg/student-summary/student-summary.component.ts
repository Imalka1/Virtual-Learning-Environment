import {Component, OnInit} from '@angular/core';
import * as jsPDF from "jspdf";
import {StudentRegistrationService} from "../../../services/student-reg/student-registration/student-registration.service";
import {LoginStatus} from "../../../classes/login-status";
import {Router} from "@angular/router";
import {WizardColorService} from '../../../services/common/wizard-color/wizard-color.service';

@Component({
  selector: 'app-student-summary',
  templateUrl: './student-summary.component.html',
  styleUrls: ['./student-summary.component.css']
})
export class StudentSummaryComponent implements OnInit {
  studentName: string;
  regId: string;
  studentId: string;
  reply: string = "";

  constructor(private studentRegistrationService: StudentRegistrationService, private router: Router, private wizardColor: WizardColorService) {
  }

  ngOnInit() {
    if (localStorage.getItem('student-details0') != null) {
      this.studentName = localStorage.getItem('student-details0') + "." + localStorage.getItem('student-details1')
    } else {
      this.studentName = "";
    }
    this.reply = this.studentRegistrationService.getEmailReply().reply;
    this.studentId = this.reply.split(',')[2];
    this.regId = this.reply.split(',')[1];
    this.reply = this.reply.split(',')[0];
    if (this.loginStatus() == 5) {
      localStorage.clear();
    }
  }

  downloadPage() {
    var doc = new jsPDF();
    doc.setFontSize(11)
    doc.text(10, 20, 'Thank you,');
    doc.text(10, 30, this.studentName);
    doc.text(10, 40, 'You are now successfully registered as a new student with learning management system.');
    doc.text(10, 50, 'Note:- Now you can login as a student with the system.');
    doc.text(10, 60, 'Note:- Password(system generated) has been sent to your given email address.');
    doc.text(10, 70, 'Note:- Use your Student ID or email as the username and the given password for the login.');
    doc.text(10, 80, 'Note:- After login, you can change your password.');
    doc.text(10, 100, 'Registration ID - ' + this.regId);
    doc.text(10, 110, 'Student ID - ' + this.studentId);
    doc.text(10, 130, 'Contact :- 011-1234567');
    // doc.addPage();

    // Save the PDF
    doc.save('Registration.pdf');
  }

  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }

  goToSemReg() {
    this.wizardColor.setStudentWizardGreen(3);
    this.router.navigate(['/root/main/student-reg/semester-registrations']);
  }
}
