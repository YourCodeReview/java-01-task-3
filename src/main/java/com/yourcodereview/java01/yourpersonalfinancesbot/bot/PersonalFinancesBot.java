package com.yourcodereview.java01.yourpersonalfinancesbot.bot;

import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PersonalFinancesBot extends TelegramWebhookBot {
    private String botName;
    private String botToken;
    private String botPath;

    private TelegramFacade telegramFacade;

    public PersonalFinancesBot(TelegramFacade telegramFacade) {
        this.telegramFacade = telegramFacade;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        BotApiMethod<?> replyMessageToUser = telegramFacade.handleUpdate(update);

        return replyMessageToUser;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public void setBotPath(String botPath) {
        this.botPath = botPath;
    }
}
