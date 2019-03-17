import { Component, OnInit } from '@angular/core';
import {SocketService} from "../../services/common/socket/socket.service";
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit {

  constructor(private socketService: SocketService,private cookieService:CookieService) {
    socketService.initSocket();
  }

  ngOnInit() {
  }

}
