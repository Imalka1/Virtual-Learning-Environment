import {Injectable} from '@angular/core';
import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {Faculty} from "../../../dtos/faculty";

const URL = "/api/v1/faculty";

@Injectable()
export class FacultyService {

  constructor(private http: HttpClient) {
  }

  getAllFaculties(): Observable<Array<Faculty>> {
    return this.http.get<Array<Faculty>>(environment.backend_url + URL + "/facultyNames");
  }
}
