package gajju.food.service;

import com.mongodb.*;
import gajju.food.model.Customer;
import gajju.food.utils.CRCGenerator;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Asheesh.Mahor on 18-09-2015.
 */
@Service
public class CustomerService {
    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private SolrServer solrServer;

    public void insert(BasicDBObject basicDBObject){
        System.out.print("insert");
        try {
            DBCollection dbCollection = mongoClient.getDB(Customer.DB).getCollection(Customer.TABALE_NAME);
            dbCollection.insert(WriteConcern.UNACKNOWLEDGED, basicDBObject);

            Customer customer = new Customer(basicDBObject);
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField(Customer.CLIENT_CODE, customer.get_id());
            doc.addField(Customer.CLIENT_NAME, customer.getName());
            doc.addField(Customer.MOBILE_NO, customer.getMobile());
            doc.addField(Customer.ADDRESS, customer.getAddress());
            solrServer.add(doc);
            solrServer.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("Exception: "+e);
        }

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
