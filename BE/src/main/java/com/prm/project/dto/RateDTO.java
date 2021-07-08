package com.prm.project.dto;

import java.io.Serializable;

import com.prm.project.entity.Account;
import com.prm.project.entity.Doctors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private Integer doctorNumberRating;

	private String doctor_id;

	private String account_id;

	private Doctors doctor;
	
	private Account account;
}
