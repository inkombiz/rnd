/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkombizz.auth.common;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.inkombizz.auth.repository.v1.UserRepository;
import com.inkombizz.auth.resource.v1.UserModel;
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
    	
        UserModel applicationUser = userDao.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.EMPTY_LIST);
    }
}
