package com.vkopendoh.simpledb;

import com.vkopendoh.simpledb.model.Costumer;
import com.vkopendoh.simpledb.model.Session;

import java.time.LocalDateTime;

public class CreateData {

    private static final Costumer COSTUMER = new Costumer("Ivan");
    private static final Session SESSION1 = new Session(LocalDateTime.now(),"10.10.0.1",
            "BOBE767EE4A5B/1000.534/3:6/E067B3AD2520");
    private static final Session SESSION2 = new Session(LocalDateTime.of(2019,5,2,
            10,0),"111.10.0.192",
            "DOVE767EE4A9A/2000.634/2:3/D222B3ADDB10");


    public static Costumer create(){
        COSTUMER.addSession(SESSION1);
        COSTUMER.addSession(SESSION2);
        return COSTUMER;
    }
}
