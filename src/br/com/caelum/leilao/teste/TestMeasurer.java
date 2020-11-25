package br.com.caelum.leilao.teste;

import org.junit.Test;
import org.junit.Assert;

import br.com.caelum.leilao.dominio.Bid;
import br.com.caelum.leilao.dominio.Auction;
import br.com.caelum.leilao.dominio.User;
import br.com.caelum.leilao.servico.Measurer;
import org.junit.experimental.theories.suppliers.TestedOn;

public class TestMeasurer {

    @Test
    public void rateBidesInAscendingOrder() {
        User joao = new User("João");
        User jose = new User("José");
        User maria = new User("Maria");

        Auction auction = new Auction("Playstation 5");

        auction.setBid(new Bid(joao, 250.0));
        auction.setBid(new Bid(jose, 300.0));
        auction.setBid(new Bid(maria, 400.0));

        Measurer auctioneer = new Measurer();
        auctioneer.rate(auction);

        double highestBidExpected = 400;
        double lowestBidExpected = 250;

        Assert.assertEquals(highestBidExpected, auctioneer.getHighestBid(), 0.00001);
        Assert.assertEquals(lowestBidExpected, auctioneer.getLowestBid(), 0.00001);
    }

    @Test
    public void rateHighestBid() {
        User joao = new User("Pedro");
        User jose = new User("Joaniza");
        User maria = new User("Hyago");

        Auction auction = new Auction("Playstation 5");

        auction.setBid(new Bid(joao, 300.0));
        auction.setBid(new Bid(jose, 300.0));
        auction.setBid(new Bid(maria, 500.0));

        Measurer auctioneer = new Measurer();
        auctioneer.rate(auction);

        double highestBidExpected = 500;

        Assert.assertEquals(highestBidExpected, auctioneer.getHighestBid(), 0.00001);
    }

    @Test
    public void rateLowestBid() {
        User joao = new User("Pedro");
        User jose = new User("Joaniza");
        User maria = new User("Hyago");

        Auction auction = new Auction("Playstation 5");

        auction.setBid(new Bid(joao, 200.0));
        auction.setBid(new Bid(jose, 2000.0));
        auction.setBid(new Bid(maria, 10.0));

        Measurer auctioneer = new Measurer();
        auctioneer.rate(auction);

        double lowestBidExpected = 10;

        Assert.assertEquals(lowestBidExpected, auctioneer.getLowestBid(), 0.00001);
    }

    @Test
    public void userBidesInAscendingOrder() {
        User joao = new User("João");
        User jose = new User("José");
        User maria = new User("Maria");

        Auction auction = new Auction("Playstation 5");

        auction.setBid(new Bid(joao, 250.0));
        auction.setBid(new Bid(jose, 300.0));
        auction.setBid(new Bid(maria, 400.0));

        Measurer auctioneer = new Measurer();
        auctioneer.rate(auction);

        String userhighestBidExpected = "Maria";
        String userlowestBidExpected = "João";

        User userhighestBidResult = auctioneer.getUserHighestBid();
        User userlowestBidResult = auctioneer.getUserLowestBid();

        Assert.assertEquals(userhighestBidExpected, userhighestBidResult.getName());
        Assert.assertEquals(userlowestBidExpected, userlowestBidResult.getName());
    }

    @Test
    public void userHighestBid() {
        User joao = new User("João Pedro");
        User jose = new User("José Marcos");
        User maria = new User("Maria Madalena");

        Auction auction = new Auction("Playstation 5");

        auction.setBid(new Bid(joao, 5000.0));
        auction.setBid(new Bid(jose, 3250.0));
        auction.setBid(new Bid(maria, 5001.0));

        Measurer auctioneer = new Measurer();
        auctioneer.rate(auction);

        String userhighestBidExpected = "Maria Madalena";

        User userhighestBidResult = auctioneer.getUserHighestBid();

        Assert.assertEquals(userhighestBidExpected, userhighestBidResult.getName());
    }

    @Test
    public void userLowestBid() {
        User joao = new User("Pedro Henrique");
        User jose = new User("Hyago Souza");
        User maria = new User("João Pedro");

        Auction auction = new Auction("Playstation 5");

        auction.setBid(new Bid(joao, 3201.0));
        auction.setBid(new Bid(jose, 4600.0));
        auction.setBid(new Bid(maria, 4000.0));

        Measurer auctioneer = new Measurer();
        auctioneer.rate(auction);

        String userlowestBidExpected = "Pedro Henrique";

        User userlowestBidResult = auctioneer.getUserLowestBid();

        Assert.assertEquals(userlowestBidExpected, userlowestBidResult.getName());
    }
}
