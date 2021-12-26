package com.yourcodereview.java01.yourpersonalfinancesbot.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

@Component
public class BotStateContext {
    private Map<BotState, InputMessageHandler> messageHandlers = new HashMap<>();

    public BotStateContext(Map<BotState, InputMessageHandler> messageHandlers) {
        this.messageHandlers = messageHandlers;
    }

    public SendMessage processInputMessage(BotState currentState, Message message) {

        InputMessageHandler currentMessageHandler = findMessageHandler(currentState);

        return currentMessageHandler.handle(message);
    }

    private InputMessageHandler findMessageHandler(BotState currentState) {
        if (isFillingProfileState(currentState)) {
            return messageHandlers.get(BotState.SHOW_MAIN_MENU);
        }
        return messageHandlers.get(currentState);
    }

    private boolean isFillingProfileState(BotState currentState) {
        switch (currentState) {
            case ADD_EXPENSE:
            case ADD_INCOME:
            return true;
            default:
                return false;
        }
    }
}
