package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import java.sql.*;

public class ServerSQL {

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection(Queries.URL,Queries.login,Queries.password);
            Statement st=cn.createStatement();

            /*Question 4*/

            Queries.exeQuerries(Queries.SELECT, st);


                  /*QUESTION 3 : Prepared Statement

                  PreparedStatement st=cn.prepareStatement("INSERT INTO Films VALUES(?,?,?,?);");

                  st.setInt(1,3);
                  st.setString(2,"Seul contre tous");
                  st.setString(3,"Gaspard Noé");
                  st.setInt(4,1995);

                  st.executeUpdate();*/

            /*st.executeUpdate(Queries.CREER_TABLE);*/
            /*st.executeUpdate(Queries.INSERT1);*/
            /*st.executeUpdate(Queries.INSERT2);*/


            st.close();
            cn.close();

        }catch(Exception e){
            System.out.println("Erreur");
        }

    }

}