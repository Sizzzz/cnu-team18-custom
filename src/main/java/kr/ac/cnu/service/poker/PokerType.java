package kr.ac.cnu.service.poker;

/**
 * Created by USER on 2017-06-15.
 */
public enum PokerType {
    FIVE(5), SEVEN(7);
    private int numberOfCard;
    PokerType(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }
    public int getNumberOfCard() {
        return this.numberOfCard;
    }
}
