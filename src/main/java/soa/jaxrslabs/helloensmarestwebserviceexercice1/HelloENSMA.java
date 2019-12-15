package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("helloensma")
public class HelloENSMA {
	public HelloENSMA() { }
	
	@GET
	@Produces("application/xml")
	public String getXml() {
	    return "<bonjour>Bonjour ENSMA</bonjour>";
	}
	
	@GET
	@Path("{id}")
	@Produces("application/xml")
	public String getXmlWithParams(
	        @PathParam("id") String id,
	        @DefaultValue("all") @HeaderParam("name") String name) {
	    System.out.println(id);
	    System.out.println(name);
	    return "<bonjour>Bonjour ENSMA de la part de " + name + "</bonjour>";
	}

}
