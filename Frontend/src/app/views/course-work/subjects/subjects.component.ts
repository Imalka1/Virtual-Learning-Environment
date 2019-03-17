import { Component, OnInit } from '@angular/core';
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {

  constructor(private datePipe: DatePipe) { }

  ngOnInit() {
  }

  getYear(): string {
    let latest_date = this.datePipe.transform(new Date(), 'yyyy');
    return latest_date;
  }
}
