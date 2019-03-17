package lk.ijse.vle.controller;

import lk.ijse.vle.dto.SocketDTO;
import lk.ijse.vle.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
//@Controller
@EnableScheduling
@CrossOrigin
public class SocketController {
    private Set<String> mySet = new HashSet<>();
    private Set<String> websiteVisitsCount = new HashSet<>();
//    private ArrayList<Date> timeList = new ArrayList<>();
    @Autowired
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/hello1")
    @SendTo("/topic/greetings1")
    public UserDTO greeting1() throws Exception {
//        Thread.sleep(1000); // simulated delay
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("pl");
        return userDTO;
    }

    @MessageMapping("/hello2")
    @SendTo("/topic/greetings2")
    public UserDTO greeting2() throws Exception {
//        Thread.sleep(1000); // simulated delay
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("p2");
        return userDTO;
    }

    @MessageMapping("/online")
    @SendTo({"/topic/onlineCount", "/topic/sessionId"})
    public SocketDTO onlineCount() throws Exception {
        SocketDTO socketDTO = new SocketDTO();
        socketDTO.setOnlineCount(mySet.size());
//        socketDTO.setWebsiteVisits(calculateTime());
        return socketDTO;
    }

    @EventListener
    public void onSessionConnectedEvent(SessionConnectedEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        mySet.add(sha.getSessionId());
        System.out.println(sha.getSessionId());
        System.out.println(event);
//        webSocket.convertAndSend("/topic/onlineCount", socketDTO);
//        boolean add = websiteVisitsCount.add(sha.getSessionId());
//        if (add) {
//            timeList.add(new Date());
//        }
    }

    @EventListener
    public void onSessionDisconnectEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        mySet.remove(sha.getSessionId());
        SocketDTO socketDTO = new SocketDTO();
        socketDTO.setOnlineCount(mySet.size());
        webSocket.convertAndSend("/topic/onlineCount", socketDTO);
    }

//    @Scheduled(fixedRate = 300000)
//    public void getWebsiteVisitsCount() {
//        SocketDTO socketDTO = new SocketDTO();
//        if (calculateTime() == 0) {
//            socketDTO.setWebsiteVisits(mySet.size());
//        } else {
//            socketDTO.setWebsiteVisits(calculateTime());
//        }
//        webSocket.convertAndSend("/topic/websiteVisits", socketDTO);
//    }

//    private int calculateTime() {
//        int count = 0;
//        ArrayList<Date> tempTimeList = (ArrayList<Date>) timeList.clone();
//        for (Date time : tempTimeList) {
//            if (((new Date().getTime() - time.getTime()) / (60 * 1000)) < 6) {
//                count++;
//            } else {
//                timeList.remove(time);
//            }
//        }
//        return count;
//    }

    //    @MessageMapping("/userId")
//    public void addSession(String userDTO){
//        System.out.println(userDTO);
//    }
}
