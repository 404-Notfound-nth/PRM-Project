package com.prm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prm.project.dto.DoctorsDTO;
import com.prm.project.dto.RateDTO;
import com.prm.project.entity.Booking;
import com.prm.project.entity.Service;
import com.prm.project.repository.BookingRepository;
import com.prm.project.repository.ServiceRepository;
import com.prm.project.service.BookingService;
import com.prm.project.service.DoctorService;
import com.prm.project.service.RateService;

@Controller
public class BaseController {

	@Autowired
	private DoctorService doctorsService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RateService rateService;
	
    @RequestMapping("/home")
    public String welcome(Model model) {
        return "index";
    }
    
    @RequestMapping("/appointment")
    public String appointment(Model model) {
    	//List<BookingDTO> booking = bookingService.getListBooking();
    	List<Booking> booking = bookingRepository.findAll();
    	for(int i = 0; i<booking.size(); i++) {
    		System.err.println(booking.get(i).getService_id());
    		Service service = serviceRepository.findById(booking.get(i).getService_id()).get();
    		model.addAttribute("SERVICE", service.getServiceName());
    	}
    	model.addAttribute("LIST_CUSTOMER", booking);
        return "appointment";
    }
    
    @RequestMapping("/dental_clinic")
    public String doctors(Model model) {
        return "dental_clinic";
    }
    
    @RequestMapping("/clinic_admin")
    public String clinic_admin(Model model) {
    	List<DoctorsDTO> listDoctor = doctorsService.getAllListDoctor();
    	model.addAttribute("LIST_DOCTOR", listDoctor);
        return "clinic_admin";
    }
    
    @GetMapping("/accept/{phone}")
    public String accept(@PathVariable("phone") String id, Model model) {
    	bookingService.acceptCustomer(id); 
    	List<Booking> booking = bookingRepository.findAll();
    	for(int i = 0; i<booking.size(); i++) {
    		System.err.println(booking.get(i).getService_id());
    		Service service = serviceRepository.findById(booking.get(i).getService_id()).get();
    		model.addAttribute("SERVICE", service.getServiceName());
    	}
    	model.addAttribute("LIST_CUSTOMER", booking);
    	return "appointment";
    }
    
    @GetMapping("/deny/{phone}")
    public String deny(@PathVariable("phone") String id, Model model) {
    	bookingService.denyCustomer(id); 
    	List<Booking> booking = bookingRepository.findAll();
    	for(int i = 0; i<booking.size(); i++) {
    		System.err.println(booking.get(i).getService_id());
    		Service service = serviceRepository.findById(booking.get(i).getService_id()).get();
    		model.addAttribute("SERVICE", service.getServiceName());
    	}
    	model.addAttribute("LIST_CUSTOMER", booking);
    	return "appointment";
    }
    
    @RequestMapping("/history")
    public String history(Model model) {
    	return "history_appointment";
    }
    
    @RequestMapping("/rating")
    public String rating(Model model) {
    	List<RateDTO> rate = rateService.getAllRating();
    	model.addAttribute("LIST_RATE", rate);
    	return "rating";
    }
}
