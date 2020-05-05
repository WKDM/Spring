package com.spring.book.service;

import java.util.List;

public interface CashierService {
	void checkOut(String uid, List<String> bids);
}
