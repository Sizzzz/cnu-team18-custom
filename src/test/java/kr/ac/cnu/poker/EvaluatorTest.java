package kr.ac.cnu.poker;

import kr.ac.cnu.service.poker.Card;
import kr.ac.cnu.service.poker.Evaluator;
import kr.ac.cnu.service.poker.Suit;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by USER on 2017-06-15.
 */
public class EvaluatorTest {
    @Test
    public void RANK가_2개가동일하면_페어다_성공() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.DIAMONDS),
                new Card(13, Suit.HEARTS),
                new Card(4, Suit.SPADES),
                new Card(7, Suit.SPADES)
        );
        boolean result = evaluator.isPAIR(cardList);
        assertThat(result, is(true));
    }
}
