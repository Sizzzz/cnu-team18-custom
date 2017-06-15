package kr.ac.cnu.service.poker;

/**
 * Created by dajab on 2017-06-15.
 */

import lombok.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
public class Deck {

    private List<Card> cardList;

    public Deck(int num) {
        this.cardList = new ArrayList<Card>();
        crateCard(num);
    }

    private void crateCard(int num)
    {
        for(int k = 0; k < num; k++) {
            for (Suit suit : Suit.values()) {
                for (int i = 1; i < 14; i++) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
        Collections.shuffle(cardList);
    }
}
