package com.sistemas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired private DataSource dataSource; 
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
			.usersByUsernameQuery("select * from (select nombre as username, clave as password, estado as enabled from usuario) as users where username = ?")
			.authoritiesByUsernameQuery("select * from (select nombre as username, rol as AUTHORITY from usuario) as authorities where username = ?");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/**/index").hasAnyRole("ADMIN", "USER")
				.antMatchers("/**/nuevo").hasRole("ADMIN")
				.antMatchers("/**/guardar").hasRole("ADMIN")
				.antMatchers("/**/editar**").hasRole("ADMIN")
				.antMatchers("/**/eliminar**").hasRole("ADMIN")
			.and().formLogin().permitAll()
			.and().logout().logoutSuccessUrl("/login")
			.and().exceptionHandling().accessDeniedPage("/denegado")
			.and().csrf();
	}
}

/*
auth.inMemoryAuthentication().passwordEncoder( passwordEncoder )
		.withUser("user").password( passwordEncoder.encode("123456") ).roles("USER")
		.and()
		.withUser("admin").password( passwordEncoder.encode("123456") ).roles("USER", "ADMIN");
*/
/*
auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				//.rolePrefix("ROLE_")
	.usersByUsernameQuery("select * from (select nombre as username, clave as password, estado as enabled from usuario) as users where username = ?")
	.authoritiesByUsernameQuery("select * from (select nombre as username, rol as authority from usuario) as authorities where username = ?");
*/
//String role = authResult.getAuthorities().toString(); //en controller


/*
 * 
 * select g.id, g.group_name, ga.authority 
 * 		from groups g, group_members gm, group_authorities ga 
 * 		where gm.username = ? 
 * 		and g.id = ga.group_id 
 * 		and g.id = gm.group_id
 * 
 * select username,password,enabled 
 * 		from users 
 * 		where username = ?
 * 
 * select username,authority 
 * 		from authorities 
 * 		where username = ?
 * 
 */


/*
http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/docente/**").hasRole("ADMIN")
		.antMatchers("/alumno/**").hasAnyRole("ADMIN", "USER")
		.antMatchers("/**").authenticated()
	.and().formLogin().permitAll()
	.and().exceptionHandling().accessDeniedPage("/403")
	.and().logout().logoutSuccessUrl("/login").permitAll();
*/


	/*
	<access-denied-handler error-page="/403"/>
	
	<form-login login-page="/principal"
				login-processing-url="/j_spring_security_check"
				default-target-url="/personas"
				username-parameter="usuario"
				password-parameter="clave"
				authentication-failure-url="/login?error"/>
				
	<logout logout-sucess-url="/login?logout" logout-url="/j_spring_security_logout"/>
	*/

// <sec:authorize access="hasAnyRole('ADMIN', 'USER')">

/*
 * 				.antMatchers("/userPanel").hasAuthority("ALUMNO")
                .and()
                .formLogin().loginPage("/")
                .defaultSuccessUrl("/success")
                .failureUrl("/?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/?logout");
 */
