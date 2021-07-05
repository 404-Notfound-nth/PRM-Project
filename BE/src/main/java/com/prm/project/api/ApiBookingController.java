package com.prm.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prm.project.dto.BookingDTO;
import com.prm.project.service.BookingService;

@RestController
@RequestMapping("api/booking")
public class ApiBookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PutMapping("{phone}")
	public ResponseEntity<Object> cancelBooking(@PathVariable("phone") String phone) {
		try {
//			if(bookingService.getByPhone(phone) == null) {
//				return new ResponseEntity<Object>("Null", HttpStatus.BAD_REQUEST);
//			}
			bookingService.cancelBooking(phone);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	@PutMapping("{doctorID}")
//	public ResponseEntity<Object> viewHistory(@PathVariable("doctorID") String doctorID){
//		try {
//			return new ResponseEntity<Object>(bookingService.getListBooking(doctorID), HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//		}
//	}
	
	public ResponseEntity<Object> booking(@RequestBody BookingDTO bookingDTO){
		try {
			bookingService.booking(bookingDTO);
			return new ResponseEntity<Object>("OK", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("{aphone}")
	public ResponseEntity<Object> accpectBooking(@PathVariable("aphone") String phone) {
		try {
			bookingService.acceptCustomer(phone);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("{dphone}")
	public ResponseEntity<Object> denyBooking(@PathVariable("dphone") String phone) {
		try {
			bookingService.denyCustomer(phone);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
