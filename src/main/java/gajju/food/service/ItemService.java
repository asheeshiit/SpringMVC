package gajju.food.service;

import com.mongodb.*;
import gajju.food.model.Customer;
import gajju.food.model.ItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Asheesh.Mahor on 24-09-2015.
 */

@Service
public class ItemService {
    @Autowired
    private MongoClient mongoClient;

    private Map<Long,ItemDetail> itemMap;


    public Set<ItemDetail> getAllActiveItemDetail(){
        if(itemMap==null || itemMap.size()==0){
            getAllActiveItemMap();
        }
        return (Set)itemMap.values();
    }


    public ItemDetail getItemDetailItemIDWise(long id){
        if(itemMap==null || itemMap.size()==0){
            getAllActiveItemMap();
        }
        return itemMap.get(id);
    }

    @Cacheable("itemmap")
    public Map<Long,ItemDetail> getAllActiveItemMap(){
        DBCollection dbCollection = mongoClient.getDB(ItemDetail.DB).getCollection(ItemDetail.TABALE_NAME);

        itemMap = new HashMap<Long, ItemDetail>();

        BasicDBObject qrr = new BasicDBObject(ItemDetail.ACTIVE,true);
        DBCursor dbCursor = dbCollection.find(qrr);
        for (DBObject dbObject: dbCursor){
            BasicDBObject basicDBObject = (BasicDBObject)dbObject;
            ItemDetail item= new ItemDetail(basicDBObject);
            itemMap.put(item.get_id(),item);
        }
        return itemMap;
    }

}
