package com.java.spring.security.confiuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

//	@Autowired
//	DataSource dataSource;
//	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/**
		 * Works only with h2 embedded database 
		 */
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.withDefaultSchema()
//		.withUser(
//				User.withUsername("cnu")
//				.password("pass")
//				.roles("ADMIN"));
		
		/**
		 * For another databases we can run queries 
		 * below is for postgresql
		 */
		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery("select username ,password, enabled from users where username=? ")
//		.authoritiesByUsernameQuery("select username ,authority from authorities where username=?");
		
		/**
		 * with out queries and defualt schema 
		 * we can create using UserDetailsService provided by spring boot
		 * 
		 */
		auth.userDetailsService(userDetailsService);
		
	}
	
	/**
	 * "ROLE_****" the roles specified in db should be in this format 
	 * spring doesn't allow own roles
 	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
        .antMatchers("/").permitAll()
        .and()
        .formLogin();
        
        
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
