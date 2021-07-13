package com.java.spring.security.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.spring.security.model.MyUserDetails;
import com.java.spring.security.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * In place of jdbc template 
	 * it can be implemented in jpa repository
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String,String> param = new HashMap<>();
		param.put("user", username);
		List<User> userList= jdbcTemplate.query("select * from users where username=:user", param, BeanPropertyRowMapper.newInstance(User.class));
		return new MyUserDetails(userList.get(0));
	}

}
