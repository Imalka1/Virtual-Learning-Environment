import {Injectable} from '@angular/core';

import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";
import {Degree} from "../../../dtos/degree";
import {environment} from "../../../../environments/environment";

const URL = "/api/v1/degree";

@Injectable()
export class DegreeService {

  constructor(private http: HttpClient) {
  }

  loadCoursesViaFaculty(faculty: string): Observable<Array<Degree>> {
    return this.http.get<Array<Degree>>(environment.backend_url + URL + "/coursesViaFaculty?faculty=" + faculty);
  }

  getGraduationTypeAndFee(degree: string): Observable<Degree> {
    return this.http.get<Degree>(environment.backend_url + URL + "/graduationTypeAndFee?degree=" + degree);
  }

  getCourseFee(degree: string): Observable<Degree> {
    return this.http.get<Degree>(environment.backend_url + URL + "/courseFee?degree=" + degree);
  }
}
