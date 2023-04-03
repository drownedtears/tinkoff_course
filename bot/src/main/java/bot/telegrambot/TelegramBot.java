package bot.telegrambot;

import bot.command.CommandContainer;
import bot.command.CommandName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final Logger LOGGER  = LoggerFactory.getLogger(TelegramBot.class);

    private final String username;

    private final String token;
    
    private final CommandContainer commandContainer;
    
    public TelegramBot(@Value("${bot.username}") String username,
                       @Value("${bot.token}") String token) {
        this.username = username;
        this.token = token;
        this.commandContainer = new CommandContainer();
        createMenu();
        registerBot();
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
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            LOGGER.info("Получено сообщение. Пользователь '{}' пишет - '{}'", update.getMessage().getFrom().getUserName(), messageText);
            SendMessage sendMessage = commandContainer.getCommandChainHead().execute(update);
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException exception) {
                LOGGER.warn("Ошибка при отправке сообщения:{}", exception.getMessage());
            }
        }
    }
    
    public CommandContainer getCommandContainer() {
        return commandContainer;
    }
    
    private void registerBot() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка при регистрации бота: {}", e.getMessage());
        }
    }
    
    private void createMenu() {
        List<BotCommand> botCommands = Arrays.stream(CommandName.values())
                .map(name -> new BotCommand(name.getCommandNameShort(), name.getCommandDescription()))
                .collect(Collectors.toList());
        try {
            this.execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), "ru"));
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка при добавлении команд боту: {}", e.getMessage());
        }
        
    }
}
