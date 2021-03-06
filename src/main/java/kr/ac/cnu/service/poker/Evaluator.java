package kr.ac.cnu.service.poker;

import java.util.*;
import java.util.List;

/**
 * Created by YJM on 2017-06-15.
 */
public class Evaluator {

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

    public boolean isROYAL_STRAIGHT_FLUSH(List<Card> cardList) {
        Map <Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        int [] ATJQK = new int [7];
        boolean flag = false;
        int sum = 0;

        for(Card card : cardList) {
            if(card.getRank() == 1){
                ATJQK[0]++;
            } else if(card.getRank() == 10) {
                ATJQK[1]++;
            } else if(card.getRank() == 11) {
                ATJQK[2]++;
            } else if(card.getRank() == 12) {
                ATJQK[3]++;
            } else if(card.getRank() == 13) {
                ATJQK[4]++;
            }
        }

        for(int i : ATJQK) {
            if(ATJQK[i] != 0)
                sum += i;
        }

        if(sum == 5)
            flag = true;

        if(flag)
            if(isFLUSH(cardList)) { return true; }

        return false;
    }

    public boolean isSTRAIGHT_FLUSH(List<Card> cardList) {
        if(isSTRAIGHT(cardList) && isFLUSH(cardList))
            return true;
        return false;
    }

    public boolean isFOUR_OF_A_KIND(List<Card> cardList) {
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
            if (tempMap.get(key) == 4) { return true; }
        }
        return false;
    }

    public boolean isFULL_HOUSE(List<Card> cardList) {
        if( isPAIR(cardList) == true && isTHREE_OF_A_KIND(cardList) == true ) {
            return true;
        } else if(checkIfThereAreTwoSetsOfThreeCards(cardList)) {
            return true;
        }
        return false;
    }

    public boolean checkIfThereAreTwoSetsOfThreeCards(List<Card> cardList) {
        boolean result = false;
        try {
            List<Card> result0 = cardListCutIfAvail(cardList);
            if(result0.size() == 4) {
                List<Card> result1 = cardListCutIfAvail(result0);
                if(result1.size() == 1) {
                    result = true;
                }
            }
        } catch (NullPointerException e) {
            result = false;
        } finally {
            return result;
        }
    }

    private List cardListCutIfAvail(List<Card> cardList) {
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

        for (Integer key : tempMap.keySet()) {
            if (tempMap.get(key) == 3) {
                List<Card> tempList = new ArrayList<Card>();
                for(Card card : cardList) {
                    if(card.getRank() != key) {
                        tempList.add(card);
                    }
                }
                return tempList;
            }
        }
        return null;
    }

    public boolean isFLUSH(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) >= 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isSTRAIGHT(List<Card> cardList) {
        int[] rank = new int[cardList.size()];
        int i = 0;
        for(Card card : cardList){
            rank[i] = card.getRank();
            i++;
        }
        Arrays.sort(rank);

        int count = 0;

        for (i = 0; i < cardList.size() - 1; i++) {
            if (i < cardList.size() - 3) {
                if((rank[i] == rank[i+1]))
                    continue;
                else if ((rank[i] + 1 == rank[i + 1])) {
                    count++;
                } else if ((rank[i] + 9 == rank[i + 3])) {
                    count++;
                    i += 2;
                }else{
                    if(count == 4)
                        break;
                    else
                        count = 0;
                }
            } else {
                if((rank[i] == rank[i+1]))
                    continue;
                else if ((rank[i] + 1 == rank[i + 1])) {
                    count++;
                }else{
                    if(count >= 4)
                        break;
                    else
                        count = 0;
                }
            }
        }

        if (count >= 4)
            return true;
        else
            return false;
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
