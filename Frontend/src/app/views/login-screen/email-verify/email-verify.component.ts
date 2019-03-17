import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import "../../../../assets/js/login/login.js";
import {Email} from "../../../dtos/email";
import {LoginService} from "../../../services/login-screen/login/login.service";
import {Router} from "@angular/router";

declare var loadLogin: any;

@Component({
  selector: 'app-email-verify',
  templateUrl: './email-verify.component.html',
  styleUrls: ['./email-verify.component.css']
})
export class EmailVerifyComponent implements OnInit {
  @ViewChild('verNumber') verNumber: ElementRef
  email: Email = new Email();
  success: boolean = false;
  failed: boolean = false;
  afterEmail: Email = new Email();
  notVerified: boolean = false;
  txtEmail: string;

  constructor(private loginService: LoginService, private router: Router) {
  }

  ngOnInit() {
    loadLogin();
  }

  sendEmail(): void {
    if (this.email.emailAddress != null) {
      this.email.verNumber = Math.floor((Math.random() * 900000) + 100000);
      this.loginService.sendEmail(this.email).subscribe(
        (result) => {
          this.afterEmail = result;
          if (this.afterEmail.reply == "Email has been sent successfully") {
            // localStorage.setItem("userName", this.email.userName);
            localStorage.setItem("verified", "true");
            this.failed = false;
            this.success = true;
          } else {
            localStorage.setItem("verified", "false");
            this.failed = true;
            this.success = false;
          }
        }
      );
      // loadLogin();
    }
  }

  verifyNumber() {
    if (this.email.verNumber == this.verNumber.nativeElement.value) {
      this.router.navigate(['/root/log-screen/password-reset']);
    } else {
      this.notVerified = true;
    }
  }

  // setEmail() {
  //   if (this.email.userName != "") {
  //     this.txtEmail = 'imalkagunawardana1@gmail.com';
  //   } else {
  //     this.txtEmail = 'Email';
  //   }
  // }
}

