package kr.ac.cnu.poker;

import kr.ac.cnu.service.poker.Card;
import kr.ac.cnu.service.poker.Suit;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sizz on 2017-06-15.
 */
public class CardTest {
    @Test
    public void 카드_5_다이아몬드_생성() {
        Card card = new Card(5, Suit.DIAMONDS);
        assertThat(card.getRank(), is(5));
        assertThat(card.getSuit(), is(Suit.DIAMONDS));
    }

    @Test
    public void 카드의_랭크는_13이하여야한다() {
        new Card(14, Suit.CLUBS);
    }

}
