package com.taxcalculator.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxcalculator.demo.exception.NoShareFoundException;
import com.taxcalculator.demo.exception.NoTradeFoundException;
import com.taxcalculator.demo.exception.ShareAlreadyExistsException;
import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;
import com.taxcalculator.demo.service.TaxComputingService;
import org.springframework.http.ResponseEntity;

@RestController
public class TaxComputingController {

	@Autowired
	TaxComputingService taxComputingService;

	@PostMapping("/addshare")
	public ResponseEntity<Integer> addShare(@RequestBody Share share) throws ShareAlreadyExistsException {
		return new ResponseEntity<Integer>(taxComputingService.addShare(share), HttpStatus.CREATED);
	}

	@GetMapping("/shareslist")
	public ResponseEntity<List<Share>> getShareDetails() throws NoShareFoundException {
		return new ResponseEntity<List<Share>>(taxComputingService.getShareDetails(), HttpStatus.OK);
	}

	@PostMapping("/addtrade/{shareId}/{quantity}")
	public ResponseEntity<Trade> addTrade(@PathVariable int shareId, @PathVariable int quantity)
			throws NoShareFoundException {
		return new ResponseEntity<Trade>(taxComputingService.addTrade(shareId, quantity), HttpStatus.CREATED);
	}

	@GetMapping("/tradeslist")
	public ResponseEntity<List<Trade>> getTradeDetails() throws NoTradeFoundException {
		return new ResponseEntity<List<Trade>>(taxComputingService.getTradeDetails(), HttpStatus.OK);
	}

	@GetMapping("/trade/{tradeId}")
	public ResponseEntity<Trade> getTradebyId(@PathVariable int tradeId) throws NoTradeFoundException {
		return new ResponseEntity<Trade>(taxComputingService.getTradebyId(tradeId), HttpStatus.OK);
	}

	@ExceptionHandler(value = ShareAlreadyExistsException.class)
	public ResponseEntity<String> handleshareAlreadyExistsException(
			ShareAlreadyExistsException shareAlreadyExistsException) {
		return new ResponseEntity<String>("Share already exists with this shareID", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoShareFoundException.class)
	public ResponseEntity<String> handleNoshareFoundException(NoShareFoundException noShareFoundException) {
		return new ResponseEntity<String>("No shares Found for this operation", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NoTradeFoundException.class)
	public ResponseEntity<String> handleNoTradeFoundException(NoTradeFoundException noTradeFoundException) {
		return new ResponseEntity<String>("No Trade Found for this operation", HttpStatus.CONFLICT);
	}

}
