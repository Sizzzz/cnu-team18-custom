package kr.ac.cnu.service.poker;

import java.util.*;
import java.util.List;

/**
 * Created by YJM on 2017-06-15.
 */
public class Evaluator {

    /*public int evaluate(List<Card> cardList) {

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
    }*/

    /*private boolean isROYAL_STRAIGHT_FLUSH(List<Card> cardList) {
    }

    private boolean isSTRAIGHT_FLUSH(List<Card> cardList) {
    }

    private boolean isFOUR_OF_A_KIND(List<Card> cardList) {
    }

    private boolean isFULL_HOUSE(List<Card> cardList) {
    }

    private boolean isFLUSH(List<Card> cardList) {
    }*/

    public boolean isSTRAIGHT(List<Card> cardList) {
        int[] rank = new int[5];
        int i = 0;
        for(Card card : cardList){
            rank[i] = card.getRank();
            i++;
        }
        Arrays.sort(rank);

        for(i = 0; i < 3;i++){
            if((rank[i] + 1 != rank[i+1]) && (rank[i] + 9 != rank[i+1]))
                return false;
        }
        return true;
    }

    public boolean isTHREE_OF_A_KIND(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }

        for (Integer key : tempMap.keySet()) {
            if (tempMap.get(key) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isTWO_PAIR(List<Card> cardList) {
        int pair_count = 0;
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for(Card card : cardList) {
            if(tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue()+1);
                tempMap.put(card.getRank(), count);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }
        for(Integer key : tempMap.keySet()) {
            if(tempMap.get(key) == 2) {
                pair_count++;
            }
        }
        if(pair_count == 2) { return true; }
        return false;
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

}
