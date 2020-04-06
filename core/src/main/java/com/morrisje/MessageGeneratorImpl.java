package com.morrisje;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);


    @Autowired
    private Game game;


    @PostConstruct
    public void init(){
        logger.info("games = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() + " and " + game.getBiggest()
                + " Can you guess the number?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "You guessed the number. Congrats!!! Number was " + game.getNumber();
        } else if(game.isGameLost()){
            return "You lost" + game.getNumber();
        } else if (!game.isValidNumberRange()){
            return "Invalid number range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You have  " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
