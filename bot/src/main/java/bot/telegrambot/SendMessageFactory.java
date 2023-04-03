package bot.telegrambot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class SendMessageFactory {
    public static SendMessage produceTextMessage(String chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        sendMessage.enableHtml(true);
        return sendMessage;
    }
}
