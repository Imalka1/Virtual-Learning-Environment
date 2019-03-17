import { Component, OnInit } from '@angular/core';
import "../../../../assets/js/data-tables.js";
import {Router} from "@angular/router";
import {WizardColorService} from "../../../services/common/wizard-color/wizard-color.service";

declare var loadDatatable: any;

@Component({
  selector: 'app-subjects-details',
  templateUrl: './subjects-details.component.html',
  styleUrls: ['./subjects-details.component.css']
})
export class SubjectsDetailsComponent implements OnInit {

  constructor(private router: Router, private wizardColor: WizardColorService) {
  }

  ngOnInit() {
    loadDatatable();
  }

  previousPage(): void {
    this.wizardColor.setLecturerWizardGreen(0);
    this.router.navigate(['/main/lecturers-subjects/lecturer-details']);
  }
}
