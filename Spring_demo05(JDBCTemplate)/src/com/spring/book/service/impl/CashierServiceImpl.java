package com.spring.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.book.service.BookService;
import com.spring.book.service.CashierService;

@Service
@Transactional
public class CashierServiceImpl implements CashierService{
	
	@Autowired
	private BookService service;
	@Override
	public void checkOut(String uid, List<String> bids) {
		for(String bid:bids){
			service.buyBook(bid, uid);
		}
	}

}
