package com.vkopendoh.simpledb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Costumer {

    private String uuid;
    private String name;
    private List<Session> sessions;

    public Costumer(String name) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session){
        if(sessions == null){
            sessions = new ArrayList<>();
        }
        sessions.add(session);
    }
}
