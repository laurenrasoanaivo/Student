package com.exercice.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private Connection c;

    private ConnectionDB(){
        try{
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hei_admin", "postgres", "hihi");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    private static final ConnectionDB connection = new ConnectionDB();
    public static ConnectionDB getConnection(){
        return connection;
    }
    public Statement getStm() throws SQLException{
        return c.createStatement();
    }
}
