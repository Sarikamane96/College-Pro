package com.edu.SpringBoot.CollegemanementApp;

import org.springframework.context.annotation.Configuration;

@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private UserDetailsService userDetailsService;
		
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
			
		}
		
		
		
	  	@Override
		protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()

			.authorizeRequests()
			.antMatchers("/student/*").hasAuthority("ROLE_USER")
			.antMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
			.antMatchers("/").permitAll()// index.html
			.antMatchers("/**").authenticated()

			.and().httpBasic()
			
			.and().formLogin().permitAll()
			.and().logout().permitAll()
			;

		}
		
	  	
	  
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}
		
		/*public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}*/

	}

}
