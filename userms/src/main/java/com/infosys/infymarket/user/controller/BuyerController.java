package com.infosys.infymarket.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.infymarket.user.dto.BuyerDTO;
import com.infosys.infymarket.user.service.BuyerService;

@RestController
@CrossOrigin

public class BuyerController {

	private static final String String = null;

	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BuyerService buyerservice;
	
//	@Value("${friend.uri}")
//	String friendUri;
//
//	@Value("${path.uri}")
//	String pathUri;

	
//	// Create a new customer
//	@RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void createBuyer(@RequestBody BuyerDTO buyerDTO) {
//		logger.info("Creation request for customer {}", buyerDTO);
//		buyerService.saveBuyer(buyerDTO);
//	}
	@PostMapping(value = "/api/buyer/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createBuyer( @RequestBody BuyerDTO buyerDTO) {
		logger.info("Creation request for customer {} with data {}", buyerDTO);
		buyerservice.saveBuyer(String,buyerDTO);
	}
	@GetMapping(value = "/api/buyers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> getAllBuyer() {
		logger.info("Fetching all products");
		return buyerservice.getAllBuyer();
	}

//	// Login
//	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//	public boolean login(@RequestBody SellerDTO loginDTO) {
//		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
//		return custService.login(loginDTO);
//	}

	



}
