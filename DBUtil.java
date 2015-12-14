package com.dsgroup.first;


import java.sql.*;
import java.sql.Connection;



public class DBUtil {
    Connection con=null;
    PreparedStatement pstmt = null;
    static DBUtil _instance;

    public static DBUtil getInstance(){
        if(_instance==null){
            _instance = new DBUtil();
        }
        return _instance;
    }

    public Connection getDBConnection() {
       // String status="";
        if(con==null){
            try{
            	Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@//10.1.25.150:1833/SNAP","abhatt", "bhatt$23");
                /*CallableStatement cs=con.prepareCall("call AUTH_CHK(?,?,?)");
   		cs.setString(1,"ABHATT");
   		cs.setString(2,"INV1220");
   		cs.setString(3,status);
   		cs.executeQuery();
   		System.out.println("The process status is : "+status);*/
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            if(con!=null){
                return con;
            }
        }
        return con;
    }
    /*public static void main(String[] args){
		  DBUtil db=new DBUtil();
		  db.getDBConnection();
		    }*/
}
