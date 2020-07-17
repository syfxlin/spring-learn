package me.ixk.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Id
    private long id;

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
