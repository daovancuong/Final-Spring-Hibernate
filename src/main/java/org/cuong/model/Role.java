package org.cuong.model;
// Generated Aug 14, 2016 6:25:29 PM by Hibernate Tools 4.3.4.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "mkyong")
public class Role implements java.io.Serializable {

	private Integer id;
	private String name;
	private List<Users> userses = new ArrayList<Users>();

	public Role() {
	}

	public Role(String name, ArrayList<Users> userses) {
		this.name = name;
		this.userses = userses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_has_role", catalog = "mkyong", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "users_id", nullable = false, updatable = false) })
	public List<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(List<Users> userses) {
		this.userses = userses;
	}

}
