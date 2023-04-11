package bot.command;

import bot.telegrambot.SendMessageFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public non-sealed class ListCommand implements Command {
    public static final String MESSAGE = "Список отслеживаемых ссылок:\n";
    
    public static final String ALTER_MESSAGE = "Список отслеживаемых ссылок пуст, чтобы добавить ссылку используй <b>/track 'link'</b>";

    private final Command nextCommand;

    public ListCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public SendMessage execute(Update update) {
        Message message = update.getMessage();
        if (message.getText().trim().equals("/list")) {
            //todo service logic
            return SendMessageFactory.produceTextMessage(message.getChatId().toString(),
                                                  MESSAGE + null);
        } else {
            return nextCommand.execute(update);
        }
    }
}
