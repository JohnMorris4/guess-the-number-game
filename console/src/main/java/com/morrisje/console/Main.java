package com.morrisje.console;

import com.morrisje.AppConfig;
import com.morrisje.MessageGenerator;
import com.morrisje.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the Number Game");

        //create the context
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();
        log.info("number = {}", number);
//        Get game bean
//        Game game = context.getBean(Game.class);
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("Message Generator Class :: {}", messageGenerator.getMainMessage());
        log.info("Message Generator Class :: {}", messageGenerator.getResultMessage());


        context.close();

    }
}
