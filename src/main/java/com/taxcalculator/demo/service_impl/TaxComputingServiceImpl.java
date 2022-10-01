package com.taxcalculator.demo.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.demo.exception.NoShareFoundException;
import com.taxcalculator.demo.exception.NoTradeFoundException;
import com.taxcalculator.demo.exception.ShareAlreadyExistsException;
import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;
import com.taxcalculator.demo.repository.SharesRepository;
import com.taxcalculator.demo.repository.TradesRepository;
import com.taxcalculator.demo.service.TaxComputingService;

@Service
public class TaxComputingServiceImpl implements TaxComputingService {

	@Autowired
	SharesRepository sharesRepository;

	@Autowired
	TradesRepository tradesRepository;

	public Double computeTax(int quantity, double price, float taxRate) {
		return (quantity * price * taxRate) / 100;
	}

	public Double computePrice(int quantity, double price, double tax) {
		return ((quantity * price) + tax);
	}

	public List<Share> getShareDetails() {
		if (sharesRepository.findAll().isEmpty()) {
			throw new NoShareFoundException();
		}
		return sharesRepository.findAll();
	}

	public int addShare(Share share) {
		if (sharesRepository.existsById(share.getShareId())) {
			throw new ShareAlreadyExistsException();
		}
		sharesRepository.save(share);
		return share.getShareId();
	}

	public List<Trade> getTradeDetails() {
		if (tradesRepository.findAll().isEmpty()) {
			throw new NoTradeFoundException();
		}
		return tradesRepository.findAll();
	}

	public Trade addTrade(int shareId, int quantity) {
		if (sharesRepository.findById(shareId).isEmpty()) {
			throw new NoShareFoundException();
		}
		Share share = sharesRepository.findById(shareId).get();
		Trade trade = new Trade();
		trade.setShareName(share.getShareName());
		trade.setQuantity(quantity);
		trade.setComputedTax(computeTax(quantity, share.getSharePrice(), share.getTaxRate()));
		trade.setTotalPrice(computePrice(quantity, share.getSharePrice(), trade.getComputedTax()));
		tradesRepository.save(trade);
		return trade;
	}

	public Trade getTradebyId(int tradeId) {
		if (tradesRepository.findById(tradeId).isEmpty()) {
			throw new NoTradeFoundException();
		}
		Trade trade = tradesRepository.findById(tradeId).get();
		return trade;
	}

}
