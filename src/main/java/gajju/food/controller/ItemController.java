package gajju.food.controller;

import gajju.food.model.Customer;
import gajju.food.model.ItemDetail;
import gajju.food.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Asheesh.Mahor on 24-09-2015.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

//    @RequestMapping(value = "get/all", method = RequestMethod.GET)
//    public @ResponseBody
//    List<ItemDetail> getAllItemdeatils() {
//        List<ItemDetail> itelst = itemService.getAllActiveItemDetail();
//        return itelst;
//    }

    @RequestMapping(value = "get/{itemName}/{catagotyName}/{subcatagoryname}", method = RequestMethod.GET)
    public @ResponseBody
    ItemDetail getAllItemdeatils(@PathVariable String itemName ,@PathVariable String catagotyName, @PathVariable String subcatagoryname) {
        long id = ItemDetail.getid(itemName,catagotyName,subcatagoryname);
        ItemDetail item = itemService.getItemDetailItemIDWise(id);
        return item;

    }
}
