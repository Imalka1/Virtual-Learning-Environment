import {Injectable} from '@angular/core';
import {Subject} from "rxjs/index";
import {environment} from "../../../../environments/environment";
import SockJS from "sockjs-client"
import * as Stomp from '@stomp/stompjs';
import {CookieXSRFStrategy} from "@angular/http";

@Injectable({
  providedIn: 'root'
})
export class SocketService {
  private socket;
  private stompClient;
  private established: boolean = false;
  onlineCount: Subject<number> = new Subject<number>();
  websiteVisits: Subject<number> = new Subject<number>();

  // isSidebarVisible: boolean;

  public initSocket(): void {
    this.socket = new SockJS(environment.backend_url + "/lms-web-socket");
    this.stompClient = Stomp.over(this.socket);
    this.stompClient.debug = null
    let that = this;
    this.stompClient.connect({}, function () {
      that.stompClient.subscribe('/topic/greetings1', function (user) {
        console.log("ACC1")
      });
      that.stompClient.subscribe('/topic/greetings2', function (user) {
        console.log("ACC2")
      });
      that.stompClient.subscribe('/topic/onlineCount', function (socket) {
        that.onlineCount.next(JSON.parse(socket.body).onlineCount);
        // new DashboardComponent().setOnlineCount(JSON.parse(socket.body).onlineCount);
      });
      that.stompClient.subscribe('/topic/websiteVisits', function (socket) {
        that.websiteVisits.next(JSON.parse(socket.body).websiteVisits);
      });
      that.stompClient.subscribe('/topic/sessionId', function (socket) {
        that.websiteVisits.next(JSON.parse(socket.body).sessionId);
      });
      that.stompClient.send("/app/online",{'token': localStorage.getItem('token')});
      that.established = true;
    });
  }

  public send(): void {
    this.stompClient.send("/app/hello2");
  }

  public sendOnlineMessage(): void {
    if (this.established) {
      this.stompClient.send("/app/online");
    }
  }

  public sendOfflineMessage(): void {
    this.stompClient.send("/app/offline");
  }
}
