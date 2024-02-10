package com.ajfqolee.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqolee.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateRent(@Param("rent") int rent);
	
	public List<RealEstate> selectRealEstateAreaPrice(@Param("area") int area, @Param("price") int price);
	
	// 객체 기반의 Repository메소드는 Param를 선언해주지않아도 된다.
	public int insertRealEstateByObject(RealEstate realEstate);
	
	// 객체가 아닌 따로따로 각각의 정보를 서로다른 파라미터로 전달받아 저장할 메소드가 필요
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			,@Param("address") String address
			,@Param("area") int area
			,@Param("type") String type
			,@Param("price") int price
			,@Param("rentPrice") int rentPrice
			);
	
	public int updateRealEstate(
			@Param("id") int id
			,@Param("type") String type
			,@Param("price") int price);
	
	public int deleteRealEstate(@Param("id") int id);
	
}
