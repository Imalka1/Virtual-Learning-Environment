import {Injectable} from '@angular/core';
import {environment} from "../../../../environments/environment";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {User} from "../../../dtos/user";
import {Email} from "../../../dtos/email";

const URL = "/api/v1/user";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  accountType: string;

  constructor(private router: Router, private http: HttpClient) {
  }

  getLogin(user: User): Observable<User> {
    return this.http.post<User>(environment.backend_url + URL + "/authenticate", user);
  }

  isAuthenticated(): boolean {
    return localStorage.getItem("login") == 'logged' ? true : false;
  }

  sendEmail(email: Email): Observable<Email> {
    return this.http.post<Email>(environment.backend_url + URL + "/forgotPassword", email);
  }

  getProfileImage(): string {
    return (environment.backend_url + URL + "/file?path=" + localStorage.getItem('profile-image') + "");
  }
}
