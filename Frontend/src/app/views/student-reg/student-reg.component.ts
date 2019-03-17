import {Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';
import {LoginStatus} from "../../classes/login-status";
import {Router} from "@angular/router";
import {DatePipe} from "@angular/common";
import {WizardColorService} from "../../services/common/wizard-color/wizard-color.service";

@Component({
  selector: 'app-student-reg',
  templateUrl: './student-reg.component.html',
  styleUrls: ['./student-reg.component.css']
})
export class StudentRegComponent implements OnInit {
  @ViewChild('wizardComp') wizardComponent: ElementRef
  accountType: number;
  elementStudent: number;

  constructor(private renderer: Renderer2, private router: Router, private datePipe: DatePipe, private wizardColor: WizardColorService) {
    wizardColor.studentReg.subscribe((value) => {
      this.setElementsGreen(value);
    });
  }

  ngOnInit() {
    this.accountType = LoginStatus.getLoginStatus();
  }

  setElementsGreen(j: number): void {
    let number = 6;
    if (this.loginStatus() == 5) {
      number = 3;
    }
    for (let i = 0; i < number; i++) {
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

  loginStatus(): number {
    return this.accountType;
  }
}
