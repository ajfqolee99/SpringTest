package com.ajfqolee.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.jpa.domain.Employment;
import com.ajfqolee.spring.test.jpa.repository.EmploymentRepository;

@Controller
@RequestMapping("/jpa/employment/read")
public class EmploymentController {
	
	@Autowired
	private EmploymentRepository employmentRepository;
	
	@GetMapping("/1")
	@ResponseBody
	public Employment readEmploymentById() {
		
//		연습문제 1
		Optional<Employment> optionalem = employmentRepository.findById(8);
		Employment employment = optionalem.orElse(null);
		
		return employment;
	}
	
	@GetMapping("/2")
	@ResponseBody
	public List<Employment> readEmploymentByCompanyId(@RequestParam("companyId") int companyId) {
		List<Employment> emList = employmentRepository.findByCompanyId(companyId);
		return emList;
	}
	
	@GetMapping("/3")
	@ResponseBody
	public List<Employment> readEmployment() {
		
//		연습문제 3
//		List<Employment> emList = employmentRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
//		연습문제 4
//		List<Employment> emList = employmentRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
//		연습문제 5
//		List<Employment> emList = employmentRepository.findTop3ByTypeOrderBySalaryDesc("계약직");

//		연습문제 6		
//		List<Employment> emList = employmentRepository.findBySalaryBetween(7000, 8500);
		
//		연습문제 7
		List<Employment> emList = employmentRepository.findByNativeQuery("2026-04-10 00:00:00", 8100, "정규직");
		return emList;
	}
	
}
