package me.alert.dao.impl;

import org.mongojack.JacksonDBCollection;

import com.mongodb.MongoException;

import me.alert.dao.AlertDataDao;
import me.alert.dto.AlertDataDto;

public class MongoAlertDataDao implements AlertDataDao {
	JacksonDBCollection<AlertDataDto, String> alertCollection;
	
	public MongoAlertDataDao(JacksonDBCollection<AlertDataDto, String> collection) {
		alertCollection = collection;
	}

	@Override
	public void addNewAlert(AlertDataDto data) {
		try {
			alertCollection.insert(data);
		} catch(MongoException e) {
			System.out.println("could not store in db: " + e);
		}
	}

}
