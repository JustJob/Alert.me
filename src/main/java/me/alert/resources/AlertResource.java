package me.alert.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import me.alert.dao.AlertDataDao;
import me.alert.dto.AlertDataDto;

@Path("/alert")
public class AlertResource {
	private AlertDataDao alertDao;
	
	public AlertResource(AlertDataDao alertDao) {
		this.alertDao = alertDao;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addNewAlert(AlertDataDto alertData) {
		alertDao.addNewAlert(alertData);
	}
}
