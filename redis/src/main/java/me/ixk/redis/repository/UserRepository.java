package me.ixk.redis.repository;

import me.ixk.redis.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findTopByUsername(String name);
}
