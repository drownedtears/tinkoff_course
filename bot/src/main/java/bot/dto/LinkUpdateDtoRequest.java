package bot.dto;

public record LinkUpdateDtoRequest(Integer id, String url, String description, Integer[] tgChatIds) {

}
