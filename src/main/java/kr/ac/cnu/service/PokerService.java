package kr.ac.cnu.service;

import kr.ac.cnu.service.poker.Deck;

/**
 * Created by sizz on 2017-06-15.
 */
public class PokerService {
    public String createRandomCard() {
        Deck deck = new Deck();
        return deck.drawCard().toString();
    }
}

