package kr.ac.cnu.service.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2017-06-15.
 */
public class Hand {
    private List<Card> cardList;
    final static int MAX_HAND_NUM = 7;
    public Hand(Deck deck) {
        cardList = new ArrayList<Card>();
        for (int i = 0; i < MAX_HAND_NUM; i++) {
            cardList.add(deck.drawCard());
        }
    }
    public int getTotalCard() {
        return cardList.size();
    }

    public List<Card> getCardList(){
        return cardList;
    }
}
