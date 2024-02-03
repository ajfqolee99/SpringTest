package com.ajfqolee.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		// @Controller + @ResponseBody
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList() {
		// 변수는 객체의 데이터를 가지고 있는것이 아니라 객체의 주소를 가리키고 있는것이기 때문에
		// 저장할 객체의 주소를 가리켰으면 다른 객체의 주소를 가리킬때 재사용이 가능하다.
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>() {{put("rate", 15); put("director", "봉준호"); put("time", 131); put("title", "기생충");}};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 0); put("director", "로베르토 베니니"); put("time", 116); put("title", "인생은 아름다워");}};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 12); put("director", "크리스토퍼 놀란"); put("time", 147); put("title", "인셉션");}};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 19); put("director", "윤종빈"); put("time", 133); put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");}};
		list.add(map);
		map = new HashMap<String, Object>() {{put("rate", 15); put("director", "프란시스 로렌스"); put("time", 137); put("title", "헝거게임");}};
		list.add(map);
		
		return list;
	}
	
	@RequestMapping("/2")
	public List<Notice> noticeList() {
		
		List<Notice> list = new ArrayList<>();
		Notice memo = new Notice("안녕하세요. 가입인사드립니다.", "lhy", "안녕안녕");
		list.add(memo);
		memo = new Notice("헐 대박", "bada", "오늘이 수요일이였어");
		list.add(memo);
		memo = new Notice("오늘 데이트 한 이야기 해드릴게요", "ajfqo", "....");
		list.add(memo);
		
		return list;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Notice> entityResponse() {
		Notice memo = new Notice("오늘 데이트 한 이야기 해드릴게요", "ajfqo", "....");
		
		ResponseEntity<Notice> entity = new ResponseEntity(memo, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
}
