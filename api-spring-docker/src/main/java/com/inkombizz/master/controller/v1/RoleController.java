/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkombizz.master.controller.v1;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkombizz.master.repository.v1.RoleRepository;
import com.inkombizz.master.resource.v1.RoleModel;
import com.inkombizz.master.util.Response;

/**
 *
 * @author de4ragil
 */
@RestController
@RequestMapping("v1/role")
public class RoleController {

    @Autowired
    RoleRepository roleDao;

    @GetMapping
    public ResponseEntity<?> list() {
    	try {
            return new Response().response_json(true,"Ok",roleDao.findAll(),HttpStatus.OK);
    	}catch(Exception ex) {
            return new Response().response_json(true,"Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);	
    	}
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> listSearch(@PathVariable String search) {
    	try {
    		if(!search.isEmpty()) {
                return new Response().response_json(true,"Ok",roleDao.findByCode(search),HttpStatus.OK);	
    		}	
            return new Response().response_json(true,"Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}catch(Exception ex) {
            return new Response().response_json(true,"Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);	
    	}
    }
    
    @GetMapping("/{code}")
    public ResponseEntity<?> data(@PathVariable String code) {
    	try {
            return new Response().response_json(true,"Ok",roleDao.findById(code),HttpStatus.OK);	
    	}catch(Exception ex) {
            return new Response().response_json(true,"Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);	
    	}
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RoleModel model) {
    	try {
    		roleDao.save(model);	
            return new Response().response_json(true,"Save Success",model,HttpStatus.OK);
    	}catch(Exception ex) {
            return new Response().response_json(true,"Save Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@RequestBody RoleModel model,@PathVariable String code) {
    	try {
    		roleDao.save(model);	
            return new Response().response_json(true,"Save Success",model,HttpStatus.OK);
    	}catch(Exception ex) {
            return new Response().response_json(true,"Save Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
    	try {
    		roleDao.deleteById(code);	
            return new Response().response_json(true,"Save Success",null,HttpStatus.OK);
    	}catch(Exception ex) {
            return new Response().response_json(true,"Save Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
