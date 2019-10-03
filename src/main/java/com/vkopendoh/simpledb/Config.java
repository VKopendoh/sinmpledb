package com.vkopendoh.simpledb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String PROP_FILE = "/simpledb.properties";
    private static final Config INSTANCE = new Config();

    private String dbUser;
    private String dbUrl;
    private String dbPassword;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = Config.class.getResourceAsStream(PROP_FILE)) {
            Properties props = new Properties();
            props.load(is);
            dbUser = props.getProperty("db.user");
            dbUrl = props.getProperty("db.url");
            dbPassword = props.getProperty("db.password");

        } catch (IOException e) {
            new IllegalStateException("Invalid config file " + PROP_FILE);
        }
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
