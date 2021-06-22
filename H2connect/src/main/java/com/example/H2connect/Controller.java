package com.example.H2connect;


import com.example.H2connect.Billionaire; 
import com.example.H2connect.BillionaireRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class Controller {


    @Autowired
    private  BillionaireRepo repository;

    
    //Posting one entry
	@PostMapping("/entry")
	public List<Billionaire> saveOrUpdate(@RequestBody Billionaire bill) {
        // add this entry to the database
        //String s =  String.format("{ \"Id\": \"%d\"}",m.getId()); 
		List<Billionaire> lbill = new ArrayList<>();
        repository.findAll().forEach(lbill::add);
        
		if(lbill.size()>0)  bill.setId(lbill.get(lbill.size()-1).getId()+1);
		repository.save(bill);
        lbill.add(bill);
		return lbill;
    }

	
	
//	Viewing the list
    @GetMapping("/getBillionaire")
	public Iterable<Billionaire> blist() {
        return repository.findAll();
    }
    
//  Getting the entry by id
    @GetMapping("/getBillionaire/{id}")
	public Billionaire billById(@PathVariable("id") long id) {
        return repository.findById(id).get(); 
    }
    
//    Delete the entry by id
    @GetMapping("/delBillionaire/{id}")
	public void delById(@PathVariable("id") long id) {
        repository.deleteById(id); 
    }

}