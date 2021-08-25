package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.java.filter.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private UserDetailsService userDetailsService;
	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	
	@Bean
	@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin()
		.httpStrictTransportSecurity().disable();
		http
		.csrf().disable()// tránh submit những thông tin giả mạo
		.antMatcher("/api/**")// những link mà bắt đầu là api thì những cấu hình phía dưới mới hoạt động
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers(
				"/api/login/user",
				"/api/login/user/google",
				"/api/login/user/facebook",
	
				"/api/category/all",
				"/api/category/all",
				
				"/api/product/get-products-by-category/**",
				"/api/product/search/**",
				"/api/product/get-product",
				
				"/api/product-detail/get-product-detail-by-product",

				"/api/review/get/by-product",
				
				"/api/signup/user",
				"/api/signup/user/google",
				"/api/signup/user/facebook",
				
				"/api/user/signup/active"
				
				
				)
		.permitAll()
		
		
		.antMatchers(
				"/api/role/**", 
				
				"/api/user/add/by-admin",
				"/api/user/all",
				"/api/user/add-by-admin",
				"/api/user/update/active-admin",
				"/api/user/update/admin",
				"/api/user/delete/**",
				"/api/user/delete-not-return/**",
				"/api/user/search",
				
				"/api/delete/**",
				
				"/api/category/update-all-category",
				"/api/category/delete",
				"/api/category/add",
				
				"/api/product/add",
				"/api/product/delete/**",
				"/api/product/update",
				"/api/product/search/admin",
				
				"/api/product-detail/add",
				"/api/product-detail/add/image",
				"/api/product-detail/update/image",
				"/api/product-detail/update",
				"/api/product-detail/delete",
				
				"/api/upload"
				)
		.hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated();
		// Sử dụng JWTSAuthorizationFilter để check token => Lây thông tin người dùng
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), userDetailsService));
		// Cấu hình không sử dụng session lưa thông tin client
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
