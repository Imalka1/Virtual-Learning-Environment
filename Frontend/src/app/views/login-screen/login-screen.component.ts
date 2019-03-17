import { Component, OnInit } from '@angular/core';
import {DatePipe} from "@angular/common";
import {Router} from "@angular/router";
import "../../../assets/js/login/login.js";
import "../../../assets/js/material-dashboard98f3.js";

declare var loadLogin: any;
declare var loadMaterials: any;

@Component({
  selector: 'app-login-screen',
  templateUrl: './login-screen.component.html',
  styleUrls: ['./login-screen.component.css']
})
export class LoginScreenComponent implements OnInit {

  constructor(private datePipe: DatePipe, private router: Router) {
    router.events.subscribe(() => {
      this.getPage();
    });
  }

  ngOnInit() {
    loadMaterials();
    loadLogin();
  }

  getYear(): string {
    let latest_date = this.datePipe.transform(new Date(), 'yyyy');
    return latest_date;
  }

  getPage(): string {
    if (this.router.url.includes('login') || this.router.url.includes('email-verify') || this.router.url.includes('password-reset')) {
      return 'login';
    } else if (this.router.url.includes('lock')) {
      return 'lock';
    }
  }


}
