import { Component, OnInit } from '@angular/core';
import  "../../../../assets/js/events-calendar.js";
declare var loadCalendar:any;

@Component({
  selector: 'app-events-calendar',
  templateUrl: './events-calendar.component.html',
  styleUrls: ['./events-calendar.component.css']
})
export class EventsCalendarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    loadCalendar();
  }

}
