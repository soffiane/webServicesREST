package booktrainrestwebserviceexercice2;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Date: October 2014
 */
@Path("/trains")
@Produces("application/xml")
public class TrainResource {

    public TrainResource() {
    }

    @GET
    public List<Train> getTrains() {
        System.out.println("getTrains");

        return BookTrainBD.getTrains();
    }

    @GET
    @Path("numTrain-{id}")
    public Train getTrain(@PathParam("id") String numTrain) {
        System.out.println("getTrain");

        for (Train current : BookTrainBD.getTrains()) {
            if (numTrain.equals(current.getNumTrain())) {
                return current;
            }
        }
        return null;
    }

    @GET
    @Path("/search")
    public List<Train> searchTrainsByCriteria(@QueryParam("departure") String departure, @QueryParam("arrival") String arrival, @QueryParam("arrivalhour") String arrivalHour) {
        System.out.println("searchTrainsByCriteria");

        return BookTrainBD.getTrains().subList(0, 2);
    }

    @Path("/booktrains")
    public BookTrainResource getBookTrainResource() {
        return new BookTrainResource();
    }
}

