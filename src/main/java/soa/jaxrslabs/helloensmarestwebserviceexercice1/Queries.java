package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import java.sql.*;

public class Queries {
    static String URL="jdbc:mysql://e-srvlamp:3306/s133207";
    static String login="s133207";
    static String password="gqy42mb";
    static String SELECT ="SELECT COUNT (*) FROM product ";
    static String GetInfo = "SELECT * from product WHERE ";
    static String UpdateNom = "UPDATE product SET name =  ";

    static int exeQuerries(String select, Statement st){
        try{
            ResultSet contenuTab=st.executeQuery(select);
            System.out.println("fzefzegf"+contenuTab.toString());
            return contenuTab.getInt(1);



        }catch(SQLException e){
            System.out.println("Erreur dans testSelect");
            e.printStackTrace();
        }
        return -1;
    }



}