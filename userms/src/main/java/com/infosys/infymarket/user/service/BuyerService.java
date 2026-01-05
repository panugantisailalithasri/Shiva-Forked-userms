package com.infosys.infymarket.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infosys.infymarket.user.dto.BuyerDTO;
import com.infosys.infymarket.user.entity.Buyer;
import com.infosys.infymarket.user.repository.BuyerRepository;

@Service
@Transactional
public class BuyerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BuyerRepository buyerrepo;
    
    
	public void saveBuyer(String name, BuyerDTO buyerDTO) {
		logger.info("Creation request for customer {} with data {}", name, buyerDTO);
		buyerDTO.setName(name);
		Buyer buyer = buyerDTO.createBuyer();
		buyerrepo.save(buyer);
	}
	public List<BuyerDTO> getAllBuyer() {

		List<Buyer> buyers = buyerrepo.findAll();
		List<BuyerDTO> buyerDTOs = new ArrayList<>();

		for (Buyer buyer : buyers) {
			BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
			buyerDTOs.add(buyerDTO);
		}

		logger.info("Product Details : {}", buyerDTOs);
		return buyerDTOs;
	}
//	public void saveFriend(Long phoneNo, FriendFamilyDTO friendDTO) {
//		logger.info("Creation request for customer {} with data {}", phoneNo, friendDTO);
//		friendDTO.setPhoneNo(phoneNo);
//		FriendFamily friend = friendDTO.createFriend();
//		friendRepo.save(friend);
//	}


}
