import { Injectable } from '@angular/core';
import {Subject} from "rxjs/index";

@Injectable({
  providedIn: 'root'
})
export class WizardColorService {
  elementLecturer: number = 0;
  studentReg: Subject<number> = new Subject<number>();
  lecturerReg: Subject<number> = new Subject<number>();

  constructor() {
  }

  setStudentWizardGreen(elementStudent: number) {
    this.studentReg.next(elementStudent);
  }

  setLecturerWizardGreen(elementLecturer: number) {
    this.lecturerReg.next(elementLecturer);
  }
}
