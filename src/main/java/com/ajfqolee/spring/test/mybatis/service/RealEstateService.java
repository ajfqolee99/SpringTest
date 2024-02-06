package com.ajfqolee.spring.test.mybatis.service;

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
	
	@Autowired
	private RealEstateRepository realEstateRantRepository;
	
	public RealEstate getRealEstateRant(int rent) {
		
		RealEstate realEstateRant = realEstateRantRepository.selectRealEstateRant(rent);
		return realEstateRant;
		
	}
	
}
