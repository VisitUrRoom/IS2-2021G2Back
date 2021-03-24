package com.backvisitur.configuration;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfiguration
{

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter( ){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource( );
        CorsConfiguration config = new CorsConfiguration( );

        config.addAllowedOrigin( "*" );
        config.addAllowedHeader( "*" );
        config.addAllowedMethod( GET );
        config.addAllowedMethod( POST );
        config.addAllowedMethod( PATCH );
        config.addAllowedMethod( PUT );
        config.addAllowedMethod( DELETE );
        source.registerCorsConfiguration( "/**", config );

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>( new CorsFilter(  source ) );
        bean.setOrder( HIGHEST_PRECEDENCE );

        return bean;
    }

}