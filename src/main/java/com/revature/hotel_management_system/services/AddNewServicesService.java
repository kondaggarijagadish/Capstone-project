package com.revature.hotel_management_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotel_management_system.model.Services;
import com.revature.hotel_management_system.repo.ServicesRepo;

@Service
public class AddNewServicesService {

	@Autowired
	ServicesRepo servicesRepo;
	public boolean addNewService(Services services) {
		if(services!=null) {
		servicesRepo.save(services);
		return true;
		}
		else
			return false;
		
	}
	
}
