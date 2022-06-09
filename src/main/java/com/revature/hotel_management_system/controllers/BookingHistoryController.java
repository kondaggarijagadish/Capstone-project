package com.revature.hotel_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.hotel_management_system.services.BookingHistoryService;

@RestController
public class BookingHistoryController {

	@Autowired
	BookingHistoryService bookingHistoryService;
	@PostMapping("/customer/bookingHistory")
	public ModelAndView customerBookingHistory(@RequestParam("emailId") String userEmail) {
		ModelAndView mv=new ModelAndView("/customer/bookingHistory.jsp");
		mv.addObject("bookingHistory",bookingHistoryService.getHistory(userEmail));
		return mv;
	}
	
}
