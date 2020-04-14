package me.ixk.mybatis.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private String rememberToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String url;
    private Integer status;
    private String type;
    private LocalDateTime emailVerifiedAt;
}
