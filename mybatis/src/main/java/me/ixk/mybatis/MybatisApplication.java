package me.ixk.mybatis;

import me.ixk.mybatis.entity.Users;
import me.ixk.mybatis.mapper.UsersMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@MapperScan("me.ixk.mybatis.mapper")
@RestController
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Autowired
    UsersMapper usersMapper;

    @GetMapping("index")
    public List<Users> index() {
        Users user = Users
                .builder()
                .username("syfxlin")
                .nickname("Otstar Lin")
                .email("syfxlin@gmail.com")
                .password("1234656")
                .rememberToken("123")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .url("https://ixk.me")
                .status(1)
                .type("open")
                .emailVerifiedAt(LocalDateTime.now())
                .build();
        usersMapper.insert(user);
        return usersMapper.all();
    }
}
