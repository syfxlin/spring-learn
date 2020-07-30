package me.ixk.security_token.security;

import java.util.Map;
import me.ixk.security_token.security.token.TokenAuthentication;
import me.ixk.security_token.utils.Jwt;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class TokenAuthenticationProvider implements AuthenticationProvider {
    final Jwt jwt;

    public TokenAuthenticationProvider(final Jwt jwt) {
        this.jwt = jwt;
    }

    @Override
    public Authentication authenticate(final Authentication authentication)
        throws AuthenticationException {
        if (authentication.isAuthenticated()) {
            // verified
            return authentication;
        }

        final String token = authentication.getCredentials().toString();
        if (token == null || token.isEmpty()) {
            // failed
            return authentication;
        }

        Map<String, String> decoded = jwt.decode(token);
        if (decoded.get("logged") == null) {
            throw new AuthenticationCredentialsNotFoundException(
                "The token is not yet valid [Not Found logged]"
            );
        }
        Authentication auth = new PreAuthenticatedAuthenticationToken(
            "user",
            token,
            AuthorityUtils.commaSeparatedStringToAuthorityList("admin")
        );
        auth.setAuthenticated(true);
        return auth;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return TokenAuthentication.class.isAssignableFrom(authentication);
    }
}
