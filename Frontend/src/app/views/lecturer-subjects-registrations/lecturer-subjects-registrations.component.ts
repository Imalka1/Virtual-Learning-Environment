import {Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';
import "../../../assets/js/material-dashboard98f3.js";
import {Router} from "@angular/router";
import {DatePipe} from "@angular/common";
import {WizardColorService} from "../../services/common/wizard-color/wizard-color.service";

declare var loadMaterials: any;

@Component({
  selector: 'app-lecturer-subjects-registrations',
  templateUrl: './lecturer-subjects-registrations.component.html',
  styleUrls: ['./lecturer-subjects-registrations.component.css']
})
export class LecturerSubjectsRegistrationsComponent implements OnInit {
  @ViewChild('wizardComp') wizardComponent: ElementRef;
  elementLecturer: number;

  constructor(private renderer: Renderer2, private router: Router, private datePipe: DatePipe, private wizardColor: WizardColorService) {
    wizardColor.lecturerReg.subscribe((value) => {
      this.setElementsGreen(value);
    });
  }

  ngOnInit() {
  }

  setElementsGreen(j: number): void {
    for (let i = 0; i < 2; i++) {
      this.renderer.removeClass(this.wizardComponent.nativeElement.children[i], 'tab-color');
      this.renderer.removeClass(this.wizardComponent.nativeElement.children[i], 'completed');
    }
    for (let i = 0; i <= j - 1; i++) {
      this.renderer.addClass(this.wizardComponent.nativeElement.children[i], 'completed')
    }
    this.renderer.addClass(this.wizardComponent.nativeElement.children[j], 'tab-color')
  }

  getYear(): string {
    let latest_date = this.datePipe.transform(new Date(), 'yyyy');
    return latest_date;
  }
}
