package gajju.food.utils;

import java.util.List;

/**
 * Created by Asheesh.Mahor on 23-09-2015.
 * CATAGORY (CATAGORY_CODE, SUBCATALORY_CODE_LIST)
 */
public enum Catagory {
    SOUTH_INDIAN ((short)1,"imgurl"),
    NORTH_INDIAN ((short)2,"imgurl"),
    RAJSISTHANI ((short)3,"imgurl"),
    BIHARI ((short)4,"imgurl"),
    CHINEESE ((short)5,"imgurl"),
    JAPANEE ((short)6,"imgurl"),
    ITALY ((short)7,"imgurl");

    private short code;
    private String imgurl;

    Catagory(short code, String imgurl) {
        this.code = code;
        this.imgurl = imgurl;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
