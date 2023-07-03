package footprint.bean;

import org.springframework.web.multipart.MultipartFile;

public class User {
	
	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private MultipartFile avatar;
	private String avatarDir;

	public User() {
		email = "";
		username = "";
		password = "";
		lastName = "";
		firstName = "";
		phoneNumber = "";
		avatarDir = "";
	}

	public User(String email, String username, String firstName, String lastName, String phoneNumber) {
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}

	public String getAvatarDir() {
		return avatarDir;
	}

	public void setAvatarDir(String avatarDir) {
		this.avatarDir = avatarDir;
	}
}
