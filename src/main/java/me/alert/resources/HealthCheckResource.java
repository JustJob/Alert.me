package me.alert.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yammer.metrics.core.HealthCheck;

@Path("/health")
public class HealthCheckResource extends HealthCheck {

	public HealthCheckResource(String name) {
		super(name);
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
	
	@GET
	@Path("/check")
	@Produces(MediaType.APPLICATION_JSON)
	public String health() {
		return "ok";
	}

}
