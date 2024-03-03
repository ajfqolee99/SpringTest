package com.ajfqolee.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// 삭제 API 생성
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingService.deleteBooking(id);
		Map<String, String> resultMap = new HashMap<>();
		if(count > 0) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// 예약하기 API 생성
	@GetMapping("/booking")
	@ResponseBody
	public Map<String, String> booking(
			@RequestParam("name") String name
			,@DateTimeFormat(pattern = "yyyy년 MM월 dd일") @RequestParam("date") Date date
			,@RequestParam("day") int day
			,@RequestParam("headcount") int headcount
			,@RequestParam("phoneNumber") String phoneNumber
			) 
	{
		int count = bookingService.addBookinng(name, date, day, headcount, phoneNumber);
		Map<String, String> resultMap = new HashMap<>();
		if(count > 0) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// 이름과 전화번호를 전달받고, 일치하는 예약정보를 돌려주는 API
	@GetMapping("/search")
	@ResponseBody
	public Map<String, Object> searchBooking(@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingService.getBooking(name, phoneNumber);
		
		// 조회 결과가 있는지 없는지 명확히 구분해서 Response를 구성
		// 조회 성공 실패 여부를 Response에 추가
		// 조회 성공시 : {result:"success", "booking":{"name":"혜리", "date":"2024-02-21", ...}
		// 조회 실패시 : {result:"fail"
		Map<String, Object> resultMap = new HashMap<>(); 
		if(booking != null) {
			// 조회 성공
			resultMap.put("result", "success");
			resultMap.put("booking", booking);
		} else {
			// 조회 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}

}
