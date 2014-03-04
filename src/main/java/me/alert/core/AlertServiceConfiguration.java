package me.alert.core;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class AlertServiceConfiguration extends Configuration {
	@NotEmpty
	@JsonProperty
	private String dbHostName;
	
	@NotEmpty
	@JsonProperty
	private String dbName;

	public String getDbHostName() {
		return dbHostName;
	}

	public String getDBName() {
		return dbName;
	}
	
	
}