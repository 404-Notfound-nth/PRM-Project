package com.prm.project.dto;

import java.io.Serializable;

import com.prm.project.entity.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String doctorName;

	private String phone;

	private String address;

	private Status status;

}
