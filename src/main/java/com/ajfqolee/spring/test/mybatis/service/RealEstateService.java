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
	
	// 객체 형태로 한 행을 insert하기 위한 기능이 필요
	public int addRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		return count;
		
	}
	
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice
			) 
	{
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
	// 특정 id의 매물 정보에 전달받은 type과 price값으로 수정하는 기능
	public int updateRealEstate(int id, String tpye, int price) {
		int count = realEstateRepository.updateRealEstate(id, tpye, price);
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = realEstateRepository.deleteRealEstate(id);
		return count;
	}
	
}
