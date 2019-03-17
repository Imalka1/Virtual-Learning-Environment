import {Component, OnInit} from '@angular/core';
import {DatePipe} from "@angular/common";
import {Router} from "@angular/router";
import "../../../../assets/js/login/login.js";
import {User} from "../../../dtos/user";
import {LoginService} from "../../../services/login-screen/login/login.service";

declare var loadLogin: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  loggedUser = new User();
  failed: boolean = false;
  passwordVisibility: boolean = false;

  constructor(private datePipe: DatePipe, private loginService: LoginService, private router: Router) {
  }

  ngOnInit() {
    loadLogin();
    if (localStorage.getItem("accountTypeForLogin") != null) {
      this.user.accountType = localStorage.getItem("accountTypeForLogin");
    } else {
      this.user.accountType = "admin";
    }
  }

  getLogin(): void {
    this.loginService.getLogin(this.user).subscribe(
      (result) => {
        this.loggedUser = result;
        if (this.loggedUser.authenticate == true) {
          this.failed = false;
          localStorage.clear();
          localStorage.setItem("login", "logged");
          localStorage.setItem("userId", this.loggedUser.userID);
          localStorage.setItem("userName", this.loggedUser.userName);
          localStorage.setItem("accountType", this.loggedUser.accountType);
          localStorage.setItem("accountTypeForLogin", this.loggedUser.accountType);
          localStorage.setItem("profile-image", this.loggedUser.profileImage);
          this.router.navigate(['/root/dashboard']);
        } else {
          this.failed = true;
        }
      }
    );
  }

  passwordVisible() {
    if (this.passwordVisibility == false) {
      this.passwordVisibility = true;
    } else {
      this.passwordVisibility = false;
    }
  }
}
