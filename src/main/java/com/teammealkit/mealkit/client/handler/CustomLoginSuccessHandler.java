package com.teammealkit.mealkit.client.handler;

import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.filter.AuthConstants;
import com.teammealkit.mealkit.client.domain.MyClientDetails;
import com.teammealkit.mealkit.client.filter.TokenUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        final Authentication authentication) throws ServletException, IOException {
        final Client client = ((MyClientDetails) authentication.getPrincipal()).getClient();
        final String token = TokenUtils.generateJwtToken(client);
        response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + token);
    }
}
