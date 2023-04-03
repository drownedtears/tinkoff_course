package bot.command;

import bot.telegrambot.SendMessageFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.stream.Collectors;

public non-sealed class HelpCommand implements Command {
    public static final String MESSAGE = "Список доступных комманд:\n";

    private final Command nextCommand;

    public HelpCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public SendMessage execute(Update update) {
        Message message = update.getMessage();
        if (message.getText().trim().equals("/help")) {
            return SendMessageFactory.produceTextMessage(message.getChatId().toString(),
                                           MESSAGE + Arrays.stream(CommandName.values())
                            .map(commandName -> commandName.getCommandName())
                            .collect(Collectors.joining("\n"))
            );
        } else {
            return nextCommand.execute(update);
        }
    }
}
