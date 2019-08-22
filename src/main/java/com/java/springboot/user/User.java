package com.java.springboot.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

	public User(String username, String pass) {
		this.username = username;
		this.password = pass;
	}
	private Long id;
	private String username;
	private String password;
}
