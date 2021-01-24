package com.eugene.bot;

import com.eugene.model.City;
import com.eugene.service.ICityService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;


@Component
public class TouristBot extends TelegramLongPollingBot {

    private final ICityService cityService;

    public TouristBot(ICityService cityService) {
        this.cityService = cityService;
    }

    //получение имени бота
    @Override
    public String getBotUsername() {
        return "@BestTouristBot";
    }

    //получение токена бота
    @Override
    public String getBotToken() {
        return "1529852801:AAELj5FDxkz65oHZ4c8OcvY72G5COJ5uohc";
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
//        City city = cityService.getCityByName(update.getMessage().getText());
//        if (city != null) {
//            sendMessage.setText(city.getInfo());
//        } else {
//            sendMessage.setText("Некорректный ввод!");
//        }


        try {
            execute(sendMessageBuilder.build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
