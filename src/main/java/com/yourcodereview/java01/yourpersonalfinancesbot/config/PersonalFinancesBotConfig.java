package com.yourcodereview.java01.yourpersonalfinancesbot.config;

import com.yourcodereview.java01.yourpersonalfinancesbot.bot.PersonalFinancesBot;
import com.yourcodereview.java01.yourpersonalfinancesbot.bot.TelegramFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.yourcodereview.java01.yourpersonalfinancesbot")
@PropertySource("classpath:application.properties")
public class PersonalFinancesBotConfig {

    @Value("${telegrambot.userName}")
    private String botName;

    @Value("${telegrambot.botToken}")
    private String botToken;

    @Value("${telegrambot.webHookPath}")
    private String botPath;

    @Bean
    public PersonalFinancesBot personalFinancesBot(TelegramFacade telegramFacade) {

        PersonalFinancesBot personalFinancesBot = new PersonalFinancesBot(telegramFacade);

        personalFinancesBot.setBotName(botName);
        personalFinancesBot.setBotToken(botToken);
        personalFinancesBot.setBotPath(botPath);

        return personalFinancesBot;
    }
}
