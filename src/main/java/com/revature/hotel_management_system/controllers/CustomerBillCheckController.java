package com.revature.hotel_management_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.hotel_management_system.model.Bill;
import com.revature.hotel_management_system.services.CheckBillService;

@RestController
public class CustomerBillCheckController {
	
	@Autowired
	CheckBillService checkBillService;
	
	@PostMapping("/customer/checkBill")
	public ModelAndView customerBillCheck(@RequestParam("emailId") String emailId) {
		ModelAndView mv=new ModelAndView("/customer/display-bill.jsp");
		List<Bill> bill=checkBillService.checkBill(emailId);
		mv.addObject("customerBill",bill);
		mv.addObject("total",checkBillService.countTotalBill(bill));
		return mv;
		
	}

}
