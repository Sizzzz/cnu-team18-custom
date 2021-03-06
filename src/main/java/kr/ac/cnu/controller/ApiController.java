package kr.ac.cnu.controller;

import io.swagger.annotations.ApiOperation;
import kr.ac.cnu.service.PokerService;
import kr.ac.cnu.service.poker.Card;
import kr.ac.cnu.service.poker.Deck;
import kr.ac.cnu.service.poker.Hand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sizz on 2017-06-12.
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    /*
     * Poker API
     */
    static PokerService pokerService = new PokerService();

    @RequestMapping(value = "/createRandomCard", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("랜덤 카드 뽑기")
    public Card createRandomCard() { return pokerService.createRandomCard(); }

    @RequestMapping(value = "/createHand", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("랜덤 핸드 구성")
    public Hand createHand() { return pokerService.createHand(); }
}
