package com.appdev.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.asm.TypeReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebSecurity
@Configuration
public class AppSecurityConfiguration{
	
//	@Autowired
//	UserDetailsService userDetailsService;
	
	@Bean
	protected InMemoryUserDetailsManager configureAuthentication() {
		//auth.userDetailsService(userDetailsService);
		
		List<UserDetails> userDetails = new ArrayList<>();
		List<GrantedAuthority> employeeRoles = new ArrayList<>();
		employeeRoles.add(new SimpleGrantedAuthority("EMPLOYEE"));

		List<GrantedAuthority> adminRoles = new ArrayList<>();
		adminRoles.add(new SimpleGrantedAuthority("ADMIN"));
		
		userDetails.add(new User("employee",
				"$2a$10$lDRuxFPZu2H2knXILl2oKe0AsdKK1Mygpq25N.RtuPEUX7dcwKo46",
				employeeRoles));
		userDetails.add(new User("admin",
				"$2a$10$lDRuxFPZu2H2knXILl2oKe0AsdKK1Mygpq25N.RtuPEUX7dcwKo46",
				adminRoles));		
		return new InMemoryUserDetailsManager(userDetails);
		
		/*auth.inMemoryAuthentication()
		.withUser("employee")
		.password("$2a$10$lDRuxFPZu2H2knXILl2oKe0AsdKK1Mygpq25N.RtuPEUX7dcwKo46")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("$2a$10$lDRuxFPZu2H2knXILl2oKe0AsdKK1Mygpq25N.RtuPEUX7dcwKo46")
		.roles("ADMIN");*/
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//Exmaple - 1
		http.authorizeRequests()
		.antMatchers("/employee/fetchall").hasAuthority("ADMIN")
		.antMatchers("/employee/fetch/*").hasAnyAuthority("EMPLOYEE","ADMIN")
		.antMatchers("/employee/*").permitAll()
		.and().formLogin();
		return http.build();
		
		//Example - 2
		
		/*http.authorizeRequests()
		.antMatchers("/employee/fetchall","/employee/fetch/*").authenticated()
		.and().formLogin();*/
		
		//Example - 3
		
		/*http.authorizeRequests()
		.antMatchers(getSecureServicesList()).authenticated()
		.and().formLogin();*/
		
		
		
	}
	
	private String[] getSecureServicesList() {
		InputStream fileStream = TypeReference.class.getResourceAsStream("/static/secureservices.json");
		ObjectMapper mapper = new ObjectMapper();
		List<String> urlsList = new ArrayList();
		try {
			urlsList = mapper.readValue(fileStream, ArrayList.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] urls = urlsList.stream().toArray(String[]::new);
		return urls;
	}

}
