package com.taxcalculator.demo.service_impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;
import com.taxcalculator.demo.repository.SharesRepository;
import com.taxcalculator.demo.repository.TradesRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TaxComputingServiceTest {

	@InjectMocks
	TaxComputingServiceImpl taxComputingServiceImpl;

	@Mock
	SharesRepository sharesRepository;

	@Mock
	TradesRepository tradesRepository;

	
}
