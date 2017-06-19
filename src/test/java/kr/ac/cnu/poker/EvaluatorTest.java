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
                new Card(7, Suit.SPADES),
                new Card(10, Suit.SPADES),
                new Card(5, Suit.SPADES)
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
                new Card(7,Suit.SPADES),
                new Card(8, Suit.DIAMONDS),
                new Card(9, Suit.HEARTS)
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
                new Card(5,Suit.SPADES),
                new Card(9, Suit.CLUBS),
                new Card(12, Suit.HEARTS)
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
                new Card(5,Suit.SPADES),
                new Card(7, Suit.SPADES),
                new Card(11, Suit.SPADES)
        );
        boolean result = evaluator.isTWO_PAIR(cardList);
        assertThat(result, is(false));
    }

    @Test
    public void RANK가_3개가동일하면_트리플이다_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(12,Suit.CLUBS),
                new Card(12,Suit.DIAMONDS),
                new Card(12,Suit.HEARTS),
                new Card(5,Suit.SPADES),
                new Card(8,Suit.SPADES),
                new Card(7, Suit.SPADES),
                new Card(9, Suit.SPADES)
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
                new Card(7,Suit.SPADES),
                new Card(13,Suit.DIAMONDS),
                new Card(9,Suit.DIAMONDS)
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
                new Card(7,Suit.SPADES),
                new Card(6,Suit.DIAMONDS),
                new Card(9,Suit.DIAMONDS)
        );
        boolean result = evaluator.isTHREE_OF_A_KIND(cardList);
        assertThat(result, is(false));
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
        assertThat(result, is(false));
    }

    @Test
    public void SUIT가_5개가동일하면_플러쉬다_성공() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.HEARTS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(11,Suit.CLUBS),
                new Card(3,Suit.CLUBS)
        );
        boolean result = evaluator.isFLUSH(cardList);
        assertThat(result, is(Boolean.TRUE));
    }

    @Test
    public void SUIT가_5개가동일하면_플러쉬다_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.HEARTS),
                new Card(13,Suit.SPADES),
                new Card(2,Suit.DIAMONDS),
                new Card(11,Suit.CLUBS),
                new Card(3,Suit.CLUBS)
        );
        boolean result = evaluator.isFLUSH(cardList);
        assertThat(result, is(Boolean.FALSE));
    }

    @Test
    public void 페어와_트리플이_동시에있으면_풀하우스_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(3,Suit.DIAMONDS),
                new Card(3,Suit.HEARTS),
                new Card(3,Suit.SPADES),
                new Card(1,Suit.SPADES),
                new Card(2,Suit.HEARTS),
                new Card(13,Suit.SPADES)
        );
        boolean result = evaluator.isFULL_HOUSE(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 페어와_트리플이_동시에있으면_풀하우스_성공2() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.CLUBS),
                new Card(3,Suit.DIAMONDS),
                new Card(3,Suit.HEARTS),
                new Card(3,Suit.SPADES),
                new Card(4,Suit.SPADES),
                new Card(4,Suit.HEARTS),
                new Card(5,Suit.SPADES)
        );
        boolean result = evaluator.isFULL_HOUSE(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 페어와_트리플이_동시에있으면_풀하우스_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5,Suit.CLUBS),
                new Card(3,Suit.DIAMONDS),
                new Card(3,Suit.HEARTS),
                new Card(3,Suit.SPADES),
                new Card(8,Suit.SPADES),
                new Card(11,Suit.HEARTS),
                new Card(13,Suit.SPADES)
        );
        boolean result = evaluator.isFULL_HOUSE(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 트리플이_두개_있으면_풀하우스_성공() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.SPADES),
                new Card(4, Suit.CLUBS),
                new Card(4, Suit.SPADES),
                new Card(4, Suit.DIAMONDS),
                new Card(5, Suit.HEARTS)
        );

        boolean result = evaluator.isFULL_HOUSE(cardList);
        assertThat(result, is(Boolean.TRUE));
    }

    @Test
    public void RANK가_4개가동일하면_포카드다_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(2,Suit.HEARTS),
                new Card(2,Suit.SPADES),
                new Card(5,Suit.SPADES),
                new Card(12,Suit.SPADES),
                new Card(11,Suit.SPADES)
        );
        boolean result = evaluator.isFOUR_OF_A_KIND(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_4개가동일하면_포카드다_성공2() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(8,Suit.CLUBS),
                new Card(8,Suit.DIAMONDS),
                new Card(4,Suit.HEARTS),
                new Card(8,Suit.SPADES),
                new Card(8,Suit.CLUBS),
                new Card(11,Suit.SPADES),
                new Card(10,Suit.CLUBS)
        );
        boolean result = evaluator.isFOUR_OF_A_KIND(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void RANK가_4개가동일하면_포카드다_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(4,Suit.HEARTS),
                new Card(2,Suit.SPADES),
                new Card(5,Suit.SPADES),
                new Card(7,Suit.SPADES),
                new Card(9,Suit.SPADES)
        );
        boolean result = evaluator.isFOUR_OF_A_KIND(cardList);
        assertThat(result, is(false));
    }

    @Test
    public void 카드가_스트레이트이고_플러쉬면_스트레이트플러쉬_성공1() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.CLUBS),
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.HEARTS),
                new Card(9, Suit.DIAMONDS)
        );
        boolean result = evaluator.isSTRAIGHT_FLUSH(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 카드가_스트레이트이고_플러쉬면_스트레이트플러쉬_성공2() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.HEARTS),
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS),
                new Card(7, Suit.CLUBS),
                new Card(8, Suit.CLUBS)
        );
        boolean result = evaluator.isSTRAIGHT_FLUSH(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 카드가_스트레이트이고_플러쉬면_스트레이트플러쉬_성공3() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.CLUBS),
                new Card(12, Suit.DIAMONDS),
                new Card(11, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS)
        );
        boolean result = evaluator.isSTRAIGHT_FLUSH(cardList);
        assertThat(result, is(true));
    }

    @Test
    public void 카드가_스트레이트이고_플러쉬면_스트레이트플러쉬_실패() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.SPADES),
                new Card(12, Suit.DIAMONDS),
                new Card(11, Suit.CLUBS),
                new Card(13, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS)
        );
        boolean result = evaluator.isSTRAIGHT_FLUSH(cardList);
        assertThat(result, is(false));
    }

    @Test
    public void 랭크가_ATJQK이고_수트가같으면_로얄플러쉬이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.HEARTS),
                new Card(11,Suit.HEARTS),
                new Card(10,Suit.HEARTS),
                new Card(12,Suit.HEARTS),
                new Card(13,Suit.HEARTS),
                new Card(6,Suit.HEARTS),
                new Card(8,Suit.HEARTS)
        );

        boolean result = evaluator.isROYAL_STRAIGHT_FLUSH(cardList);
        assertThat(result, is(Boolean.TRUE));
    }

    @Test
    public void 랭크가_ATJQK이고_수트가다르면_로얄플러쉬가아니다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.HEARTS),
                new Card(11,Suit.DIAMONDS),
                new Card(10,Suit.HEARTS),
                new Card(12,Suit.HEARTS),
                new Card(13,Suit.HEARTS),
                new Card(11,Suit.HEARTS),
                new Card(5,Suit.HEARTS)
        );

        boolean result = evaluator.isROYAL_STRAIGHT_FLUSH(cardList);
        assertThat(result, is(Boolean.FALSE));
    }

    @Test
    public void 랭크가_ATJQK이아니고_수트가같으면_로얄플러쉬가아니다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.DIAMONDS),
                new Card(2,Suit.DIAMONDS),
                new Card(3,Suit.DIAMONDS),
                new Card(4,Suit.DIAMONDS),
                new Card(7,Suit.DIAMONDS),
                new Card(8,Suit.DIAMONDS),
                new Card(11,Suit.DIAMONDS)
        );

        boolean result = evaluator.isROYAL_STRAIGHT_FLUSH(cardList);
        assertThat(result, is(Boolean.FALSE));
    }
}
