package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Bid;
import br.com.caelum.leilao.dominio.Auction;
import br.com.caelum.leilao.dominio.User;

public class Measurer {
    private double highestBid = Double.NEGATIVE_INFINITY;
    private double lowestBid = Double.POSITIVE_INFINITY;
    private User userHighestBid;
    private User userLowestBid;

    public User getUserHighestBid() {
        return userHighestBid;
    }

    public User getUserLowestBid() {
        return userLowestBid;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public double getLowestBid() {
        return lowestBid;
    }

    public void rate(Auction auction) {
        for ( Bid bid : auction.getBids() ) {
            if ( bid.getValue() > highestBid) {
                highestBid = bid.getValue();
                userHighestBid = bid.getUser();
            }
            if ( bid.getValue() < lowestBid) {
                lowestBid = bid.getValue();
                userLowestBid = bid.getUser();
            }
        }
    }
}
