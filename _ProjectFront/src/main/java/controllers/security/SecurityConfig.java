package controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Password encoder
	
	// MD5 SHA1 BCrypt
	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	// 1 Authentication QUI? 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder) //12345	
			.withUser("admin")
			.password(passwordEncoder.encode("123"))
			.roles("ADMIN")
			.and()
			.withUser("user")
			.password(passwordEncoder.encode("123"))
			.roles("USER");
			
			
			
		
	}

	// 2 Autorizations QUOI FAIRE ACTIONS
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/books/**").hasAnyRole("ADMIN","USER")
			.and()
			.formLogin()
			.defaultSuccessUrl("/books")
			.and()
			.logout()
			.and()
			.csrf()
			.disable();
	}

	

}
