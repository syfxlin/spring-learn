package me.ixk.jpa;

import me.ixk.jpa.entity.UsersEntity;
import me.ixk.jpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@RestController
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("find-all")
    public List<UsersEntity> findAll() {
        return usersRepository.findAll();
    }

    @GetMapping("find-by-id")
    public UsersEntity findById(Long id) {
        return usersRepository.findById(id);
    }
}
