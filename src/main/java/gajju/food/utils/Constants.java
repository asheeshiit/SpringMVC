package gajju.food.utils;

/**
 * Created by Asheesh.Mahor on 22-09-2015.
 */
public class Constants {

    public static final String CATOGORY_SOUTHINDIAN = "CREATE TABLE IF NOT EXISTS wls.advsectionv2 ( clientid bigint, date timestamp, siteid bigint, lineitemid bigint, sectionid text, click bigint, impr bigint, spend double, PRIMARY KEY ((clientid, date), siteid, lineitemid, sectionid));";
    public static final String TABALE_NAME = "advsectionv2";
    public static final String CLIENTID = "clientid";
}
