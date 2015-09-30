import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import gajju.food.model.ItemDetail;
import gajju.food.utils.CSVnExcelUtils;
import gajju.food.utils.MongoUtils;
import jxl.Cell;
import jxl.Sheet;

import java.util.*;

/**
 * Created by Asheesh.Mahor on 24-09-2015.
 */
public class InsertItemDataFromExcelSheet {
    public static void main(String [] args){
//    String filepath = args[0];
        String filepath="apc";
        String hostAddress = "127.0.0.1";

        DBCollection dbCollection = MongoUtils.getMongoInstance(hostAddress).getDB(ItemDetail.DB).getCollection(ItemDetail.TABALE_NAME);
        Sheet sheet = CSVnExcelUtils.getExcelSheet(filepath);
//        List<String> fields = new ArrayList<String>();
        Map<Integer,String> fields = new HashMap<Integer, String>();

        for (int i = 0; i < sheet.getRows(); i++) {
            BasicDBObject basicDBObject = new BasicDBObject();
        for (int j = 0; j < sheet.getColumns(); j++) {
            Cell cell = sheet.getCell(j, i);
            if(i==0) {
                fields.put(j,cell.getContents().trim());
                }else{
                basicDBObject.put(fields.get(j).trim(), cell.getContents());
                }

            }
            dbCollection.save(basicDBObject);
        }

    }
}
