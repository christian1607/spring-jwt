package com.celmam.apisistradoc.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;



/**
 * @author toshiba
 * By default, the BasicAuthenticationEntryPoint provisioned
 * by Spring Security returns a full page for a 401 Unauthorized
 * response back to the client. This HTML representation of the error
 * renders well in a browser, but it not well suited for other scenarios, 
 * such as a REST API where a json representation may be preferred.
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No Autorizado");
    }
}