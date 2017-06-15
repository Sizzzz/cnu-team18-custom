package kr.ac.cnu.service.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sizz on 2017-06-15.
 */
public class Evaluator {

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
