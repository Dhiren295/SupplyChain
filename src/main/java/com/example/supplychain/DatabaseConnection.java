package com.example.supplychain;
import java.sql.*;
public class DatabaseConnection {
    private static final String DB_URL="jdbc:mysql://localhost:3306/supply_chain";
    private static final  String USER="root";
    private static final String PASS="Dhiren@47";
    public Statement getStatement(){
        Statement statement=null;
        Connection conn;
        try{
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            statement=conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();

        }
        return statement;
    }
    public ResultSet getQueryTable(String query){
        ResultSet rs=null;
        try{
            Statement statement=getStatement();
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
       return  rs;
    }
    public boolean executeQuery(String query){
        try{
            Statement statement=getStatement();
            statement.executeUpdate(query);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }

    public static void main(String[] args) {
        DatabaseConnection dbConn =new DatabaseConnection();
        try{
            String query="select * from product";
            ResultSet rs=dbConn.getQueryTable(query);
            while (rs.next()){
                System.out.println(rs.getInt("pid")+" "+
                        rs.getString("name")+" "+
                        rs.getDouble("price")+" "+
                        rs.getString(2)

                        );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
