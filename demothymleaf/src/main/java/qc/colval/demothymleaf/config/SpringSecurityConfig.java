package qc.colval.demothymleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/assets/**").permitAll() //permitAll = permets CES requêtes sans login
<<<<<<< HEAD
                .antMatchers("/api/**").permitAll()
=======
                .antMatchers("/api/**").permitAll() //permet d'accéder a l'api sans se logger.
>>>>>>> parent of cb483be (renaming)
                .anyRequest().authenticated() //pour toute autre requêtes: doit être authentifié
                .and() //fin de la configuration des ressources
                .formLogin() //connexion via un formulaire
                .loginPage("/authentification")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").roles("USER").password("{noop}pass")
                .and()
                .withUser("admin").roles("ADMIN").password("{noop}admin");
    }

}
