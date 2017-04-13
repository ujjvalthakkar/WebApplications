package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="user")
public class User {
	
	public User() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "personID", unique=true, nullable = false)
	private long personID;
	
	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	private String filename;     
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@Column(name = "email")
	private String email;

	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
										  //for Hibernate
	public CommonsMultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
