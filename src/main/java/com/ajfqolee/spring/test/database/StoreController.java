package com.ajfqolee.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.database.domain.Store;
import com.ajfqolee.spring.test.database.service.StoreService;

public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
		
	}

}
