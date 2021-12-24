package com.yourcodereview.java01.yourpersonalfinancesbot.controllers;

import com.yourcodereview.java01.yourpersonalfinancesbot.bot.PersonalFinancesBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {

    @Autowired
    private PersonalFinancesBot personalFinancesBot;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return personalFinancesBot.onWebhookUpdateReceived(update);
    }
}
