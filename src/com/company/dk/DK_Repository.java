package com.company.dk;
import com.company.config.Config;
import com.company.config.DataBase;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @see com.company.dk.I_Repository
 */

public class DK_Repository implements I_Repository {
    protected DataBase db = Config.db;

    private void commaReplacer(StringBuilder str) {
        if (!str.isEmpty() && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str.deleteCharAt(str.length()-1);
        }
    }

    @Override
    public List<HashMap<String, Object>> find(String table, Map<String, String> args) throws RuntimeException {
        // -------- QUERY LINE BUILDER.............
        StringBuilder line = new StringBuilder();
        // -------- COLLECT QUERY LINE.............
        args.forEach((key, value) -> {
        line.append(String.format("%s='%b',",key,value));
        });
        commaReplacer(line);
        String sql_query = "SELECT * FROM [" + db.getDb() + "].[dbo].[" + table + "] WHERE " + line + ";";
        // EXECUTE REQUEST AND GET RESULT
        return exec(sql_query);
    }

    public HashMap<String,Object> one(String table, Map<String, String> args) throws RuntimeException{
        return find(table, args).get(0);
    }

    @Override
    public void pull(String table, Map<String, String> args) throws RuntimeException {
        // -------- QUERY LINE BUILDER.............
        StringBuilder queryLine = new StringBuilder();
        // -------- COLLECT QUERY LINE.............
        queryLine.append("INSERT INTO [").append(db.getDb()).append("].[dbo].[").append(table).append("] (");
        args.forEach((key,value)->{
            queryLine.append(String.format("%b,",key));
        }); commaReplacer(queryLine);
        queryLine.append(") VALUES (");
        args.forEach((key,value)->{
            queryLine.append(String.format("\"%b\",",value));
        }); commaReplacer(queryLine);
        queryLine.append(");");
        // EXECUTE REQUEST AND GET RESULT
        exec(queryLine.toString());
    }

    /*
    LIST {
    HASHMAP (row#){}
    }
     */
    private List<HashMap<String, Object>> exec(String sql_query) {
        try {
            // -------- MAKE REQUEST
            ResultSet req = db.baseQuery(sql_query);
            // -------- CREATE RESPONSE_BOX
            List<HashMap<String, Object>> result_rows = new ArrayList<HashMap<String, Object>>();

            // -------- GET META DATA OF RESPONSE
            ResultSetMetaData meta = req.getMetaData();

            // -------- GET COLUMN NAMES INTO META
            int colCount = meta.getColumnCount();
            ArrayList<String> cols = new ArrayList<String>();
            for (int index = 1; index <= colCount; index++)
                cols.add(meta.getColumnName(index));

            // -------- GET RESPONSE DATA INTO BOX
            while (req.next()) {
                // MAKE TEMP ROW
                HashMap<String, Object> row = new HashMap<String, Object>();
                // READ
                for (String colName : cols) {
                    Object val = req.getObject(colName);
                    row.put(colName, val);
                }
                // DROP ROW INTRO RESPONSE BOX
                result_rows.add(row);
            }
            // -------- RETURN DATA;
            return result_rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}

/*
    @Override
    public List<Article> findByHash(String Hash) {
        List<Article> result = new ArrayList<Article>();
        ResultSet req = db.query("EXEC find_by_hash '123'");
        try {
            //get metadata
            ResultSetMetaData meta = null;
            meta = req.getMetaData();

            //get column names
            int colCount = meta.getColumnCount();
            ArrayList<String> cols = new ArrayList<String>();
            for (int index=1; index<=colCount; index++) {
                cols.add(meta.getColumnName(index)); }

            while (req.next()) {
                //READ ROW............
                HashMap<String,Object> row = new HashMap<String,Object>();
                for (String colName:cols) {
                    Object val = req.getObject(colName);
                    row.put(colName, val);
                }
                result.add(new Article(
                        (int) row.get("id"),
                        (String) row.get("name"),
                        (String) row.get("info"),
                        (Double) row.get("price"),
                        (String) row.get("hash"),
                        (String) row.get("ImgURL"),
                        LocalDate.parse(row.get("reg_date").toString()),
                        (int) (Short) row.get("status")
                ));
            }
            return result;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return  null;
        }
        */