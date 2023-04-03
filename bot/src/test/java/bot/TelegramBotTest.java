package bot;

import bot.telegrambot.TelegramBot;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@SpringBootTest
class TelegramBotTest {
    @Autowired
    private TelegramBot telegramBot;
    
    @Test
    void testListCommand() {
        String expectedMessage = "Список отслеживаемых ссылок:\n";
        Update update = new Update();
        Message message = new Message();
        message.setText("/list");
        Chat chat = new Chat();
        chat.setId(12345L);
        message.setChat(chat);
        update.setMessage(message);
        Assert.assertTrue(telegramBot.getCommandContainer().getCommandChainHead().execute(update)
                .getText().contains(expectedMessage));
    }
    
    @Test
    void testUnknownCommand() {
        String expectedMessage = "Такой команды не существует, используй <b>/help</b> для просмотра команд";
        Update update = new Update();
        Message message = new Message();
        message.setText("/asd");
        Chat chat = new Chat();
        chat.setId(12345L);
        message.setChat(chat);
        update.setMessage(message);
        Assert.assertEquals(expectedMessage, telegramBot.getCommandContainer().getCommandChainHead().execute(update).getText());
    }
}
