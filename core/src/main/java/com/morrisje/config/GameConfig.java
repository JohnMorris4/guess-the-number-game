package com.morrisje.config;

import com.morrisje.GuessCount;
import com.morrisje.MaxNumber;
import com.morrisje.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * John Morris - 4/6/20
 * guess-the-number-game
 **/
@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber:75}")
    private int maxNumber;

    @Value("${game.guessCount:8}")
    private int guessCount;

    @Value("${game.minNumber:3}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
