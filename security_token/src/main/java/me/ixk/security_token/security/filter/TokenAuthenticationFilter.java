package me.ixk.security_token.security.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.ixk.security_token.security.token.TokenAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        FilterChain filterChain
    )
        throws ServletException, IOException {
        SecurityContext context = SecurityContextHolder.getContext();
        if (
            context.getAuthentication() != null &&
            context.getAuthentication().isAuthenticated()
        ) {
            // do nothing
        } else {
            String token = httpServletRequest.getParameter("_token");
            if (token == null) {
                token = httpServletRequest.getHeader("Authorization");
                if (token != null) {
                    token = token.replace("Bearer ", "");
                }
            }
            if (token != null) {
                Authentication auth = new TokenAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            httpServletRequest.setAttribute(
                "me.ixk.security_token.security.filter.TokenAuthenticationFilter.FILTERED",
                true
            );
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
