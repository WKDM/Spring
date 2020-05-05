package com.spring.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.book.service.BookService;
import com.spring.book.service.CashierService;

@Component
public class BookController {
	@Autowired
	private BookService service; 
	@Autowired
	private CashierService cashierService;
	
	
	
	
	public void buyBook(){
		service.buyBook("1", "1001");
	}
	public void checkOut(){
		List<String> bids = new ArrayList<String>();
		bids.add("1");
		bids.add("2");
		cashierService.checkOut("1001", bids);
	}
}
