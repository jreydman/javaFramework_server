package com.company.config;

import com.company.Reader;

import java.util.HashMap;

public class Config {

    //    DATABASE..............
    public static DataBase db;
    protected HashMap<String, String> dbInfo = new HashMap<String, String>();
    protected String Reader_Type;
    public void setDbInfo() {
        this.dbInfo.put("hostname","home-server"); //HOSTNAME
        this.dbInfo.put("port","1433"); //PORT
        this.dbInfo.put("db","JavaServer"); //DB
        this.dbInfo.put("username","sa"); //USERNAME
        this.dbInfo.put("password","cfif2608_00"); //PASSWORD
    }
    //    READER...........
    public void setReader(String reader_Type)
    {
        this.Reader_Type=reader_Type;
    }

    public String getReader()
    {
        return this.Reader_Type;
    }

    protected void DB()
    {
        setDbInfo();
        if(!dbInfo.isEmpty()) db = new DataBase(
                dbInfo.get("hostname"),
                dbInfo.get("port"),
                dbInfo.get("db"),
                dbInfo.get("username"),
                dbInfo.get("password")
                );
      //  db.Connect();
    }
    public Config()
    {
        DB();
    }
}
