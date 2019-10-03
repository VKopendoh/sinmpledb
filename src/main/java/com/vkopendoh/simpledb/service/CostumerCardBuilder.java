package com.vkopendoh.simpledb.service;

import com.vkopendoh.simpledb.model.Costumer;
import com.vkopendoh.simpledb.model.CostumerCard;
import com.vkopendoh.simpledb.model.Session;

import java.util.Comparator;
import java.util.List;

public class CostumerCardBuilder {
    private static String costumerName;
    private static String costumerMAC;
    private static String serviceMAC;
    private static int pillarNumber;
    private static int onuNumber;
    private static String ip;

    private static final Comparator<Session> SESSION_COMPARATOR = Comparator.comparing(Session::getEndTime);

    public static CostumerCard build(Costumer costumer){
        costumerName = costumer.getName();
        Session session = getLastSession(costumer.getSessions());
        String[] splitedFromNumberToNumber = session.getFromNumberToNumber().split("/");
        costumerMAC = splitedFromNumberToNumber[0];
        serviceMAC = splitedFromNumberToNumber[3];
        String[] onuAndPillar = splitedFromNumberToNumber[2].split(":");
        pillarNumber =  Integer.parseInt(onuAndPillar[0]);
        onuNumber = Integer.parseInt(onuAndPillar[1]);
        ip = session.getIp();

        return new CostumerCard(costumerName, costumerMAC,serviceMAC, pillarNumber, onuNumber,ip);
    }

    private static Session getLastSession(List<Session> sessions) {
        sessions.sort(SESSION_COMPARATOR);
        return sessions.get(sessions.size()-1);
    }
}
