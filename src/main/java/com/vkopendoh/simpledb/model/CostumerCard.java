package com.vkopendoh.simpledb.model;

public class CostumerCard {
    private String costumerName;
    private String costumerMAC;
    private String serviceMAC;
    private int pillarNumber;
    private int onuNumber;
    private String ip;

    public CostumerCard(String costumerName, String costumerMAC, String serviceMAC,
                        int pillarNumber, int onuNumber, String ip) {
        this.costumerName = costumerName;
        this.costumerMAC = costumerMAC;
        this.serviceMAC = serviceMAC;
        this.pillarNumber = pillarNumber;
        this.onuNumber = onuNumber;
        this.ip = ip;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerMAC() {
        return costumerMAC;
    }

    public void setCostumerMAC(String costumerMAC) {
        this.costumerMAC = costumerMAC;
    }

    public String getServiceMAC() {
        return serviceMAC;
    }

    public void setServiceMAC(String serviceMAC) {
        this.serviceMAC = serviceMAC;
    }

    public int getPillarNumber() {
        return pillarNumber;
    }

    public void setPillarNumber(int pillarNumber) {
        this.pillarNumber = pillarNumber;
    }

    public int getOnuNumber() {
        return onuNumber;
    }

    public void setOnuNumber(int onuNumber) {
        this.onuNumber = onuNumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "CostumerCard{" +
                "costumerName='" + costumerName + '\'' +
                ", costumerMAC='" + costumerMAC + '\'' +
                ", serviceMAC='" + serviceMAC + '\'' +
                ", pillarNumber=" + pillarNumber +
                ", onuNumber=" + onuNumber +
                ", ip='" + ip + '\'' +
                '}';
    }
}
