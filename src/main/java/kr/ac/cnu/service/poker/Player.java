package kr.ac.cnu.service.poker;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dajab on 2017-06-15.
 */
@AllArgsConstructor
@Data
public class Player implements Comparable<Player>{
    private String name = null;
    private int number;
    private List<Card> cardList = new ArrayList<Card>();
    private Card lastCard = null;

    public Player(){}


    @Override
    public int compareTo(Player o) {
        return 0;
    }
}
