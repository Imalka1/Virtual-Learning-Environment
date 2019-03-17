import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient, HttpEvent} from "@angular/common/http";

const URL = "/api/v1/user/upload";

@Injectable()
export class FileService {
  uploadedPercentage = 0;

  constructor(private http: HttpClient) {
  }

  uploadFile(formData: FormData) {
    this.http.post(environment.backend_url + URL, formData, {reportProgress: true, observe: 'events'}).subscribe(
      (event: HttpEvent<any>) => {
        if (event.type == 1) {
          if (Math.round(this.uploadedPercentage) !== Math.round(event['loaded'] / event['total'] * 100)) {
            this.uploadedPercentage = event['loaded'] / event['total'] * 100;
            console.log(Math.round(this.uploadedPercentage))
          }
        }
      }
    );
  }
}
