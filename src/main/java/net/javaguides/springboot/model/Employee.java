package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name", nullable = false) // Assuming first name is required if not required you can make it nullable true
	private String firstName;

	@Column(name = "last_name", nullable = false) // Assuming last name is required
	private String lastName;

	@Column(name = "email_id", unique = true, nullable = false) // Assuming email is unique and required
	private String emailId;

	@Lob // For large binary data like images
	@Column(name = "image")
	private byte[] image;

	// Default constructor is required by JPA, you can add it
	public Employee() {
	}

	public Employee(String firstName, String lastName, String emailId, byte[] image) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.image = image;
	}

	// Getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
}
