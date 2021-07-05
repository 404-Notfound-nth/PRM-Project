package com.prm.project.entity;

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
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
public class Doctors {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
	@Column(name = "id", columnDefinition = "uniqueidentifier")
	private String id;
	
	private String doctorName;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone is not format")
	private String phone;
	
	private String address;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "status_id", insertable = false, updatable = false)
	private Status status;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<BookingDetails> bookingDetails;
	
//	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Booking> booking;
}
