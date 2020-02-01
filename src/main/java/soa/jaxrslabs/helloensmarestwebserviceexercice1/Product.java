package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;

@Path("product")
public class Product {
    public Product() {

    }

    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public String get(@PathParam("id") String id) {
        String result = null;
        try {
            System.out.println("connexion en cours ...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(Queries.URL, Queries.login, Queries.password); //("jdbc:mysql://localhost:3306/product", "root", "");
            System.out.println("connexion etablie !");
            Statement st = cn.createStatement();

            if (id.equals("")) {
                result = "" + Queries.exeQuerries(Queries.SELECT, st);
                System.out.println(result);
                st.close();
                cn.close();
                return result;
            }

            if (!id.equals("")) {
                String NewQuerry = Queries.GetInfo + id + ";";
                result = "" + Queries.exeQuerries(NewQuerry, st);
                System.out.println(result);
                st.close();
                cn.close();
                return result;
            }

        } catch (Exception e) {
            System.out.println("Erreur");
            e.printStackTrace();

        }

        return result;

    }


    @PUT
    @Path("/{nom}")
    @Produces("application/xml")
    public boolean put(@PathParam("nom") String nom) {

        try {
            System.out.println("connexion en cours ...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(Queries.URL, Queries.login, Queries.password); //("jdbc:mysql://localhost:3306/product", "root", "");
            System.out.println("connexion etablie !");
            Statement st = cn.createStatement();

            String querry = Queries.UpdateNom + nom + ";";
            Queries.exeQuerries(querry, st);
            st.close();
            cn.close();
            return true;

        } catch (Exception e) {
            System.out.println("Erreur");
            e.printStackTrace();

        }
        return false;
    }


}