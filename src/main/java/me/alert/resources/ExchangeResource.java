package me.alert.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exchanges")
public class ExchangeResource {
	@GET
	@Path("/available")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAvailableExchanges() {
		return "[{\"symbol\": \"btce\", \"display\": \"BTC-E\"}, {\"symbol\": \"mtx\", \"display\": \"Mt. Gox\"}]";
	}
}
