package com.vkopendoh.simpledb.model;

import java.time.LocalDateTime;

public class Session {
    private LocalDateTime endTime;
    private String ip;
    private String fromNumberToNumber;

    public Session(LocalDateTime endTime, String ip, String fromNumberToNumber) {
        this.endTime = endTime;
        this.ip = ip;
        this.fromNumberToNumber = fromNumberToNumber;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFromNumberToNumber() {
        return fromNumberToNumber;
    }

    public void setFromNumberToNumber(String fromNumberToNumber) {
        this.fromNumberToNumber = fromNumberToNumber;
    }
}
