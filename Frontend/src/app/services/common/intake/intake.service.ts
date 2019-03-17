import { Injectable } from '@angular/core';
import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {Intake} from "../../../dtos/intake";

const URL = "/api/v1/intake";

@Injectable({
  providedIn: 'root'
})
export class IntakeService {

  constructor(private http: HttpClient) { }

  getAllMonths(): Observable<Array<Intake>> {
    return this.http.get<Array<Intake>>(environment.backend_url + URL + "/intakeMonths",);
  }
}
