package me.ixk.mongodb;

import lombok.extern.slf4j.Slf4j;
import me.ixk.mongodb.model.User;
import me.ixk.mongodb.repository.UserRepository;
import org.junit.jupiter.api.Test;
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
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;

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

        List<User> findByRepository = userRepository.findByUsername("syfxlin");
        log.info("Find by repository {}", findByRepository);

        mongoTemplate.remove(savedUser);
    }
}
