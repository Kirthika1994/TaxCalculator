package com.taxcalculator.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;
import com.taxcalculator.demo.service.TaxComputingService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TaxComputingController.class)
public class TaxComputingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaxComputingService taxComputingService;

	

}