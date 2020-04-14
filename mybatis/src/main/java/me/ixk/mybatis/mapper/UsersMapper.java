package me.ixk.mybatis.mapper;

import me.ixk.mybatis.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersMapper {
    @Insert("INSERT INTO " +
            "users(username,nickname,email,password,remember_token,created_at,updated_at,url,status,type,email_verified_at) " +
            "VALUES (#{username},#{nickname},#{email},#{password},#{rememberToken},#{createdAt},#{updatedAt},#{url},#{status},#{type},#{emailVerifiedAt})"
    )
    void insert(Users users);

    @Delete("DELETE FROM users WHERE id=#{id}")
    int deleteById(String id);

    @Select("SELECT * FROM users")
//    @Results(id = "id",value = {
//            @Result(property = "id", column = "id", javaType = Long.class),
//            @Result(property = "username", column = "username", javaType = String.class),
//            @Result(property = "nickname", column = "nickname", javaType = String.class),
//            @Result(property = "email", column = "email", javaType = String.class),
//            @Result(property = "password", column = "password", javaType = String.class),
//            @Result(property = "rememberToken", column = "remember_token", javaType = String.class),
//            @Result(property = "createdAt", column = "created_at", javaType = LocalDateTime.class),
//            @Result(property = "updatedAt", column = "updated_at", javaType = LocalDateTime.class),
//            @Result(property = "url", column = "url", javaType = String.class),
//            @Result(property = "status", column = "status", javaType = Integer.class),
//            @Result(property = "type", column = "type", javaType = String.class),
//            @Result(property = "emailVerifiedAt", column = "email_verified_at", javaType = LocalDateTime.class)
//    })
    List<Users> all();
}
