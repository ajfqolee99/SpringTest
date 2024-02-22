package com.ajfqolee.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajfqolee.spring.test.ajax.domain.Booking;
import com.ajfqolee.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/tree")
public class TreeController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/site")
	public String treeSite() {
		return "ajax/tree/site";
	}
	
	@GetMapping("/list")
	public String treeList(Model model) {
		List<Booking> bookingList = bookingService.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "ajax/tree/list";
	}
	
	@GetMapping("/input")
	public String treeInput() {
		return "ajax/tree/input";
	}
	
	
	
	
}
