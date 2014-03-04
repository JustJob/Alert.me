package me.alert.core;

import org.mongojack.JacksonDBCollection;

import me.alert.dao.AlertDataDao;
import me.alert.dao.impl.MongoAlertDataDao;
import me.alert.dto.AlertDataDto;
import me.alert.resources.AlertResource;
import me.alert.resources.ExchangeResource;
import me.alert.resources.HealthCheckResource;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class AlertService extends Service<AlertServiceConfiguration> {
	private MongoClient client;
	private AlertDataDao alertDao;
	
	public static void main(String[] args) throws Exception {
		String[] serviceArgs = {"server", "src/main/resources/settings.yml"};
		new AlertService().run(serviceArgs);
	}
	
	@Override
	public void initialize(Bootstrap<AlertServiceConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
	}

	@Override
	public void run(AlertServiceConfiguration config, Environment environment)
			throws Exception {
		client = new MongoClient(config.getDbHostName());
		DBCollection dbCollection = client.getDB(config.getDBName()).getCollection("alerts");
		JacksonDBCollection<AlertDataDto, String> collection = JacksonDBCollection.wrap(dbCollection, AlertDataDto.class, String.class);
		alertDao = new MongoAlertDataDao(collection);
		
		environment.addHealthCheck(new HealthCheckResource("Alert.me Health Check"));
		environment.addResource(new HealthCheckResource("Alert.me Health Check"));
		environment.addResource(new ExchangeResource());
		environment.addResource(new AlertResource(alertDao));
	}

}
