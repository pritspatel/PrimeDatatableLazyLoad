package com.prits.backend.web;

import com.prits.backend.entity.Customer;
import com.prits.backend.repo.CustomerRepo;
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

    @RequestMapping(value = "/customers/", params = { "page", "size" }, method = RequestMethod.GET)
    public @ResponseBody  List<Customer> getAllCustomer(@RequestParam( "page" ) int page, @RequestParam( "size" ) int size){
        return repo.getAllCustomer(page,size);
    }

    @RequestMapping(value = "/customers/count")
    public @ResponseBody Integer getTotalRecords(){
        return repo.getTotalCount();
    }
}
