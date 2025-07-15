package bank.management.system;

import java.sql.*;

public class Connect {
    Connection connection;
    Statement statement;
    public Connect(){
       try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","9930776318");
            statement=connection.createStatement();
       }catch(Exception e){
           e.toString();
       }
    }

    public static void main(String[] args) {

    }
}
