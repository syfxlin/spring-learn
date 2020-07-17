package me.ixk.mongodb;

import lombok.extern.slf4j.Slf4j;
import me.ixk.mongodb.model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Slf4j
class MongodbApplicationTests {
    private final Logger log = LoggerFactory.getLogger(
        MongodbApplicationTests.class
    );

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void insertAndFind() {
        User user = User
            .builder()
            .username("syfxlin")
            .nickname("Otstar Lin")
            .email("syfxlin@gmail.com")
            .password("123456")
            .rememberToken("123")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .url("https://ixk.me")
            .status(1)
            .type("open")
            .emailVerifiedAt(LocalDateTime.now())
            .build();
        User savedUser = mongoTemplate.save(user);
        log.info("User {}", savedUser);

        Criteria criteria = Criteria.where("username").is("syfxlin");
        Query query = Query.query(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        log.info("Users {}", users);

        mongoTemplate.remove(savedUser);
    }
}
