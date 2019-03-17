import { Component, OnInit } from '@angular/core';
import "../../../../assets/js/login/login.js";
import {User} from "../../../dtos/user";
import {SafeResourceUrl} from "@angular/platform-browser";
import {DatePipe} from "@angular/common";
import {LoginService} from "../../../services/login-screen/login/login.service";
import {Router} from "@angular/router";
declare var loadLogin: any;

@Component({
  selector: 'app-lock',
  templateUrl: './lock.component.html',
  styleUrls: ['./lock.component.css']
})
export class LockComponent implements OnInit {
  user: User = new User();
  failed: boolean = false;
  userName: string = localStorage.getItem('userName');
  imagePath: SafeResourceUrl;
  path: string = localStorage.getItem('image');
  passwordVisibility: boolean = false;

  constructor(private datePipe: DatePipe, private loginService: LoginService, private router: Router) {
  }

  ngOnInit() {
    loadLogin();
    this.setProfileImage();
  }

  getLogin(): void {
    this.user.userID = localStorage.getItem('userId');
    this.loginService.getLogin(this.user).subscribe(
      (result) => {
        this.user = result;
        if (this.user.authenticate == true) {
          this.failed = false;
          localStorage.setItem("login", "logged");
          localStorage.setItem("accountType", this.user.accountType);
          this.router.navigate(['/root/dashboard']);
        } else {
          this.failed = true;
        }
      }
    );
  }

  setProfileImage() {
    if (localStorage.getItem('profile-image') != "images/No") {
      this.imagePath = this.loginService.getProfileImage();
    } else {
      this.imagePath = "../../../../assets/img/faces/User.png";
    }
  }

  passwordVisible() {
    if (this.passwordVisibility == false) {
      this.passwordVisibility = true;
    } else {
      this.passwordVisibility = false;
    }
  }
}

