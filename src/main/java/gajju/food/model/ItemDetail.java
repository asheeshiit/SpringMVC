package gajju.food.model;

import com.mongodb.BasicDBObject;
import gajju.food.utils.CRCGenerator;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * Created by Asheesh.Mahor on 18-09-2015.
 */
public class ItemDetail {

    public static final String TABALE_NAME = "items";
    public static final String DB = "food";

    public static final String ITEM_ID = "_id";
    public static final String ITEM_NAME = "item";
    public static final String CATAGORY_CODE = "cat";
    public static final String PRICE = "price";
    public static final String CALORY = "calory";
//    public static final String USER_RATING = "rating";
//    public static final String RATING_ID = "ratid";
    public static final String ACTIVE = "active";
    public static final String PACKING_CHARGES = "pkchrg";
    public static final String DEAL_ACTIVE = "deal";
    public static final String FAT_DETAIL = "fdetail";
    public static final String IS_DRINK = "isdrink";
    public static final String IMAGE_URL = "img";
    public static final String ITEM_DETAIL = "dtls";

    public static final String PRIORITY = "priority";
    public static final String EXPECTED_COOK_TIME = "ctime";
    public static final String EXTRA_DETAIL = "_id";
    public static final String UDATE = "udate";

    private long _id;
    private String item;
    private int cat;
    private int price;
    private int calory;
    private boolean active;
    private int pkchrg;
    private long deal;
    private int fdetail;
    private boolean isdrink;
    private String img;
    private String dtls;
    private int priority;
    private int ctime;
    private Date udate;

    public static long getid(String item, String catagory,String subcatagoty){
        long id = CRCGenerator.getCode(item+"-"+catagory+"-"+subcatagoty);
        return id;
    }
    public ItemDetail(BasicDBObject basicDBObject) {
        this._id = basicDBObject.getLong("_id");
        this.item = basicDBObject.getString("item");
        this.cat = basicDBObject.getInt("cat");
        this.price = basicDBObject.getInt("price");
        this.calory = basicDBObject.getInt("calory");
        this.active = basicDBObject.getBoolean("active");
        this.pkchrg = basicDBObject.getInt("pkchrg");
        this.deal = basicDBObject.getLong("deal");
        this.fdetail = basicDBObject.getInt("fdetail");
        this.isdrink = basicDBObject.getBoolean("isdrink");
        this.img = basicDBObject.getString("img");
        this.dtls = basicDBObject.getString("dtls");
        this.priority = basicDBObject.getInt("priority");
        this.ctime = basicDBObject.getInt("ctime");
        this.udate = basicDBObject.getDate("udate");
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}

