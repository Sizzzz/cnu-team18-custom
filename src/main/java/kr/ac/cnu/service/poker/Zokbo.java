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

    private int ZokboRank;

    Zokbo(int ZokboRank) {
        this.ZokboRank = ZokboRank;
    }
    public int getZokboRank() {
        return this.ZokboRank;
    }
    public void setZokboRank(int rank) {
        this.ZokboRank = rank;
    }

    public String getZokboName(int index){
        switch( index ){
            case 1:
                return Zokbo.ROYAL_FLUSH.name();
            case 2:
                return Zokbo.STRAIGHT_FLUSH.name();

            case 3:
                return Zokbo.FOUR_OF_A_KIND.name();

            case 4:
                return Zokbo.FULL_HOUSE.name();

            case 5:
                return Zokbo.FLUSH.name();

            case 6:
                return Zokbo.STRAIGHT.name();

            case 7:
                return Zokbo.THREE_OF_A_KIND.name();

            case 8:
                return Zokbo.TWO_PAIR.name();

            case 9:
                return Zokbo.PAIR.name();

            default:
                return Zokbo.HIGH_CARD.name();

        }
    }
}
