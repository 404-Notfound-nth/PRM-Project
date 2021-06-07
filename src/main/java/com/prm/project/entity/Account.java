package com.prm.project.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone is not format")
	@Column(name = "phone")
	private String phone;
	
	@Size(min = 6, message = "username must be greater than 6 characters")
	@Column(name = "fullname", columnDefinition = "nvarchar")
	private String fullname;
	
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email is not format")
	@Column(name = "email")
	private String email;
	
//	@Size(min = 8, max = 32, message = "the password must be 8 - 32 characters")
	@Length(min = 8, max = 32, message = "the password must be 8 - 32 characters")
	@Column(name = "password")
	private String password;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "status_id", insertable = false, updatable = false)
	private Status status;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Booking> booking;
}
