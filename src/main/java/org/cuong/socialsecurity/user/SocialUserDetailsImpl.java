package org.cuong.socialsecurity.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cuong.model.Role;
import org.cuong.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

public class SocialUserDetailsImpl implements SocialUserDetails {

	private static final long serialVersionUID = -5246117266247684905L;

	private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	private Users users;

	public SocialUserDetailsImpl(Users users) {
		this.users = users;
		for (Role role : users.getRoles()) {
			list.add(new SimpleGrantedAuthority(role.getName()));
		}
	}

	public String getUserId() {
		return this.users.getId().toString();
	}

	public String getUsername() {
		return users.getEmail();
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return list;
	}

	public String getPassword() {
		return users.getPassword();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}