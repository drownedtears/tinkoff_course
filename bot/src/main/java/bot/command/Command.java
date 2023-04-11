package bot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public sealed interface Command permits StartCommand, HelpCommand, TrackCommand, ListCommand, UnknownCommand {
    SendMessage execute(Update update);

    default String wrapMessage(String message) {
        return String.format("<b>%s</b>", message);
    }
}
