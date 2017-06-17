package kr.ac.cnu.service;

import kr.ac.cnu.service.poker.Card;
import kr.ac.cnu.service.poker.Deck;
import kr.ac.cnu.service.poker.Hand;
import kr.ac.cnu.service.poker.PokerType;

/**
 * Created by sizz on 2017-06-15.
 */
public class PokerService {

    // 랜덤으로 카드 한장을 뽑아 출력한다.
    public Card createRandomCard() {
        Deck deck = new Deck();
        return deck.drawCard();
    }

    // 랜덤의 카드로 핸드를 구성한다.
    public Hand createHand(PokerType type){
        Deck deck = new Deck();
        Hand hand = new Hand(deck, type);
        return hand;
    }
}

