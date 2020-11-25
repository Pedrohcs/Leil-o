package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auction {
	private String description;
	private List<Bid> bids;
	
	public Auction(String description) {
		this.description = description;
		this.bids = new ArrayList<Bid>();
	}
	
	public void setBid(Bid bid) {
		bids.add(bid);
	}

	public List<Bid> getBids() {
		return Collections.unmodifiableList(bids);
	}
}
