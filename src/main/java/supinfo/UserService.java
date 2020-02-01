package supinfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Path("/users") - indique l'adresse url relative à celle du projet pour accéder à notre UserService (http://<host>:<port>/RestServer/api/users)
 *
 * @GET - indique que la méthode getUser sera accessible via une requête http GET
 *
 * @Path("/{id}") - indique l'adresse url relative à celle du UserService pour accéder à la méthode getUser (http://<host>:<port>/RestServer/api/users/<id>)
 *
 * @Produces(MediaType.APPLICATION_JSON) - indique que cette méthode devra renvoyer la réponse sous la forme d'un objet JSON.
 *
 * @PathParam("id") - placé juste avant un paramètre de méthode, il permet d'indiquer que le paramètre id de l'url devra être récupérée dans le paramètre de méthode qui suit.
 */
@Path("/users")
public class UserService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser( @PathParam("id") int id ) {
        User user = new User(id, "jdoe", 22);
        return user;
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User postUser( User user ) {
        return user;
    }
}
