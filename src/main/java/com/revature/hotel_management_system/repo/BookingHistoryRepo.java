package com.revature.hotel_management_system.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.hotel_management_system.model.BookingHistory;
import com.revature.hotel_management_system.model.RoomBooking;

@Repository
public interface BookingHistoryRepo extends CrudRepository<BookingHistory, String> {

	RoomBooking findByRoomNo(int roomNo);

	List<BookingHistory> findByEmail(String userEmail);
}
