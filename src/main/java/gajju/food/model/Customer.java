package gajju.food.model;

import com.mongodb.BasicDBObject;
import gajju.food.utils.CRCGenerator;

public class Customer {
    public static final String TABALE_NAME = "customerdetail";
    public static final String DB = "food";
    public static final String CLIENT_CODE = "_id";
    public static final String CLIENT_NAME = "name";
    public static final String MOBILE_NO = "mobile";
    public static final String ADDRESS = "address";

    Long _id;

	String name;
	
	long mobile;

    String address;

    public Customer(BasicDBObject basicDBObject) {
        this._id = basicDBObject.getLong(CLIENT_CODE);
        this.name = basicDBObject.getString(CLIENT_NAME);
        this.mobile = basicDBObject.getLong(MOBILE_NO);
        this.address = basicDBObject.getString(ADDRESS);
    }

    public Long get_id() {
        return _id;
    }

    public static long getCRCCustomerCode(String name, Long mobile){
        return CRCGenerator.getCode(name+"-"+mobile);
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}