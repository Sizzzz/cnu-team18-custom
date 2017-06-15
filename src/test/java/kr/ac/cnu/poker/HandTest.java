package kr.ac.cnu.poker;

import kr.ac.cnu.service.poker.Hand;
import kr.ac.cnu.service.poker.PokerType;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by USER on 2017-06-15.
 */
public class HandTest {
    @Test
    public void 파이브카드_핸드_카드숫자는_5() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck, PokerType.FIVE);
        assertThat(hand.getTotalCard(), is(5));
    }
    @Test
    public void 세븐카드_핸드_카드숫자는_7() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck, PokerType.SEVEN);
        assertThat(hand.getTotalCard(), is(7));
    }
}
