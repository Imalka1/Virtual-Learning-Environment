import { Component, OnInit } from '@angular/core';
import "../../../../assets/js/login/login.js";
declare var loadLogin: any;

@Component({
  selector: 'app-password-reset',
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.css']
})
export class PasswordResetComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    loadLogin();
    localStorage.removeItem("verified");
  }

  sendEmail(){

  }
}
