package com.java.springboot.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "roles", "authorities" })
public class User {

	private Long id;
	private String username;
	private String password;
	private String[] roles;
	
	public List<GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (String role : roles) {
	      authorities.add(new SimpleGrantedAuthority(role));
	    }
	    return authorities;
	  }

	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
}
