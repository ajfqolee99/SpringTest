package com.ajfqolee.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.jsp.domain.Realtor;
import com.ajfqolee.spring.test.jsp.service.RealtorService;

@Controller
@RequestMapping("/jsp/realtor")
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/create")
	public String createRealtor(
			@RequestParam("office") String office
			,@RequestParam("phoneNumber") String phoneNumber
			,@RequestParam("address") String address
			,@RequestParam("grade") String grade
			, Model model
			) 
	{
//		int count = realtorService.addRealtor(office, phoneNumber, address, grade);
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		model.addAttribute("realtor", realtor);
		
		int count = realtorService.addRealtorByObject(realtor);
		return "jsp/realtorInfo";
	}
	
	@GetMapping("/input")
	public String realtorInput() {
		return "jsp/realtor-input";
	}
	
	@GetMapping("/info")
	public String realtorInfo(Model model) {
		Realtor realtor = realtorService.getLastRealtor();
		
		model.addAttribute("realtor", realtor);
		
		return "jsp/realtorInfo";
	}
	
}
