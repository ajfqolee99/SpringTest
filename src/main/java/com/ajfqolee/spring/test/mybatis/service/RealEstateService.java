package com.ajfqolee.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqolee.spring.test.mybatis.domain.RealEstate;
import com.ajfqolee.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		return realEstate;
	}
	
	public List<RealEstate> getRealEstateRent(int rent) {
		
		List<RealEstate> realEstateRentList = realEstateRepository.selectRealEstateRent(rent);
		return realEstateRentList;
		
	}
	
	public List<RealEstate> getRealEstateAreaPrice(int area, int price) {
		
		List<RealEstate> realEstateAreaPriceList = realEstateRepository.selectRealEstateAreaPrice(area, price);
		return realEstateAreaPriceList;
		
	}
	
}
