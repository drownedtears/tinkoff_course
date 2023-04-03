package bot.command;

import bot.telegrambot.SendMessageFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public non-sealed class StartCommand implements Command {
    public static final String MESSAGE = "Привет, ";

    private final Command nextCommand;

    public StartCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public SendMessage execute(Update update) {
        Message message = update.getMessage();
        if (message.getText().trim().equals("/start")) {
            return SendMessageFactory.produceTextMessage(message.getChatId().toString(),
                                                  MESSAGE + wrapMessage(message.getFrom().getUserName()));
        } else {
            return nextCommand.execute(update);
        }
    }
}
