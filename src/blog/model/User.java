package blog.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="usertable")

public class User {
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column
	private LocalDate datefrom;
	
	
	public LocalDate getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(LocalDate datefrom) {
		this.datefrom = datefrom;
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
	public User(String email, String password, LocalDate date) {
		
		this.email = email;
		this.password = password;
		this.datefrom = date;
	}
	public User() {
	
	}
	
	
	

}
