package supinfo;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class UserMain {
	public static final URI BASE_URI = getBaseURI();

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/rest/").port(9991).build();
    }

    public static void main(String[] args) {
        ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(User.class, UserService.class);
        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
            server.start();

            System.out.println(String.format("Jersey app started with WADL available at "
                    + "%sapplication.wadl\nHit enter to stop it...",
                    BASE_URI, BASE_URI));
            System.in.read();
            server.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
