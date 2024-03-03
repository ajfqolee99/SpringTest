package com.ajfqolee.spring.test.ajax.service;

import java.util.Date;
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
	
	public int deleteBooking(int id) {
		int count = bookingRepository.deleteBooking(id);
		return count;
	}
	
	public int addBookinng(String name, Date date, int day, int headcount, String phoneNumber) {
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
		return count;
	}
	
	public Booking getBooking(String name, String phoneNumber) {
		Booking booking = bookingRepository.selectBooking(name, phoneNumber);
		return booking;
	}
	
}
