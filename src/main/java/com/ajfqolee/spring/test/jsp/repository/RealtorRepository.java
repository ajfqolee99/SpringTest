package com.ajfqolee.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqolee.spring.test.jsp.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	public int insertRealtor(
			@Param("office") String office
			,@Param("phoneNumber") String phoneNumber
			,@Param("address") String address
			,@Param("grade") String grade
			);
	
	public Realtor selectLastRealtor();
	
	
}
