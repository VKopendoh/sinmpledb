package com.vkopendoh.simpledb.dao;

import com.vkopendoh.simpledb.Config;
import com.vkopendoh.simpledb.model.Costumer;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CostumerDao {

private static final CostumerDao INSTANCE = new CostumerDao();

    private CostumerDao() {
    }

    public static CostumerDao get(){
        return INSTANCE;
    }

    public void save(Costumer costumer){
        try (Connection connection = DriverManager.getConnection(Config.get().getDbUrl(),
                Config.get().getDbUser(),Config.get().getDbPassword())) {

            connection.setAutoCommit(false);

            try {
                try(PreparedStatement ps = connection.prepareStatement(
                        "insert into costumer (uuid, full_name) values (?,?)")) {
                    ps.setString(1,costumer.getUuid());
                    ps.setString(2,costumer.getName());
                    ps.execute();
                }catch (SQLException e){
                    connection.rollback();
                }
                costumer.getSessions().forEach(session -> {
                    try(PreparedStatement ps = connection.prepareStatement(
                            "insert into session (costumer_uuid, from_num_to_num, ip, end_time) values (?,?,?,?)")){
                        ps.setString(1,costumer.getUuid());
                        ps.setString(2,session.getFromNumberToNumber());
                        ps.setString(3,session.getIp());
                        LocalDateTime lcd = session.getEndTime();
                        ps.setTimestamp(4,Timestamp.valueOf(lcd));
                        ps.execute();
                    } catch (SQLException e) {
                        try {
                            connection.rollback();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        e.printStackTrace();
                    }
                });
                connection.commit();

            }catch (SQLException e){
                connection.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
