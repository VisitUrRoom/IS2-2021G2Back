/*
 * package com.backvisitur.configuration;
 * 
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.oauth2.config.annotation.configurers.
 * ClientDetailsServiceConfigurer; import
 * org.springframework.security.oauth2.config.annotation.web.configuration.
 * AuthorizationServerConfigurerAdapter; import
 * org.springframework.security.oauth2.config.annotation.web.configuration.
 * EnableAuthorizationServer; import
 * org.springframework.security.oauth2.config.annotation.web.configurers.
 * AuthorizationServerEndpointsConfigurer; import
 * org.springframework.security.oauth2.config.annotation.web.configurers.
 * AuthorizationServerSecurityConfigurer; import
 * org.springframework.security.oauth2.provider.token.TokenStore; import
 * org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
 * 
 * 
 * @Configuration
 * 
 * @EnableAuthorizationServer public class AuthorizationConfig extends
 * AuthorizationServerConfigurerAdapter{
 * 
 * public static final String CLIEN_ID = "test-client"; public static final
 * String CLIENT_SECRET = "12345";
 * 
 * public static final String GRANT_TYPE_PASSWORD = "password"; public static
 * final String AUTHORIZATION_CODE = "authorization_code"; public static final
 * String REFRESH_TOKEN = "refresh_token"; public static final String IMPLICIT =
 * "implicit";
 * 
 * public static final String SCOPE_READ = "read"; public static final String
 * SCOPE_WRITE = "write"; public static final String TRUST = "trust";
 * 
 * public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60; public
 * static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;
 * 
 * 
 * private final AuthenticationManager authenticationManager; private final
 * PasswordEncoder passwordEncoder;
 * 
 * 
 * public AuthorizationConfig( AuthenticationManager authenticationManager,
 * PasswordEncoder passwordEncoder ){ this.authenticationManager =
 * authenticationManager; this.passwordEncoder = passwordEncoder; }
 * 
 * @Bean public TokenStore getTokenStore( ){ return new InMemoryTokenStore( ); }
 * 
 * 
 * @Override public void configure( AuthorizationServerSecurityConfigurer
 * security ){ security.checkTokenAccess( "isAuthenticated()" ); }
 * 
 * @Override public void configure( AuthorizationServerEndpointsConfigurer
 * endpoints ){ endpoints.authenticationManager( authenticationManager );
 * endpoints.tokenStore( getTokenStore( ) ); }
 * 
 * @Override public void configure( ClientDetailsServiceConfigurer client )
 * throws Exception{ client.inMemory() .withClient(CLIEN_ID)// ID del cliente
 * .secret(passwordEncoder.encode(CLIENT_SECRET))
 * .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN,
 * IMPLICIT ) .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
 * .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
 * .refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS); }
 * 
 * }
 * 
 */