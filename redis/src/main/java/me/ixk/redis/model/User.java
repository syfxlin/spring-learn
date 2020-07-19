package me.ixk.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "users", timeToLive = 1L)
public class User implements Serializable {
    @Id
    private long id;

    @Indexed
    private String username;

    private String nickname;
    private String email;
    private String password;
    private String rememberToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String url;
    private int status;
    private String type;
    private LocalDateTime emailVerifiedAt;
}
