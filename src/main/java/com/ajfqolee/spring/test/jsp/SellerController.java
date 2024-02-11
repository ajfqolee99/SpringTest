package com.ajfqolee.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.jsp.domain.Seller;
import com.ajfqolee.spring.test.jsp.service.SellerService;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			,@RequestParam("profileImage") String profileImage
			,@RequestParam("temperature") double temperature
			) 
	{
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		return "입력성공 : " + count;
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "jsp/seller-input";
	}
	
	@GetMapping("/info")
	public String sellerInfo(Model model, @RequestParam("id") int id) {
		
		Seller seller = sellerService.getLastSeller();
		model.addAttribute("title", "판매자 정보");
		model.addAttribute("result", seller);
		
		return "jsp/sellerInfo";
	}
	
	
}
