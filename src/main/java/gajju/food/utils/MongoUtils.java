package gajju.food.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.context.annotation.PropertySource;

import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@PropertySource("classpath:mongo.properties")
public class MongoUtils {
	private static final Logger logger = Logger.getLogger(MongoUtils.class.getSimpleName());

	public static MongoClient getMongoInstance(String host) {
		logger.info(MongoUtils.class.getSimpleName() + ".getMongoInstance()");

		MongoClientOptions mo = new MongoClientOptions.Builder().connectionsPerHost(2).threadsAllowedToBlockForConnectionMultiplier(2).socketTimeout(60000000).build();

		MongoClient mongo = null;
		try {
			mongo = new MongoClient(host, mo);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return mongo;
	}
	
	public static Set<Long> getidFieldLong(String host,String db, String collection) {
		Set<Long> idField = new HashSet<Long>();
		MongoClient mongoClient = getMongoInstance(host);
		DBCollection dbCollection = mongoClient.getDB(db).getCollection(collection);
		
		DBCursor dbCursor = dbCollection.find(new BasicDBObject(), new BasicDBObject("_id", 1)).addOption(Bytes.QUERYOPTION_NOTIMEOUT);
		for (DBObject dbObject : dbCursor) {
			BasicDBObject basicDBObject = (BasicDBObject) dbObject;
			idField.add(basicDBObject.getLong("_id"));
		}
		return idField;
	}
		
		public static Set<Long> getidFieldLong(DB db, String collection) {
			Set<Long> idField = new HashSet<Long>();
			DBCollection dbCollection = db.getCollection(collection);
			
			DBCursor dbCursor = dbCollection.find(new BasicDBObject(), new BasicDBObject("_id", 1)).addOption(Bytes.QUERYOPTION_NOTIMEOUT);
			for (DBObject dbObject : dbCursor) {
				BasicDBObject basicDBObject = (BasicDBObject) dbObject;
				idField.add(basicDBObject.getLong("_id"));
			}
		return idField;
	}
}
