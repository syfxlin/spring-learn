package me.ixk.data_rest.repository;

import me.ixk.data_rest.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {}
