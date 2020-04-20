package me.ixk.container.entry;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username = "";
    private String password = "";

    public User(String username, String password) {
        System.out.println("创建了 User 对象");
        this.username = username;
        this.password = password;
    }
}
