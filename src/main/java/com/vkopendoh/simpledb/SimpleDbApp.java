package com.vkopendoh.simpledb;

import com.vkopendoh.simpledb.dao.CostumerDao;
import com.vkopendoh.simpledb.model.Costumer;
import com.vkopendoh.simpledb.model.Session;
import com.vkopendoh.simpledb.service.CostumerCardBuilder;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Set;

public class SimpleDbApp {
    private static CostumerDao costumerDao = CostumerDao.get();

    public static void main(String[] args) {

        Costumer costumer = CreateData.create();
        costumerDao.save(costumer);

        System.out.println(CostumerCardBuilder.build(costumer));

        //Set<String> zoneId = ZoneId.getAvailableZoneIds();
        //zoneId.forEach(z-> System.out.println(z));


        Session session = costumer.getSessions().get(0);
        System.out.println(String.valueOf(new Timestamp(System.currentTimeMillis()).toInstant()));

    }
}
