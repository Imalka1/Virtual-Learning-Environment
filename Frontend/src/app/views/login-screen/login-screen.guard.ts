import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {LoginService} from "../../services/login-screen/login/login.service";

@Injectable({
  providedIn: 'root'
})
export class LoginScreenGuard implements CanActivate {
  constructor(private loginService: LoginService,
              private router: Router) {
  };

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.loginService.isAuthenticated()) {
      this.router.navigate(['/root/dashboard']);
      return false;
    }
    return true;
  }
}
