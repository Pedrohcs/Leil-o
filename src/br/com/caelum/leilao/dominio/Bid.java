package br.com.caelum.leilao.dominio;

public class Bid {

	private User user;
	private double value;
	
	public Bid(User user, double value) {
		this.user = user;
		this.value = value;
	}

	public User getUsuario() {
		return user;
	}

	public double getValue() {
		return value;
	}
	
	
	
}
