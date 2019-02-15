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

import com.thinkxfactor.zomatoplus.model.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	Random random = new Random();
    HashMap<Integer, Admin> adminMap = new HashMap<>();
   

    @GetMapping("/get")
    public Admin getAdmin(@RequestParam int id) {
        return adminMap.get(id);
    }
   
    @GetMapping("/getAll")
    public Collection<Admin> getAdmin() {
        return adminMap.values();
    }
   
   
    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        int id = random.nextInt();
        admin.setId(id);
        adminMap.put(id, admin);
        return admin;
    }
	

}
