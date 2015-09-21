package gajju.food.service;

import com.mongodb.*;
import gajju.food.model.Customer;
import gajju.food.utils.CRCGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Asheesh.Mahor on 18-09-2015.
 */
@Service
public class CustomerService {
    @Autowired
    private MongoClient mongoClient;


    public void insert(BasicDBObject basicDBObject){
        System.out.print("insert");
        DBCollection dbCollection = mongoClient.getDB(Customer.DB).getCollection(Customer.TABALE_NAME);
        dbCollection.insert(WriteConcern.UNACKNOWLEDGED,basicDBObject);
    }

    public Customer getCustomerDetails(String customername , Long mobileNo){
        DBCollection dbCollection = mongoClient.getDB(Customer.DB).getCollection(Customer.TABALE_NAME);

        long id = Customer.getCRCCustomerCode(customername, mobileNo);
        BasicDBObject basicDBObject = new BasicDBObject(Customer.CLIENT_CODE,id);
        BasicDBObject cust = (BasicDBObject)dbCollection.findOne(basicDBObject);
        Customer customer = new Customer(cust);
        return customer;
    }

}
