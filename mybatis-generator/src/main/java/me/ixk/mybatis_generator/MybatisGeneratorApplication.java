package me.ixk.mybatis_generator;

import me.ixk.mybatis_generator.entity.Users;
import me.ixk.mybatis_generator.entity.UsersExample;
import me.ixk.mybatis_generator.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MybatisGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorApplication.class, args);
    }

    @Autowired
    public UsersMapper usersMapper;

    @GetMapping("find-all")
    public List<Users> findAll() {
        return usersMapper.selectByExample(new UsersExample());
    }

    @GetMapping("find-by-id")
    public Users findById(long id) {
        UsersExample ue = new UsersExample();
        ue.createCriteria().andIdEqualTo(id);
        // usersMapper.selectByPrimaryKey(id);
        return usersMapper.selectByExample(ue).get(0);
    }
}
