package kr.ac.cnu.service.poker;

import lombok.Data;

/**
 * Created by sizz on 2017-06-15.
 */
@Data
public class Card implements Comparable<Card>{
    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        if (rank > 13) {
            // error
        }
    }

    public int compareTo(Card o) {
        int result = this.getRank() - o.getRank();

        if (result == 0)//랭크가 같다면
            return this.getSuit().ordinal() - o.getSuit().ordinal();
        else
            return result;
    }
}
