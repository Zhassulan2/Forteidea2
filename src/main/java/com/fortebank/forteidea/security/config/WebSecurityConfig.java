package com.fortebank.forteidea.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortebank.forteidea.security.config.filter.JwtAuthenticationFilter;
import com.fortebank.forteidea.security.config.filter.UsernamePasswordAuthenticationFilter;
import com.fortebank.forteidea.security.config.handler.JwtAuthenticationSuccessHandler;
import com.fortebank.forteidea.security.config.handler.UsernamePasswordAuthenticationSuccessHandler;
import com.fortebank.forteidea.security.config.provider.JwtAuthenticationProvider;
import com.fortebank.forteidea.security.jwt.JwtSettings;
import com.fortebank.forteidea.security.jwt.extractor.TokenExtractor;
import com.fortebank.forteidea.security.ldap.LdapSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.List;

import static com.fortebank.forteidea.security.constants.SecurityConstants.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationManager authenticationManager;
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    private AuthenticationFailureHandler authenticationFailureHandler;
    private UsernamePasswordAuthenticationSuccessHandler usernamePasswordAuthenticationSuccessHandler;
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    private JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;
    private LdapContextSource ldapContextSource;
    private LdapAuthoritiesPopulator ldapAuthoritiesPopulator;
    private LdapSettings ldapSettings;
    private ObjectMapper objectMapper;
    private TokenExtractor tokenExtractor;
    private JwtSettings jwtSettings;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html**",
                        "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable() // we don't need CSRF for JWT based authentication

                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // we don't want the session created for security purposes as we are using tokens for each request

                /*.and()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html**",
                        "/webjars/**",
                        "favicon.ico"
                ).permitAll()*/

                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENTRY_POINT).permitAll() // Login end-point -> Permit
                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point -> Permit
                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).fullyAuthenticated() // Protected API End-points

                .and()
                .addFilterBefore(buildUsernamePasswordAuthenticationFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(buildJwtAuthenticationFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication() // LDAP Authentication Provider
                .contextSource(ldapContextSource)
                .ldapAuthoritiesPopulator(ldapAuthoritiesPopulator)
                .userSearchBase(ldapSettings.getUserSearchBase())
                .userSearchFilter(ldapSettings.getUserSearchFilter())

                .and()
                .authenticationProvider(jwtAuthenticationProvider) // JWT Authentication Provider
        ;
    }

    private Filter buildUsernamePasswordAuthenticationFilter() {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter(
                LOGIN_ENTRY_POINT,
                usernamePasswordAuthenticationSuccessHandler,
                authenticationFailureHandler,
                objectMapper
        );

        filter.setAuthenticationManager(this.authenticationManager);

        return filter;
    }

    private Filter buildJwtAuthenticationFilter() {
        String pathToProcess = TOKEN_BASED_AUTH_ENTRY_POINT;
        List<String> pathsToSkip = Arrays.asList(LOGIN_ENTRY_POINT, TOKEN_REFRESH_ENTRY_POINT);
        SkipPathRequestMatcher requestMatcher = new SkipPathRequestMatcher(pathsToSkip, pathToProcess);

        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(
                requestMatcher,
                jwtAuthenticationSuccessHandler,
                authenticationFailureHandler,
                tokenExtractor,
                jwtSettings
        );

        filter.setAuthenticationManager(this.authenticationManager);

        return filter;
    }

    @Autowired
    public void setAuthenticationEntryPoint(RestAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Autowired
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Autowired
    public void setUsernamePasswordAuthenticationSuccessHandler(UsernamePasswordAuthenticationSuccessHandler usernamePasswordAuthenticationSuccessHandler) {
        this.usernamePasswordAuthenticationSuccessHandler = usernamePasswordAuthenticationSuccessHandler;
    }

    @Autowired
    public void setJwtAuthenticationProvider(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @Autowired
    public void setJwtAuthenticationSuccessHandler(JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler) {
        this.jwtAuthenticationSuccessHandler = jwtAuthenticationSuccessHandler;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setLdapContextSource(LdapContextSource ldapContextSource) {
        this.ldapContextSource = ldapContextSource;
    }

    @Autowired
    public void setLdapAuthoritiesPopulator(LdapAuthoritiesPopulator ldapAuthoritiesPopulator) {
        this.ldapAuthoritiesPopulator = ldapAuthoritiesPopulator;
    }

    @Autowired
    public void setLdapSettings(LdapSettings ldapSettings) {
        this.ldapSettings = ldapSettings;
    }

    @Autowired
    public void setTokenExtractor(TokenExtractor tokenExtractor) {
        this.tokenExtractor = tokenExtractor;
    }

    @Autowired
    public void setJwtSettings(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
