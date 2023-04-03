package bot.client;

import bot.client.dto.ScrapperAddLinkDtoRequest;
import bot.client.dto.ScrapperLinkDtoResponse;
import bot.client.dto.ScrapperLinksDtoResponse;
import bot.client.dto.ScrapperRemoveLinkDtoRequest;
import org.springframework.http.ResponseEntity;

public interface ClientScrapper {
    ResponseEntity executeAddChat(String id);
    
    ResponseEntity executeRemoveChat(String id);
    
    ScrapperLinksDtoResponse getAllLinks(Integer id);
    
    ScrapperLinkDtoResponse addLink(Integer id, ScrapperAddLinkDtoRequest addLinkDtoRequest);
    
    ScrapperLinkDtoResponse removeLink(Integer id, ScrapperRemoveLinkDtoRequest removeLinkDtoRequest);
}
