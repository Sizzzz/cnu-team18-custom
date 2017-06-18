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

    @Test
    public void 페어가_2개이면_투페어다_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(13,Suit.HEARTS),
                new Card(2,Suit.SPADES),
                new Card(7,Suit.SPADES)
        );
        boolean result = evaluator.isTWO_PAIR(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 페어가_2개이면_투페어다_성공2() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(13,Suit.HEARTS),
                new Card(2,Suit.SPADES),
                new Card(5,Suit.SPADES)
        );
        boolean result = evaluator.isTWO_PAIR(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 페어가_2개이면_투페어다_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5,Suit.CLUBS),
                new Card(3,Suit.DIAMONDS),
                new Card(13,Suit.HEARTS),
                new Card(2,Suit.SPADES),
                new Card(5,Suit.SPADES)
        );
        boolean result = evaluator.isTWO_PAIR(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_3개가동일하면_트리플이다_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(12,Suit.CLUBS),
                new Card(12,Suit.DIAMONDS),
                new Card(12,Suit.HEARTS),
                new Card(5,Suit.SPADES),
                new Card(8,Suit.SPADES)
        );
        boolean result = evaluator.isTHREE_OF_A_KIND(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_3개가동일하면_트리플이다_성공2() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.DIAMONDS),
                new Card(1,Suit.HEARTS),
                new Card(4,Suit.SPADES),
                new Card(7,Suit.SPADES)
        );
        boolean result = evaluator.isTHREE_OF_A_KIND(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_3개가동일하면_트리플이다_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(1,Suit.HEARTS),
                new Card(4,Suit.SPADES),
                new Card(7,Suit.SPADES)
        );
        boolean result = evaluator.isTHREE_OF_A_KIND(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_5개가나란하면_스트레이트다_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2, Suit.CLUBS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.CLUBS),
                new Card(11, Suit.CLUBS),
                new Card(13, Suit.CLUBS)
        );
        boolean result = evaluator.isSTRAIGHT(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_5개가나란하면_스트레이트다_성공2() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(6, Suit.HEARTS),
                new Card(5, Suit.CLUBS),
                new Card(2, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(2, Suit.SPADES),
                new Card(4, Suit.HEARTS)
        );
        boolean result = evaluator.isSTRAIGHT(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_5개가나란하면_스트레이트다_성공3() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.HEARTS),
                new Card(11, Suit.CLUBS),
                new Card(3, Suit.CLUBS),
                new Card(7, Suit.CLUBS),
                new Card(12, Suit.CLUBS),
                new Card(13, Suit.CLUBS)
        );
        boolean result = evaluator.isSTRAIGHT(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_5개가나란하면_스트레이트다_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.HEARTS),
                new Card(11, Suit.CLUBS),
                new Card(3, Suit.CLUBS),
                new Card(7, Suit.CLUBS),
                new Card(10, Suit.CLUBS),
                new Card(13, Suit.CLUBS)
        );
        boolean result = evaluator.isSTRAIGHT(cardList);
        assertThat(result, is(true));
    }
}
