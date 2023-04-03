package bot.client;

import bot.client.dto.ScrapperAddLinkDtoRequest;
import bot.client.dto.ScrapperLinkDtoResponse;
import bot.client.dto.ScrapperLinksDtoResponse;
import bot.client.dto.ScrapperRemoveLinkDtoRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClientScrapperImpl implements ClientScrapper {
    
    public ResponseEntity executeAddChat(String id) {
        return WebClient.create().post()
                .uri("localhost:8091/scrapper/tg-chat/" + id)
                .retrieve()
                .bodyToMono(ResponseEntity.class)
                .block();
    }
    
    public ResponseEntity executeRemoveChat(String id) {
        return WebClient.create().delete()
                .uri("localhost:8091/scrapper/tg-chat/" + id)
                .retrieve()
                .bodyToMono(ResponseEntity.class)
                .block();
    }
    
    @Override
    public ScrapperLinksDtoResponse getAllLinks(Integer id) {
        return WebClient.create().get()
                .uri("localhost:8091/scrapper/links")
                .header("Tg-Chat-Id", String.valueOf(id))
                .retrieve()
                .bodyToMono(ScrapperLinksDtoResponse.class)
                .block();
    }
    
    @Override
    public ScrapperLinkDtoResponse addLink(Integer id, ScrapperAddLinkDtoRequest addLinkDtoRequest) {
        return WebClient.create().method(HttpMethod.POST)
                .uri("localhost:8091/scrapper/links")
                .bodyValue(addLinkDtoRequest)
                .header("Tg-Chat-Id", String.valueOf(id))
                .retrieve()
                .bodyToMono(ScrapperLinkDtoResponse.class)
                .block();
    }
    
    @Override
    public ScrapperLinkDtoResponse removeLink(Integer id, ScrapperRemoveLinkDtoRequest removeLinkDtoRequest) {
        return WebClient.create().method(HttpMethod.DELETE)
                .uri("localhost:8091/scrapper/links")
                .bodyValue(removeLinkDtoRequest)
                .header("Tg-Chat-Id", String.valueOf(id))
                .retrieve()
                .bodyToMono(ScrapperLinkDtoResponse.class)
                .block();
    }
}
