package kr.ac.cnu.poker;

import kr.ac.cnu.service.poker.Deck;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dajab on 2017-06-15.
 */
public class DeckTest {

    @Test
    public void Deck2개의_총카드수는_104(){
        Deck deck = new Deck(2);
        int totalCard = deck.getTotalCard();
        assertThat(totalCard, is(104));
    }
    @Test
    public void 싱글덱에서_카드를_한장뽑으면_51장이남는다() {
        Deck deck = new Deck();
        deck.drawCard();
        assertThat(deck.getTotalCard(), is(51));
    }
}
