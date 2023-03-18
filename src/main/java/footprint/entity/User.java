package footprint.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue
	private Long idUser; 
	
	@Column(name="username") 
	private String username; 
	
	@Column(name="password")
	private String password; 
	
	@Column(name="firstName")
	private String firstName; 
	
	@Column(name="lastName")
	private String lastName; 
	
	@Column(name="address")
	private String address;  
	
	@Column(name="imageUrl")
	private String imageUrl;
	
	@Column(name="email")
	private String email;  
	
	
	@Column(name="phone")
	private String phone;  
	
	@Column(name="createAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@Column(name="disable") 
	private Boolean disable; 
	
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public Boolean getDisable() {
		return disable;
	}


	public void setDisable(Boolean disable) {
		this.disable = disable;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}




	public User(Long idUser, String username, String password, String firstName, String lastName, String address,
			String imageUrl, String email, String phone, Date createAt, Boolean disable, Role role) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.imageUrl = imageUrl;
		this.email = email;
		this.phone = phone;
		this.createAt = createAt;
		this.disable = disable;
		this.role = role;
	}


	public User() {
		
	} 
	
	
}
