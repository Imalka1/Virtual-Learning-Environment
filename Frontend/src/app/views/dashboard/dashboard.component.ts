import {Component, OnInit} from '@angular/core';
import {DatePipe} from "@angular/common";
import {LoginStatus} from "../../classes/login-status";
import {LoginService} from "../../services/login-screen/login/login.service";
import {SocketService} from "../../services/common/socket/socket.service";
import {Router} from "@angular/router";
import {SafeResourceUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private onlineCount: number = 0;
  private websiteVisits: number = 0;
  imagePath: SafeResourceUrl;
  userName: string = localStorage.getItem('userName');
  textLock: string;

  constructor(private datePipe: DatePipe, private socketService: SocketService, private router: Router, private loginService: LoginService) {
    socketService.onlineCount.subscribe((value) => {
      this.onlineCount = value;
    });
    socketService.websiteVisits.subscribe((value) => {
      this.websiteVisits = value;
    });
  }

  login() {
    this.router.navigate(['/root/log-screen/login']);
  }

  ngOnInit() {
    this.setProfileImage();
    this.socketService.sendOnlineMessage();
    if (LoginStatus.getLoginStatus() != 4) {
      this.textLock = "Lock";
    } else {
      this.textLock = "Unlock";
    }
  }

  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }

  setProfileImage() {
    if (localStorage.getItem('profile-image') != "images/No") {
      this.imagePath = this.loginService.getProfileImage();
    } else {
      this.imagePath = "../../../assets/img/faces/User.png";
    }
  }

  getYear(): string {
    let latest_date = this.datePipe.transform(new Date(), 'yyyy');
    return latest_date;
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

  routeToFree() {
    if (LoginStatus.getLoginStatus() == 4 || LoginStatus.getLoginStatus() == 5) {
      this.router.navigate(['/root/main/student-reg/student-details']);
    }
  }

  routeToAdmin() {
    if (LoginStatus.getLoginStatus() == 1) {
      this.router.navigate(['/root/main/student-reg/student-details']);
    }
  }

  routeToStudent() {
    if (LoginStatus.getLoginStatus() == 2) {
      this.router.navigate(['/root/main/student-reg/student-details']);
    }
  }

  routeToLecturer() {
    if (LoginStatus.getLoginStatus() == 3) {
      this.router.navigate(['/root/main/student-reg/student-details']);
    }
  }
}

// , private cookieService: CookieService, private socketService: SocketService
