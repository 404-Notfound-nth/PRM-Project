package com.prm.project.entity;

import java.security.Timestamp;
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

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
	@Column(name = "booking_id", columnDefinition = "uniqueidentifier")
	private String id;
	private Timestamp createDate;
	private Timestamp modifiedDate;
	
	@Column(name = "note", columnDefinition = "text")
	private String note;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "account_phone", insertable = false, updatable = false)
	private Account account;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "doctor_id", insertable = false, updatable = false)
	private Doctors doctor;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "status_id", insertable = false, updatable = false)
	private Status status;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "service_id",insertable = false, updatable = false)
	private Service service;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Bill> bill;
	
	
	
}
