package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import java.sql.*;

public class Queries {
    //create database and tables first
    static String URL = "jdbc:mysql://localhost:3308/jersey?serverTimezone=UTC";
    static String login = "root";
    static String password = "root";
    static String SELECT = "SELECT COUNT (*) FROM product ";
    static String GetInfo = "SELECT * from product WHERE ";
    static String UpdateNom = "UPDATE product SET name =  ";

    static int exeQuerries(String select, Statement st) {
        try (ResultSet contenuTab = st.executeQuery(select)) {
            System.out.println("trouve" + contenuTab.toString());
            return contenuTab.getInt(1);
        } catch (SQLException e) {
            System.out.println("Erreur dans testSelect");
            e.printStackTrace();
        }
        return -1;
    }


}