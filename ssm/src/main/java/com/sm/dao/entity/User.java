package com.sm.dao.entity;

public class User {  //模型层里的实体类
		private String username;  //类属性
		private String password;
		private String realname;
		private String mobile;
		private int age;
		
		public void setUsername(String username) {  //setXXX方法
			this.username = username;
		}
		public String getUsername() {  //getXXX方法
			return username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPassword() {
			return password;
		}
		public void setRealname(String realname) {
			this.realname = realname;
		}
		public String getRealname() {
			return realname;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		
		public String getMobile() {
			return mobile;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getAge() {
			return age;
		}
		public User(String username, String password) {
			this.username = username;
			this.password = password;
		}
		public User(String username) {
			this.username = username;
		}
		public User() {  //不可省略的无参构造方法
			//空实现也是实现
		}
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password
					+ ", realname=" + realname + ", mobile=" + mobile
					+ ", age=" + age + "]";
		}
		
}
