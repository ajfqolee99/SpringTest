package com.ajfqolee.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01Controller {
	
	@RequestMapping("/1")
	public String test() {
		
		return "<h1>테스트 프로젝트 완성</h1><h4>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</h4>";
	}
	
	@RequestMapping("/2")
	public Map<String, Integer> scoreMap() {
		
		Map<String, Integer> score = new HashMap<>();
		score.put("국어", 100);
		score.put("수학", 65);
		score.put("영어", 80);
		
		return score;
		
	}
	
}
