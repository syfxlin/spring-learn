package me.ixk.jpa.repository;

import me.ixk.jpa.entity.UsersEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsersRepository extends Repository<UsersEntity, Long> {
    List<UsersEntity> findAll();
    UsersEntity findById(Long id);
}
