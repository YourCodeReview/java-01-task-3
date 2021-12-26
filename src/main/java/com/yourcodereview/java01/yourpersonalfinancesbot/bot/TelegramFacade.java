package com.yourcodereview.java01.yourpersonalfinancesbot.bot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramFacade {
    private BotStateContext botStateContext;

    private static final Logger LOGGER = LogManager.getLogger();

    public TelegramFacade(BotStateContext botStateContext) {
        this.botStateContext = botStateContext;
    }

    public SendMessage handleUpdate(Update update) {
        SendMessage replyMessage = null;

        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            LOGGER.info("New callbackQuery from User: {}, userId: {}, with data: {}",
                    update.getCallbackQuery().getFrom().getUserName(),
                    callbackQuery.getFrom().getId(),
                    update.getCallbackQuery().getData());
            return null;
        }

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            LOGGER.info("New message from User: {}, userId: {}, chatId: {}, with text: {}",
                    message.getFrom().getUserName(), message.getFrom().getId(), message.getChatId(), message.getText());
            replyMessage = handleInputMessage(message);
        }
        return replyMessage;
    }

    private SendMessage handleInputMessage(Message message) {
        String inputMessage = "Please choose category";
        String chatId = message.getFrom().getId().toString();
        BotState botState;

        SendMessage replyMessage = createMessageWithKeyboard(chatId, inputMessage, getInlineMessageButtons());

        return replyMessage;
    }

    private SendMessage createMessageWithKeyboard(String chatId,
                                                  String textMessage,
                                                  final InlineKeyboardMarkup replyKeyboardMarkup) {
        final SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(textMessage);
        if (replyKeyboardMarkup != null) {
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        return sendMessage;
    }

    private InlineKeyboardMarkup getInlineMessageButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton expenseButton = new InlineKeyboardButton();
        InlineKeyboardButton incomeButton = new InlineKeyboardButton();
        InlineKeyboardButton monthExpenseButton = new InlineKeyboardButton();
        InlineKeyboardButton statsButton = new InlineKeyboardButton();

        expenseButton.setText("Add expense");
        incomeButton.setText("Add income");
        monthExpenseButton.setText("Show month expense");
        statsButton.setText("Show statistics");

        expenseButton.setCallbackData("AddExpense");
        incomeButton.setCallbackData("AddIncome");
        monthExpenseButton.setCallbackData("ShowMonthExpense");
        statsButton.setCallbackData("ShowStatistics");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(expenseButton);
        keyboardButtonsRow1.add(incomeButton);

        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(monthExpenseButton);
        keyboardButtonsRow2.add(statsButton);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
