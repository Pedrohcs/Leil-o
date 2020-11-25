package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Bid;
import br.com.caelum.leilao.dominio.Auction;

public class Measurer {
    private double highestBid = Double.NEGATIVE_INFINITY;
    private double lowestBid = Double.POSITIVE_INFINITY;

    public double getHighestBid() {
        return highestBid;
    }

    public double getLowestBid() {
        return lowestBid;
    }

    public void rate(Auction auction) {
        for ( Bid bid : auction.getBids() ) {
            if ( bid.getValue() > highestBid) highestBid = bid.getValue();
            if ( bid.getValue() < lowestBid) lowestBid = bid.getValue();
        }
    }
}
