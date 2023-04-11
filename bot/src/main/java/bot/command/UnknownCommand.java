package bot.command;

import bot.telegrambot.SendMessageFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public non-sealed class UnknownCommand implements Command {
    public static final String MESSAGE = "Такой команды не существует, используй <b>/help</b>" +
            " для просмотра команд";

    @Override
    public SendMessage execute(Update update) {
        return SendMessageFactory.produceTextMessage(update.getMessage().getChatId().toString(),
                                                     MESSAGE);
    }
}
