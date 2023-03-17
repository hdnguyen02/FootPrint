package footprint.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue
	private Integer idRole; 
	
	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private Collection<User> users;


	public Integer getIdRole() {
		return idRole;
	}


	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collection<User> getUsers() {
		return users;
	}


	public void setUsers(Collection<User> users) {
		this.users = users;
	}


	public Role(Integer idRole, String name, Collection<User> users) {
		this.idRole = idRole;
		this.name = name;
		this.users = users;
	}

	public Role() {
		
	}
}
