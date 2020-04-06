package com.morrisje.console;

import com.morrisje.Game;
import com.morrisje.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * John Morris - 4/5/20
 * guess-the-number-game
 **/

@Component
public class ConsoleNumberGuess  {

    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //Fields
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;


    @EventListener(ContextRefreshedEvent.class) // Remove the class def from the method call instead of having a unused event
    public void startup() {
        log.info("Setup with Event Listener instead of implementing the class ");
        log.info("Startup -->>> Container READY");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();


            if (game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again");

                String playAgain = scanner.nextLine().trim();
                if (!playAgain.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }

        }
    }
}
