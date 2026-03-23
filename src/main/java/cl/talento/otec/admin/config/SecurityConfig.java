package cl.talento.otec.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/login", "/css/**", "/js/**", "/img/**", "/api/**", "/").permitAll()
				.requestMatchers("/cursos/**").authenticated()
				.requestMatchers("/relatores/**").authenticated()
				.anyRequest().permitAll())
			.formLogin(login -> login
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/cursos", true)
				.failureUrl("/login?error=true"))
			.logout(logout -> logout
				.logoutSuccessUrl("/login?logout=true")
				.permitAll());
		
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
