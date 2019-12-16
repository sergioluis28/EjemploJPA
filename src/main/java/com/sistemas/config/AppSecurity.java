package com.sistemas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired private DataSource dataSource; 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder)
				.usersByUsernameQuery(
						"select nombre as username, "
								+ "clave as password, "
								+ "estado as enabled "
						+ "from usuario as users "
						+ "where nombre = ?")
				.authoritiesByUsernameQuery(
						"select nombre as username, "
								+ "rol as authority "
						+ "from usuario as authorities "
						+ "where nombre = ?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/**/index").permitAll()
				//.antMatchers("/**/index").hasAnyRole("ADMIN", "USER")
				.antMatchers("/**/index").hasAnyAuthority("ADMIN", "USER")
				//.antMatchers("/**/nuevo").hasRole("ADMIN")
				.antMatchers("/**/nuevo").hasAuthority("ADMIN")
				.antMatchers("/**/guardar").hasAuthority("ADMIN")
				.antMatchers("/**/editar**").hasAuthority("ADMIN")
				.antMatchers("/**/eliminar**").hasAuthority("ADMIN")
			.and().formLogin().permitAll()
			.and().logout().logoutSuccessUrl("/login")
			.and().exceptionHandling().accessDeniedPage("/usuario/denegado")
			.and().csrf();
	}
}






//.authenticated()
/*
 * 
	.usersByUsernameQuery("select * from (select nombre as username, clave as password, estado as enabled from usuario) as users where username = ?")
	.authoritiesByUsernameQuery("select * from (select nombre as username, rol as AUTHORITY from usuario) as authorities where username = ?");

 */
