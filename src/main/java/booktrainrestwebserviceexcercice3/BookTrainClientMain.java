package booktrainrestwebserviceexcercice3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class BookTrainClientMain extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private WebTarget target;

    public BookTrainClientMain() {
        super("Client Réservation Train");
        try {
            Client client = ClientBuilder.newClient();
            target = client.target("http://localhost:9991").path("rest");

            ResourceConfig rc = new ResourceConfig();
            rc.registerClasses(BookTrain.class, Train.class);

            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(target.getUri(), rc);
            server.start();

            System.out.println(String.format(
                    "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
                    target, target));


            this.setLayout(new GridLayout(3, 1, 10, 10));
            JPanel panelTrains = new JPanel();
            panelTrains.setLayout(new GridLayout(1, 1));

            JButton getTrains = new JButton("GetTrains");
            panelTrains.add(getTrains);
            getTrains.addActionListener(e -> callGetTrains());

            JPanel panelBookTrains = new JPanel();
            panelBookTrains.setLayout(new GridLayout(1, 1));

            JButton getBookTrains = new JButton("GetBookTrains");
            panelBookTrains.add(getBookTrains);
            getBookTrains.addActionListener(e -> callGetBookTrains());

            JPanel createBookTrainFormPanel = new JPanel();
            createBookTrainFormPanel.setLayout(new GridLayout(1, 3));
            final JTextField numTrain = new JTextField();
            final JTextField numberPlaces = new JTextField();
            JButton createBookTrains = new JButton("CreateBookTrain");
            createBookTrains.addActionListener(e -> createBookTrains(numTrain.getText(), numberPlaces.getText()));
            createBookTrainFormPanel.add(createBookTrains);
            createBookTrainFormPanel.add(numTrain);
            createBookTrainFormPanel.add(numberPlaces);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    server.shutdown();
                }
            });

            this.add(panelTrains);
            this.add(panelBookTrains);
            this.add(createBookTrainFormPanel);

            this.pack();
            this.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void callGetTrains() {
        //on lance le webbservice via le code java
        List<Train> result = target.path("trains")
                .request(MediaType.APPLICATION_XML_TYPE).get(new GenericType<List<Train>>() {
                });

        for (Train current : result) {
            System.out.println(current.getNumTrain() + " - "
                    + current.getVilleDepart() + " - "
                    + current.getVilleArrivee() + " - "
                    + current.getHeureDepart());
        }
    }

    private void createBookTrains(String numTrain, String numberPlaces) {
        //on construit l'URI que l'on va appelle via l'objet WebTarger
        String numBook = target.path("trains").path("booktrains")
                .queryParam("numTrain", numTrain)
                .queryParam("numberPlaces", numberPlaces).request()
                .post(null, String.class);
        System.out.println(numBook);
    }

    private void callGetBookTrains() {
        List<BookTrain> result = target.path("trains").path("booktrains")
                .request(MediaType.APPLICATION_XML_TYPE).get()
                .readEntity(new GenericType<List<BookTrain>>() {
                });

        for (BookTrain current : result) {
            System.out.println(current.getNumBook() + " - "
                    + current.getCurrenTrain().getNumTrain() + " - "
                    + current.getNumberPlaces());
        }
    }

    public static void main(String[] args) {
        new BookTrainClientMain();
    }
}
