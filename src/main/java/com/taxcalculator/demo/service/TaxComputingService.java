package com.taxcalculator.demo.service;

import java.util.List;

import com.taxcalculator.demo.exception.NoShareFoundException;
import com.taxcalculator.demo.exception.NoTradeFoundException;
import com.taxcalculator.demo.exception.ShareAlreadyExistsException;
import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;

public interface TaxComputingService {

	// Add share entity
	public int addShare(Share share) throws ShareAlreadyExistsException;

	// Get All share details
	public List<Share> getShareDetails() throws NoShareFoundException;

	// Add Trade
	public Trade addTrade(int shareId, int quantity) throws NoShareFoundException;

	// Get All Trade details
	public List<Trade> getTradeDetails() throws NoTradeFoundException;

	// Get Trade by ID
	public Trade getTradebyId(int tradeId) throws NoTradeFoundException;

}
