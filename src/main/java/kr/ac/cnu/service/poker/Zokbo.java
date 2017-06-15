package kr.ac.cnu.service.poker;

/**
 * Created by YJM on 2017-06-15.
 */

/**
 * https://www.pokerstars.com/poker/?no_redirect=1
 * 위 사이트의 족보를 토대로 작성함.
 * 위에서부터 아래로 내림차순
 */
public enum Zokbo {
    ROYAL_FLUSH(1),
    STRAIGHT_FLUSH(2),
    FOUR_OF_A_KIND(3),
    FULL_HOUSE(4),
    FLUSH(5),
    STRAIGHT(6),
    THREE_OF_A_KIND(7),
    TWO_PAIR(8),
    PAIR(9),
    HIGH_CARD(10);
}
