package booktrainrestwebserviceexercice2;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Date: October 2014
 */
public class BookTrainResource {

    @POST
    public String createBookTrain(@QueryParam("numTrain") String numTrain, @QueryParam("numberPlaces") int numberPlaces) {  	
        Train currentTrain = null;

        for (Train current : BookTrainBD.getTrains()) {
            if (current.getNumTrain().equals(numTrain)) {
                currentTrain = current;
            }
        }
        
        if (currentTrain == null) {
            return "";
        }

        BookTrain newBookTrain = new BookTrain();
        newBookTrain.setNumberPlaces(numberPlaces);
        newBookTrain.setCurrenTrain(currentTrain);
        newBookTrain.setNumBook(Long.toString(System.currentTimeMillis()));

        BookTrainBD.getBookTrains().add(newBookTrain);

        String numBook = newBookTrain.getNumBook();
        System.out.println(numBook);
		return numBook;
    }

    @GET
    public List<BookTrain> getBookTrains() {
        System.out.println("getBookTrains");

        return BookTrainBD.getBookTrains();
    }

    @GET
    @Path("{id}")
    public BookTrain getBookTrain(@PathParam("id") String bookNumber) {
        List<BookTrain> bookTrains = BookTrainBD.getBookTrains();

        for (BookTrain current : bookTrains) {
            if (current.getNumBook().equals(bookNumber)) {
                return current;
            }
        }

        return null;
    }

    @DELETE
    @Path("{id}")
    public void removeBookTrain(@PathParam("id") String bookNumber) {
        BookTrain currentBookTrain = null;
        for (BookTrain current : BookTrainBD.getBookTrains()) {
            if (current.getNumBook().equals(bookNumber)) {
                currentBookTrain = current;
            }
        }

        BookTrainBD.getBookTrains().remove(currentBookTrain);
    }
}
