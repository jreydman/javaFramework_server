package com.company.config;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataBase {
    protected String hostname;
    protected String port;
    protected String db;
    protected String username;
    protected String password;

    public DataBase(String hostname,String port,String db, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.db = db;
        this.username = username;
        this.password = password;
    }
    private Connection Connect() throws SQLException {
            return DriverManager.getConnection("jdbc:sqlserver://"+this.hostname+":"+this.port,this.username,this.password);
    }

    private void CloseConnection(Connection connection) {
        try { connection.close(); } catch(SQLException se) { se.printStackTrace(); }
    }

    private void CloseStatement(Statement statement) {
        try { statement.close(); } catch(SQLException se) { se.printStackTrace(); }
    }

    public String getDb() { return this.db; }

    public ResultSet baseQuery(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection=Connect();
            statement=connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Object procQuery(String proc, List<String>args) {
        Connection connection = null;
        CallableStatement statement = null;
        try {
            connection=Connect();
            // {call proc(?,?,?)}
            // call find(outResult, Name, Surname)
            // call
            statement=connection.prepareCall(proc);
            statement.registerOutParameter(1,Types.JAVA_OBJECT);
            int ind=2;
                for(String elem : args) {
                    statement.setString(ind,elem);
                    ind++;
            }
            statement.execute();
                return statement.getObject(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
