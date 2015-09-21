package gajju.food.controller;

import com.mongodb.BasicDBObject;
import gajju.food.model.Customer;
import gajju.food.service.CustomerService;
import gajju.food.utils.CRCGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/food")
public class JSONController {

    @Autowired
    CustomerService customerService;

	@RequestMapping(value = "insert/{name}/{no}/{address}", method = RequestMethod.GET)
	public @ResponseBody
    Customer insertCustomer(@PathVariable String name ,@PathVariable long no, @PathVariable String address) {

        BasicDBObject basicDBObject = new BasicDBObject(Customer.CLIENT_CODE, Customer.getCRCCustomerCode(name, no));
        basicDBObject.put(Customer.CLIENT_NAME,name);
        basicDBObject.put(Customer.MOBILE_NO,no);
        basicDBObject.put(Customer.ADDRESS,address);
        customerService.insert(basicDBObject);

		return new Customer(basicDBObject);

	}

    @RequestMapping(value = "get/{name}/{no}", method = RequestMethod.GET)
    public @ResponseBody
    Customer getCustomerdeatils(@PathVariable String name ,@PathVariable long no) {
        Customer customer = customerService.getCustomerDetails(name,no);
        return customer;

    }

}