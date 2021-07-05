package com.prm.project.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private Date createDate;
	
	private Date modifiedDate;

	private String note;

	private String status_id;

	private String account_phone;

//	private String doctor_id;

	private String service_id;

}
