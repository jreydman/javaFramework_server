package com.company.dk;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface I_Repository {
    public List<HashMap<String, Object>> find(String table, Map<String, String> args) throws RuntimeException;
    public HashMap<String,Object> one(String table, Map<String, String> args) throws RuntimeException;
    public void pull(String table, Map<String,String> args) throws RuntimeException;

}
