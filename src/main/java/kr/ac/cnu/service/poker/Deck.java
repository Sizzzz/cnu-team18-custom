package kr.ac.cnu.service.poker;

/**
 * Created by dajab on 2017-06-15.
 */

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Deck {

    private List<Card> cardList;

    public Deck() {
        this.cardList = new ArrayList<Card>();
        crateCard(1);
    }

    private void crateCard(int num)
    {
        for(int k = 0; k < num; k++)
        {
            for(Suit suit : Suit.values())
            {
                for(int i = 1; i< 14;i++)
                {
                    Card card = new Card(i,suit);
                    cardList.add(card);
                }
            }
        }
    }
}
