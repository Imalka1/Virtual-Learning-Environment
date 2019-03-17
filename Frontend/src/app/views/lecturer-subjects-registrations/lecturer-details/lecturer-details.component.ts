import { Component, OnInit } from '@angular/core';
import  "../../../../assets/js/data-tables.js";
import {Router} from "@angular/router";
import {WizardColorService} from "../../../services/common/wizard-color/wizard-color.service";

declare var loadDatatable: any;

@Component({
  selector: 'app-lecturer-details',
  templateUrl: './lecturer-details.component.html',
  styleUrls: ['./lecturer-details.component.css']
})
export class LecturerDetailsComponent implements OnInit {

  constructor(private router: Router ,private wizardColor: WizardColorService) {

  }

  ngOnInit() {
    loadDatatable();
  }

  nextPage(): void {
    this.wizardColor.setLecturerWizardGreen(1);
    this.router.navigate(['/main/lecturers-subjects/subject-details'], {queryParams: {studentId: 'S001'}});
    window.scrollTo(0, 0);
  }
}
