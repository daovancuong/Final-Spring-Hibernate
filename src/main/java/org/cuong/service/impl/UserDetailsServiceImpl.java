package org.cuong.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.cuong.model.Users;
import org.cuong.service.UserService;
import org.cuong.socialsecurity.user.SocialUserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Lấy thông tin User dưới database.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetailsServiceImpl() {

	}

	public UserDetails loadUserByUsername(String identify) throws UsernameNotFoundException {

		// Users users = userService.findByEmail(identify);
		// if (users != null) {
		// Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// for (int i = 0; i < users.getRoles().size(); i++) {
		// authorities.add(new SimpleGrantedAuthority(users.getRoles().get(i).getName()));
		// }
		// return new User(users.getEmail(), users.getPassword(), true, true, true, true, authorities);
		// } else if ((users = userService.findById(identify)) != null) {
		// return new SocialUserDetailsImpl(users);
		// } else {
		// throw new UsernameNotFoundException("No user found with userName: " + identify);
		// }
		Users users = userService.findById(identify);
		if (users == null) {

			throw new UsernameNotFoundException("No user found with userName: " + identify);
		}
		return new SocialUserDetailsImpl(users);

	}

}