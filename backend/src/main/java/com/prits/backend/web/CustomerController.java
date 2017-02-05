package com.prits.backend.web;

import com.prits.backend.dto.PageRequest;
import com.prits.backend.entity.Customer;
import com.prits.backend.repo.CustomerRepo;
import com.prits.backend.vo.CustomerPageRequest;
import com.prits.backend.vo.CustomerPageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by 3ppat on 1/28/2017.
 */
@RestController
public class CustomerController {


    @Autowired
    private CustomerRepo repo;

    @RequestMapping(value = "/customers/", params = { "page", "size", "sortField","sortOrder","filterField","filterValue" }, method = RequestMethod.GET)
    public @ResponseBody  List<Customer> getAllCustomer(@RequestParam( "page" ) int page,
                                                        @RequestParam( "size" ) int size,
                                                        @RequestParam String sortField,
                                                        @RequestParam String sortOrder,
                                                        @RequestParam String filterField,
                                                        @RequestParam String filterValue){
        System.out.println("Sort Field : " + sortField);
        System.out.println("Sort Order : " + sortOrder);
        System.out.println("Filter Field : " + filterField);
        System.out.println("Filter Value : " + filterValue);
        if(sortField == null || sortField.equalsIgnoreCase("undefined")) sortField="CUSTOMER_ID";
        if(sortField.equalsIgnoreCase("firstName")) sortField="FIRST_NAME";
        return repo.getAllCustomer(page,size,sortField,sortOrder, filterField,filterValue);
    }


    @RequestMapping(value = "/customers/search/", method = RequestMethod.POST)
    public @ResponseBody CustomerPageResponse searchCustomer(@RequestBody CustomerPageRequest custPageRequest){
        System.out.println(">>>>>>>>>>>>> Request : " + custPageRequest.toString());
        return repo.searchCustomer(custPageRequest);
    }


    @RequestMapping(value = "/customers/count")
    public @ResponseBody Integer getTotalRecords(){
        return repo.getTotalCount();
    }
}
