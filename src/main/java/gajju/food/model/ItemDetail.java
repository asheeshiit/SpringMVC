package gajju.food.model;

import org.mongodb.morphia.annotations.Entity;

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
    public static final String DEAL_ACTIVE = "d";
    public static final String FAT_DETAIL = "fdetail";
    public static final String IS_DRINK = "isdrink";
    public static final String IMAGE_URL = "";
    public static final String ITEM_DETAIL = "mobile";

    public static final String EXPECTED_COOK_TIME = "address";
    public static final String EXTRA_DETAIL = "_id";
    public static final String UDATE = "mobile";

    private long _id;
    private String item;
    private long cat;
    private long price;
    private long calory;
    private long active;
    private long pkchrg;
    private long _id;


}
