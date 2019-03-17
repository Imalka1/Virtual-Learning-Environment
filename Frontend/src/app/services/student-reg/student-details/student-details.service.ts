import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs/index";
import {Student} from "../../../dtos/student";
import {environment} from "../../../../environments/environment";
import {map} from "rxjs/internal/operators";

const URL = "/api/v1/student";

@Injectable()
export class StudentDetailsService {

  constructor(private http: HttpClient, private router: Router) {
  }

  // saveStudent(): Observable<boolean> {
  //   return this.http.post<boolean>("", "")
  //     .pipe(
  //       map((result) => {
  //         // sessionStorage.setItem("token", result + "");
  //         if (result) {
  //           this.router.navigate(['/main/student-reg/student-registrations']);
  //         } else {
  //           this.router.navigate(['/main/student-reg/student-registrations']);
  //         }
  //         return result;
  //       })
  //     )
  // }

  getStudentData(studentId: string): Observable<Student> {
    return this.http.get<Student>(environment.backend_url + URL + "/getStudentData?studentId=" + studentId);
  }
}
