package com.ajfqolee.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajfqolee.spring.test.jstl.domain.WeatherHistory;
import com.ajfqolee.spring.test.jstl.service.WeatherService;

@Controller
@RequestMapping("/jstl/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherList(Model model) {
		// 날씨 리스트 얻어오기
		List<WeatherHistory> weatherHistory = weatherService.getWeatherHistory();
		
		model.addAttribute("weatherList", weatherHistory);
		
		return "jstl/weather/list";
	}
	
	@GetMapping("/input")
	public String inputWeather() {
		return "jstl/weather/input";
	}
	
	@GetMapping("/insert/")
	public String insertWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") Date date	// 2024년 2월 17일
//			,@RequestParam("weather") String weather
//			,@RequestParam("microDust") String microDust
//			,@RequestParam("temperatures") double temperatures
//			,@RequestParam("precipitation") double precipitation
//			,@RequestParam("windSpeed") double windSpeed
			@ModelAttribute WeatherHistory weather
			) 
	{	
//		int count = weatherService.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		int count = weatherService.addWeatherByObject(weather);
		return "redirect:/jstl/weather/list";
		
//		return "수행결과 : " + count;
	}
	
	
}
