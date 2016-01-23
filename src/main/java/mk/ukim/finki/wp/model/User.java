package mk.ukim.finki.wp.model;

import javax.persistence.*;

@Entity
@Table(name = "wp_users")
public class User extends BaseEntity {

	@OneToOne
	private Company company;

	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String username;
	private String email;
	@Column(name = "user_password")
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 20, nullable = false)
	private Role role;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public enum Role {
		ROLE_USERS, ROLE_STUDENT, ROLE_PROFESSOR, ROLE_ADMIN
	}

}
