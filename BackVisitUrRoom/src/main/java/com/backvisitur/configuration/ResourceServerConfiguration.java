package com.backvisitur.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)
                 .stateless(false);
    } 
    
    @Override
    public void configure( HttpSecurity httpSecurity ) throws Exception{
        httpSecurity
                .authorizeRequests( )
                .antMatchers( "/oauth/token", "/oauth/authorize**", "/api/registrar/2/**", "/api/public/**" ).permitAll( )
                .antMatchers( "/api/listausuarios" ).authenticated( )
                .antMatchers( "/api/usuarios**").hasAuthority( "ROLE_USER" )
                .antMatchers("/api/registrar**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers( "/api**").hasAuthority( "ROLE_ADMIN" )
                .anyRequest().authenticated()
                .and().cors().disable();
    }

}
