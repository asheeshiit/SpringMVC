package gajju.food.connector;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asheesh.Mahor on 07-10-2015.
 */
@Repository("solrconnet")
public class SolrConnect {
    private String solrServer = "http://10.150.226.50:8983/solr/";
    private String coreName = "customerdetail";

    public SolrServer getSolrServerInstance() {
        System.out.print("Solr connect");
        SolrServer server=null;
        try {
            server = new CommonsHttpSolrServer(solrServer+coreName);
            System.out.print("server"+server.toString());
            }catch (Exception e){
            e.printStackTrace();
            System.out.print("Exception: "+e);
        }
            return server;
        }
    }