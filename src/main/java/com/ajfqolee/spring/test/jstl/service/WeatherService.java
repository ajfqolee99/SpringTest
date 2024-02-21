package com.ajfqolee.spring.test.jstl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqolee.spring.test.jstl.domain.WeatherHistory;
import com.ajfqolee.spring.test.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<WeatherHistory> getWeatherHistory() {
		
		List<WeatherHistory> weatherHistory = weatherRepository.selectWeatherHistory();
		return weatherHistory;
	}
	
	public int addWeather(
			Date date
			,String weather
			,String microDust
			,double temperatures
			,double precipitation
			,double windSpeed) 
	{
		int count = weatherRepository.insertWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		return count;
	}
	
	public int addWeatherByObject(WeatherHistory weather) {
		int count = weatherRepository.insertWeatherByObject(weather);
		return count;
	}

}
