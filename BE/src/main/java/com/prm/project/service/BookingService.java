package com.prm.project.service;

import com.prm.project.dto.BookingDTO;

public interface BookingService {
	void cancelBooking(String phone);

	BookingDTO getByPhone(String phone);

	//List<BookingDTO> getListBooking(String doctorID);

	void booking(BookingDTO bookingDTO);

	void acceptCustomer(String phone);
	
	void denyCustomer(String phone);
}
