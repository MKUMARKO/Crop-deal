package com.cropdeal.userservice.usersecurity;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cropdeal.userservice.models.User;
import com.cropdeal.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepo.findByUserName(username);
		
		if(user==null) {
			System.out.println("exception thrown");
			throw new UsernameNotFoundException(username + "not found");
		}
		return new UserDetailsImpl(user);
	}

}
