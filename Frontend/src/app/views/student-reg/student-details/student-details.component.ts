import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {LoginStatus} from "../../../classes/login-status";
import {FormGroup, NgForm} from "@angular/forms";
import {Student} from "../../../dtos/student";
import "../../../../assets/js/data-tables.js";
import "../../../../assets/js/material-dashboard98f3.js";
import {NavigationEnd, Router} from "@angular/router";
import {StudentDetailsService} from "../../../services/student-reg/student-details/student-details.service";
import {StudentRegistrationService} from "../../../services/student-reg/student-registration/student-registration.service";
import {HttpClient} from "@angular/common/http";
import {WizardColorService} from "../../../services/common/wizard-color/wizard-color.service";
import {SocketService} from "../../../services/common/socket/socket.service";
import {FileService} from "../../../services/common/file/file.service";
import {filter} from "rxjs/internal/operators";

declare var loadMaterials: any;

declare var loadDatatable: any;

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  @ViewChild('fileInput') inputEl: ElementRef;
  p: number = 1;
  telephonePattern = "^[0-9]{3}-[0-9]{7}$";
  loadDataTableCount: number = 0;
  selectedRow: string = "";
  size: string;
  form: FormGroup;
  student: Student = new Student();
  students: Array<Student> = new Array();
  inputs: Array<boolean> = [false, false, false, false, false, false];

  constructor(private router: Router, private studentDetailsService: StudentDetailsService, private studentRegistrationService: StudentRegistrationService, private s: StudentDetailsService, private http: HttpClient, private fileService: FileService, private wizardColor: WizardColorService, private so: SocketService) {
  }

  ngOnInit() {
    if (this.loginStatus() == 2) {
      this.loadStudentData();
    } else {
      this.loadAllStudentData();
      this.setFromLocalStorage();
    }
  }

  /*Save student*/
  saveStudent(): void {
    if (this.student.studentID != undefined && this.loginStatus() == 1) {
      this.studentRegistrationService.updateStudent(this.student).subscribe((result) => {
        if (result) {
          this.loadAllStudentData();
        }
      });
    } else {
      this.nextPage();
    }
  }

  /*Go to next page and submit data*/
  nextPage(): void {
    this.wizardColor.setStudentWizardGreen(1);
    this.studentRegistrationService.setStudent(this.student);
    this.router.navigate(['/root/main/student-reg/student-registrations']);
  }

  resetId() {
    this.student = new Student();
    this.student.title = "Mr";
    this.student.gender = "Male";
  }

  /*--------------------------------------------Get data from fields----------------------------------------------------*/

  /*Save to local storage*/
  saveToLocalStorage() {
    let student_details: any[] = [this.student.title, this.student.nameWithInitials, this.student.fullName, this.student.address, this.student.dateOfBirth, this.student.email, this.student.telephone, this.student.gender];
    for (let i = 0; i < student_details.length; i++) {
      if (student_details[i] != null) {
        if (student_details[i] != "") {
          localStorage.setItem('student-details' + i, student_details[i]);
        }
      }
    }
  }

  /*---------------------------------------------Set data to fields-----------------------------------------------------*/

  /*Set fields from local storage*/
  setFromLocalStorage() {
    if (localStorage.getItem('student-details0') == null) {
      this.student.title = "Mr";
    } else {
      this.student.title = localStorage.getItem('student-details0');
    }
    this.student.nameWithInitials = localStorage.getItem('student-details1');
    this.student.fullName = localStorage.getItem('student-details2');
    this.student.address = localStorage.getItem('student-details3');
    this.student.dateOfBirth = localStorage.getItem('student-details4');
    this.student.email = localStorage.getItem('student-details5');
    this.student.telephone = localStorage.getItem('student-details6');
    if (localStorage.getItem('student-details7') == null) {
      this.student.gender = "Male";
    } else {
      this.student.gender = localStorage.getItem('student-details7');
    }
  }

  /*Set gender radio options*/
  setGender(value: string) {
    this.student.gender = value;
    this.saveToLocalStorage();
  }

  /*Load data to fields (only in student login)*/
  loadStudentData() {
    this.studentDetailsService.getStudentData(localStorage.getItem('userId')).subscribe(
      (result) => {
        this.student = result;
      }
    )
  }

  /*Load data to table (only in admin login)*/
  loadAllStudentData() {
    this.studentRegistrationService.getAllStudentData().subscribe(
      (result) => {
        this.students = result;
        if (this.loadDataTableCount == 0) {
          loadDatatable();
        }
        this.loadDataTableCount++;
      }
    )
  }

  /*Load data to fields (when click on table)*/
  selectStudent(tableData: Student) {
    this.selectedRow = tableData.studentID;
    this.studentDetailsService.getStudentData(tableData.studentID).subscribe(
      (result) => {
        this.student = result;
      }
    );
  }

  /*--------------------------------------------Booleans----------------------------------------------------------------*/

  /*Get login status*/
  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }

  upload() {
    let inputEl: HTMLInputElement = this.inputEl.nativeElement;
    let fileCount: number = inputEl.files.length;
    let formData = new FormData();
    if (fileCount > 0) { // a file was selected
      formData.append('pathUrl', 'pdf');
      for (let i = 0; i < fileCount; i++) {
        formData.append('file', inputEl.files.item(i), inputEl.files.item(i).name);
      }
      // formData.append('file', inputEl.files.item(0), inputEl.files.item(0).name);
      this.size = (inputEl.files.item(0).size / 1024 / 1024).toFixed(2)
      this.fileService.uploadFile(formData)
    }
  }

  /*Check required inputs*/
  // checkInputs(f: NgForm): boolean {
  //   f.form.value.txtStudentNameInit == null ? this.inputs[0] = true : f.form.value.txtStudentNameInit == "" ? this.inputs[0] = true : this.inputs[0] = false;
  //   f.form.value.txtStudentFullName == null ? this.inputs[1] = true : f.form.value.txtStudentFullName == "" ? this.inputs[1] = true : this.inputs[1] = false;
  //   f.form.value.txtAddress == null ? this.inputs[2] = true : f.form.value.txtAddress == "" ? this.inputs[2] = true : this.inputs[2] = false;
  //   f.form.value.txtDateOfBirth == null ? this.inputs[3] = true : f.form.value.txtDateOfBirth == "" ? this.inputs[3] = true : this.inputs[3] = false;
  //   f.form.value.txtEmailAddress == null ? this.inputs[4] = true : f.form.value.txtEmailAddress == "" ? this.inputs[4] = true : this.inputs[4] = false;
  //   f.form.value.txtTelephone == null ? this.inputs[5] = true : f.form.value.txtTelephone == "" ? this.inputs[5] = true : this.inputs[5] = false;
  //   if (!this.inputs[0] && !this.inputs[1] && !this.inputs[2] && !this.inputs[3] && !this.inputs[4] && !this.inputs[5]) {
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }
}
