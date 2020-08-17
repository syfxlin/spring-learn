package me.ixk.data_rest.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users", schema = "spring_learn")
public class UsersEntity implements Serializable {
  private static final long serialVersionUID = 5483897727232348062L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  private String nickname;
  private String email;
  private String password;

  @Column(name = "remember_token")
  private String rememberToken;

  @Column(name = "created_at")
  @CreationTimestamp
  private Timestamp createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private Timestamp updatedAt;

  private String url;
  private int status;
  private String type;

  @Column(name = "email_verified_at")
  private Timestamp emailVerifiedAt;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRememberToken() {
    return rememberToken;
  }

  public void setRememberToken(String rememberToken) {
    this.rememberToken = rememberToken;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Timestamp getEmailVerifiedAt() {
    return emailVerifiedAt;
  }

  public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
    this.emailVerifiedAt = emailVerifiedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersEntity that = (UsersEntity) o;
    return (
      id == that.id &&
      status == that.status &&
      Objects.equals(username, that.username) &&
      Objects.equals(nickname, that.nickname) &&
      Objects.equals(email, that.email) &&
      Objects.equals(password, that.password) &&
      Objects.equals(rememberToken, that.rememberToken) &&
      Objects.equals(createdAt, that.createdAt) &&
      Objects.equals(updatedAt, that.updatedAt) &&
      Objects.equals(url, that.url) &&
      Objects.equals(type, that.type) &&
      Objects.equals(emailVerifiedAt, that.emailVerifiedAt)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      id,
      username,
      nickname,
      email,
      password,
      rememberToken,
      createdAt,
      updatedAt,
      url,
      status,
      type,
      emailVerifiedAt
    );
  }
}
