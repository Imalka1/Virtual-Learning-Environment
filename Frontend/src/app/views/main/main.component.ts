import {Component, OnInit} from '@angular/core';
import "../../../assets/js/material-dashboard98f3.js";
import {SafeResourceUrl} from '@angular/platform-browser';
import {Renderer2} from '@angular/core';
import {NgZone} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {LoginStatus} from "../../classes/login-status";
import {LoginService} from "../../services/login-screen/login/login.service";
import {WizardColorService} from "../../services/common/wizard-color/wizard-color.service";
import {SocketService} from "../../services/common/socket/socket.service";
import {filter} from "rxjs/internal/operators";

declare var loadMaterials: any;

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  userName: string = localStorage.getItem('userName');
  imagePath: SafeResourceUrl;
  path: string = localStorage.getItem('image');

  constructor(private renderer: Renderer2, private router: Router, private ngZone: NgZone, private loginService: LoginService, private wizardColor: WizardColorService, private socketService: SocketService) {
    this.router.events.pipe(filter(event=>event instanceof NavigationEnd)).subscribe(()=>window.scrollTo(0, 0));
    router.events.subscribe(() => {
      this.isInLoginPage();
    });
    window.onresize = (e) => {
      this.ngZone.run((w) => {
        this.checkSize();
      });
    };
    loadMaterials();
  }

  ngOnInit() {
    this.setProfileImage();
  }

  compoDashboardIsActive(): string {
    if (this.router.isActive('/root/main/dashboard', false)) {
      return 'active';
    }
    return '';
  }

  compoStudentIsActive(): string {
    if (this.router.isActive('/root/main/student-reg', false)) {
      return 'active';
    }
    return '';
  }

  compoLecturerIsActive(): string {
    if (this.router.isActive('/root/main/lecturers-subjects', false)) {
      return 'active';
    }
    return '';
  }

  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }

  login() {
    this.router.navigate(['/root/log-screen/login']);
  }

  unlock() {
    this.router.navigate(['/root/log-screen/lock']);
  }

  logout() {
    let accType = localStorage.getItem("accountTypeForLogin");
    localStorage.clear();
    localStorage.setItem("accountTypeForLogin", accType);
    this.router.navigate(['/root/log-screen/login']);
  }

  lock() {
    localStorage.removeItem('login');
    localStorage.setItem('accountType', 'locked');
    this.router.navigate(['/root/log-screen/lock']);
  }

  isInLoginPage(): boolean {
    return this.router.url.includes('login') || this.router.url.includes('lock');
  }

  checkSize(): boolean {
    return window.innerWidth >= 991;
  }

  setProfileImage() {
    if (localStorage.getItem('profile-image') != "images/No") {
      this.imagePath = this.loginService.getProfileImage();
    } else {
      this.imagePath = "assets/img/faces/User.png";
    }
  }

  refreshPage() {
    this.wizardColor.setStudentWizardGreen(0);
  }
}
