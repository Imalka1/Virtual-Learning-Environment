import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PasswordResetGuard implements CanActivate {
  constructor(private router: Router) {
  };
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (localStorage.getItem("verified")!="true") {
      this.router.navigate(['/root/log-screen/login']);
      return false;
    }
    return true;
  }
}
