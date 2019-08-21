package com.java.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springboot.security.CustomUserDetails;
import com.java.springboot.utils.UserUtils;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUsername(username);
		if (userEntity == null ) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(UserUtils.toUserModel(userEntity));
	}

}
