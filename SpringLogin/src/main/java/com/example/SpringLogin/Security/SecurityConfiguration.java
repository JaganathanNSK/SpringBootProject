package com.example.SpringLogin.Security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private static final String password = "qwe123";
	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private static final String ENCODED_PASSWORD = passwordEncoder.encode(password);

	private static final String password1 = "abc123";
	private static final String ENCODED_PASSWORD1 = passwordEncoder.encode(password1);
	
	@Autowired
	public void cofigureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("Sudhakar").password(ENCODED_PASSWORD).roles("USER","ADMIN")
			.and().withUser("Mani").password(ENCODED_PASSWORD1).roles("USER");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/","/*todo*/**").hasAnyRole("USER","ADMIN").and().formLogin().defaultSuccessUrl("/welcome");
		}
	
	
}
