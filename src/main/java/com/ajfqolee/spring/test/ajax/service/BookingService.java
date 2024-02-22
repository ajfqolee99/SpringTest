package com.ajfqolee.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqolee.spring.test.ajax.domain.Booking;
import com.ajfqolee.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getBookingList() {
		List<Booking> booking = bookingRepository.selectBookingList();
		return booking;
	}
	
}
