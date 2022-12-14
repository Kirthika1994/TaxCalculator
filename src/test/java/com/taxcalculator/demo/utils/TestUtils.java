package com.taxcalculator.demo.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;

public class TestUtils {

	private TestUtils() {
	}

	public static Share getShare() {
		return new Share(1, "AVIVA", 100.0, 5);
	}

	public static List<Share> getShareList() {
		return Stream.of(getShare()).collect(Collectors.toList());
	}

	public static Trade getTrade() {
		return new Trade(1, "AVIVA", 10, 5, 15);
	}
	
	public static Trade getEmptyTrade() {
		return new Trade();
	}

	public static Optional<Trade> getTradeOptional() {
		return Optional.of(new Trade(1, "AVIVA", 10, 50, 1050));
	}

	public static List<Trade> getTradeList() {
		return Stream.of(getTrade()).collect(Collectors.toList());
	}
	
	public static List<Trade> getEmptyTradeList() {
		return Stream.of(getEmptyTrade()).collect(Collectors.toList());
	}

	public static Optional<Share> getShareOptional() {
		return Optional.of(new Share(1, "AVIVA", 100.0, 5));
	}

}
