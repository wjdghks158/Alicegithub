package ac.kr.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.kr.hansung.dao.OfferDAO;
import ac.kr.hansung.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDAO offerDAO;
	
	public List<Offer> getCurrent() {
		
		
		return offerDAO.getOffers();
	}

	public void insert(Offer offer) {
		offerDAO.insert(offer); 
		
	}

}
