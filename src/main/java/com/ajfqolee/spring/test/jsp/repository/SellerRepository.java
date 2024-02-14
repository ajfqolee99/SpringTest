package com.ajfqolee.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqolee.spring.test.jsp.domain.Seller;

@Mapper
public interface SellerRepository {
	
	public int insertSeller(
			@Param("nickname") String nickname
			,@Param("profileImage") String profileImage
			,@Param("temperature") double temperature
			);
	
	public int insertSellerByObject(Seller seller);
	
	public Seller selectLastSeller();
	
	public Seller selectSeller(@Param("id") int id);
	
}
