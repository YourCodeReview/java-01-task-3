package com.yourcodereview.java01.yourpersonalfinancesbot.config;

import com.yourcodereview.java01.yourpersonalfinancesbot.bot.PersonalFinancesBot;
import com.yourcodereview.java01.yourpersonalfinancesbot.botconfig.PersonalFinancesBotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private PersonalFinancesBotConfig botConfig;

    @Bean
    public PersonalFinancesBot personalFinancesBot() {

        PersonalFinancesBot personalFinancesBot = new PersonalFinancesBot();

        personalFinancesBot.setBotName(botConfig.getBotName());
        personalFinancesBot.setBotToken(botConfig.getBotToken());
        personalFinancesBot.setBotToken(botConfig.getBotPath());

        return personalFinancesBot;
    }
}
