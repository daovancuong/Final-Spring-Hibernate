package org.cuong.model;
// Generated Aug 14, 2016 6:25:29 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserAccounts generated by hbm2java
 */
@Entity
@Table(name = "user_accounts", catalog = "mkyong", uniqueConstraints = { @UniqueConstraint(columnNames = "EMAIL"),
		@UniqueConstraint(columnNames = "USER_NAME") })
public class UserAccounts implements java.io.Serializable {

	private String id;
	private String email;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private String enabled;

	public UserAccounts() {
	}

	public UserAccounts(String id, String email, String userName, String firstName, String lastName, String role,
			String enabled) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.enabled = enabled;
	}

	public UserAccounts(String id, String email, String userName, String firstName, String lastName, String password,
			String role, String enabled) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "USER_NAME", unique = true, nullable = false, length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", nullable = false, length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ROLE", nullable = false, length = 20)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "ENABLED", nullable = false, length = 1)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
