package com.eugene.bot;

import com.eugene.model.City;
import com.eugene.service.ICityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

@Component
public class TouristBot extends TelegramLongPollingBot {
    private final ICityService cityService;

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    public TouristBot(ICityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage.SendMessageBuilder sendMessageBuilder = SendMessage.builder()
                .chatId(update.getMessage().getChatId().toString());
        String name = update.getMessage().getText();
        Optional<City> city = cityService.getCityByName(name);
        if (city.isPresent()) {
            sendMessageBuilder = sendMessageBuilder.text(city.get().getInfo());
        } else {
            sendMessageBuilder = sendMessageBuilder.text("Нет информации по городу " + name);
        }

        try {
            execute(sendMessageBuilder.build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
