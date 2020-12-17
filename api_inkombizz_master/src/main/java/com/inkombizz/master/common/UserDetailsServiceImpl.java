/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkombizz.master.common;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.inkombizz.master.repository.v1.UserRepository;
import com.inkombizz.master.resource.v1.UserModel;
/**
 *
 * @author de4ragil
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userDao;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        UserModel user = userDao.findByUsername(username);
		System.out.println("CLASS MODEL USER");
		System.out.println("USER :"+ user.getUsername());
		System.out.println("PSWD :"+ user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), Collections.EMPTY_LIST);
    }
}
