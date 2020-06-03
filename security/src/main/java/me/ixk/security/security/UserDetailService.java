package me.ixk.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

// 为 Spring Security 提供用户信息
@Configuration
public class UserDetailService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        if (!username.equals("syfxlin")) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return new User(
            username,
            this.passwordEncoder.encode("123456"),
            true,
            true,
            true,
            true,
            AuthorityUtils.commaSeparatedStringToAuthorityList("admin")
        );
    }
}
