package com.revature.hotel_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotel_management_system.model.BookingHistory;
import com.revature.hotel_management_system.model.RoomBooking;
import com.revature.hotel_management_system.repo.BookingHistoryRepo;


@Service
public class BookingHistoryService {


	@Autowired
	BookingHistoryRepo bookingHistoryRepo;
	
	public void add(RoomBooking roomBooking, float price) {
		BookingHistory bookingHistory=new BookingHistory();
		bookingHistory.setEmail(roomBooking.getEmail());
		bookingHistory.setRoomNo(roomBooking.getRoomNo());
		bookingHistory.setCheckInDate(roomBooking.getCheckInDate());
		bookingHistory.setCheckOutDate(roomBooking.getCheckOutDate());
		bookingHistory.setTypeOfRoom(roomBooking.getTypeOfRoom());
		bookingHistory.setAdults(roomBooking.getAdults());
		bookingHistory.setBill(price);
		bookingHistory.setChildren(roomBooking.getChildren());
		bookingHistory.setComments(roomBooking.getComments());
		bookingHistory.setServices(roomBooking.getServices());
		bookingHistoryRepo.save(bookingHistory);
		
	}

	public List<BookingHistory> getHistory(String userEmail) {
		List<BookingHistory> bookingHistory=(List<BookingHistory>) bookingHistoryRepo.findByEmail(userEmail);
		return bookingHistory;
	}

}
