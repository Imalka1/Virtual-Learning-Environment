package lk.ijse.vle.dto;

public class SocketDTO {
    private int onlineCount;
    private int websiteVisits;
    private String sessionId;

    public SocketDTO() {
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public int getWebsiteVisits() {
        return websiteVisits;
    }

    public void setWebsiteVisits(int websiteVisits) {
        this.websiteVisits = websiteVisits;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
