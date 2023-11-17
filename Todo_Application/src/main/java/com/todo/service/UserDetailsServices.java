package com.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo.model.UserModel;
import com.todo.repository.UserRepository;

@Service
public class UserDetailsServices implements UserDetailsService {
	
	@Autowired
	private UserRepository uRep;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserModel> opt=uRep.findById(email);
		if(opt.isEmpty()) {
			throw new BadCredentialsException("User Details not found with this username: "+email);
		}
		List<GrantedAuthority> authorities= new ArrayList();
		return new User(email, opt.get().getPassword(), authorities);
	}

}
