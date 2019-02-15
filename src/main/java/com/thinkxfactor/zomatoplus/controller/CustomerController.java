package com.thinkxfactor.zomatoplus.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	Random random = new Random();
    HashMap<Integer, Customer> customerMap = new HashMap<>();
   

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam int id) {
        return customerMap.get(id);
    }
   
    @GetMapping("/getAll")
    public Collection<Customer> getCustomer() {
        return customerMap.values();
    }
   
   
    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        int id = random.nextInt();
        customer.setId(id);
        customerMap.put(id, customer);
        return customer;
    }

}
