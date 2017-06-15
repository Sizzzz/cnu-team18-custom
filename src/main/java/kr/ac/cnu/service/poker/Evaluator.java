package kr.ac.cnu.service.poker;

import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YJM on 2017-06-15.
 */
public class Evaluator {
    /*
    public int evaluate(List<Card> cardList) {

        if(isROYAL_STRAIGHT_FLUSH(cardList)) {
            return Zokbo.ROYAL_FLUSH.getZokboRank();
        }
        else if(isSTRAIGHT_FLUSH(cardList)) {
            return Zokbo.STRAIGHT_FLUSH.getZokboRank();
        }
        else if(isFOUR_OF_A_KIND(cardList)) {
            return Zokbo.FOUR_OF_A_KIND.getZokboRank();
        }
        else if(isFULL_HOUSE(cardList)) {
            return Zokbo.FULL_HOUSE.getZokboRank();
        }
        else if(isFLUSH(cardList)) {
            return Zokbo.FLUSH.getZokboRank();
        }
        else if(isSTRAIGHT(cardList)) {
            return Zokbo.STRAIGHT.getZokboRank();
        }
        else if(isTHREE_OF_A_KIND(cardList)) {
            return Zokbo.THREE_OF_A_KIND.getZokboRank();
        }
        else if(isTWO_PAIR(cardList)) {
            return Zokbo.TWO_PAIR.getZokboRank();
        }
        else if(isPAIR(cardList)) {
            return Zokbo.PAIR.getZokboRank();
        }
        else
            return Zokbo.HIGH_CARD.getZokboRank();
    }

    private boolean isROYAL_STRAIGHT_FLUSH(List<Card> cardList) {
    }

    private boolean isSTRAIGHT_FLUSH(List<Card> cardList) {
    }

    private boolean isFOUR_OF_A_KIND(List<Card> cardList) {
    }

    private boolean isFULL_HOUSE(List<Card> cardList) {
    }

    private boolean isFLUSH(List<Card> cardList) {
    }

    private boolean isSTRAIGHT(List<Card> cardList) {
    }

    private boolean isTHREE_OF_A_KIND(List<Card> cardList) {
    }

    private boolean isTWO_PAIR(List<Card> cardList) {
    }

    public boolean isPAIR(List<Card> cardList) {
        Map <Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for(Card card : cardList) {
            if(tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }
        for(Integer key : tempMap.keySet()) {
            if(tempMap.get(key) == 2) {
                return true;
            }
        }
        return false;
    }
    */
}
