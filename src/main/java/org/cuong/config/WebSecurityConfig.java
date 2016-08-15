package org.cuong.config;

import org.cuong.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// <authentication-manager>
		// <authentication-provider>
		// <user-service>
		// <user name="user"
		// password="password"
		// authorities="ROLE_USER"/>
		// </user-service>
		// </authentication-provider>
		// </authentication-manager>

		auth.inMemoryAuthentication().withUser("cuong").password("cuong").roles("USER");
		auth.userDetailsService(userDetailsServiceImpl);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/signup", "/login", "/logout").permitAll();
		http.authorizeRequests().antMatchers("/welcome").access("hasRole('ROLE_USER')");
		http.authorizeRequests().antMatchers("/xxx").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/userInfo").access("hasRole('ROLE_USER')");

		// Form Login config
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")// chỉ cần có url /login trong controller.khi truy
									// cập vào bất cứ url(ngoại trừ /login) ex:/welcome nào thì nó mới tìm đến cái này
									// và tìm tới trang login
				.defaultSuccessUrl("/aaa")// nó là tương thích với requestMapping là /aaa chính là url trong
											// controller,ko phải là
											// page aaa
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password");

		// Logout Config
		http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/bbb");// nó là tương thích
																								// với
																								// requestMapping là
																								// /aaa trong(url)
																								// controller,ko
																								// phải là
																								// page aaa nếu cần
																								// customize logout thì
																								// bỏ logout url đi

		// Spring Social Config.
		 http.apply(new SpringSocialConfigurer()) .signupUrl("/signup");

	}

	// This bean is load the user specific data when form login is used.
	@Override
	public UserDetailsService userDetailsService() {
		return userDetailsServiceImpl;
	}

}
