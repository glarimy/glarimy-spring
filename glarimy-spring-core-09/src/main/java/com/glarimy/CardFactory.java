package com.glarimy;

public class CardFactory {
	public Card prepareCard() {
		Card card = new Card();
		card.setActive(true);
		return card;
	}
}
