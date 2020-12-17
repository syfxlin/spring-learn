package me.ixk.freemarker.entity;

import java.util.UUID;

public class User {
  private String name;
  private int age;
  private UUID uuid;

  public User(String name, int age) {
    this.name = name;
    this.age = age;
    this.createUuid();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public void createUuid() {
    this.setUuid(UUID.randomUUID());
  }
}
