package bot.command;

import bot.telegrambot.SendMessageFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public non-sealed class TrackCommand implements Command {
    public static final String MESSAGE = "Теперь эта ссылка отслеживается";

    public static final String ALTER_MESSAGE = "Эта ссылка больше не отслеживается";

    private final Command nextCommand;

    public TrackCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public SendMessage execute(Update update) {
        Message message = update.getMessage();
        if (message.getText().startsWith("/track")) {
            //todo service logic
            return SendMessageFactory.produceTextMessage(update.getMessage().getChatId().toString(),
                                                  MESSAGE);
        } else if (message.getText().startsWith("/untrack"))  {
            //todo service logic
            return SendMessageFactory.produceTextMessage(update.getMessage().getChatId().toString(),
                                           ALTER_MESSAGE);
        } else {
           return nextCommand.execute(update);
        }
    }
}
