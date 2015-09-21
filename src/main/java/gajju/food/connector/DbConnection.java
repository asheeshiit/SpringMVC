package gajju.food.connector;

import com.mongodb.MongoClient;
import org.springframework.stereotype.Repository;

@Repository("dbconn")
public class DbConnection {

	private MongoClient mongoClient;

	public synchronized MongoClient getMongoReplicaInstance1() {
        System.out.print("Mongo start");
		if (mongoClient == null) {
/*
			MongoClientOptions mo = new MongoClientOptions.Builder().connectionsPerHost(connectionsPerHost)
					.threadsAllowedToBlockForConnectionMultiplier(threadsAllowedToBlockForConnectionMultiplier).socketTimeout(socketTimeout)
					.readPreference(ReadPreference.secondaryPreferred()).build();
*/

			mongoClient = new MongoClient("127.0.0.1");
			
//			mongoClient.setReadPreference(ReadPreference.secondary());
		}

		return mongoClient;
	}

}
