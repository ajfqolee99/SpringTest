package com.ajfqolee.spring.test.jstl.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqolee.spring.test.jstl.domain.WeatherHistory;

@Mapper
public interface WeatherRepository {
	
	public List<WeatherHistory> selectWeatherHistory();
	
	public int insertWeather(@Param("date") Date date
			,@Param("weather") String weather
			,@Param("microDust") String microDust
			,@Param("temperatures") double temperatures
			,@Param("precipitation") double precipitation
			,@Param("windSpeed") double windSpeed
			);
	
	public int insertWeatherByObject(WeatherHistory weather);
	
}
