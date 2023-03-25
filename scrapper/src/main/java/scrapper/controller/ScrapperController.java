package scrapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import scrapper.dto.AddLinkDtoRequest;
import scrapper.dto.LinkDtoResponse;
import scrapper.dto.ListLinksDtoResponse;
import scrapper.dto.RemoveLinkDtoRequest;

@RestController
public class ScrapperController {

    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<Void> addChat(@PathVariable Integer id) {
        //todo service logic

        return ResponseEntity
                .status(200)
                .header("description", "Чат зарегистрирован")
                .build();
    }

    @DeleteMapping("/tg-chat/{id}")
    public ResponseEntity<Void> removeChat(@PathVariable Integer id) {
        //todo service logic

        return ResponseEntity
                .status(200)
                .header("description", "Чат успешно удалён")
                .build();
    }

    @GetMapping("/links")
    public ResponseEntity<ListLinksDtoResponse> getAllLinks(@RequestHeader("Tg-Chat-Id") Integer id) {
        ListLinksDtoResponse listLinksDtoResponse = null; //todo service logic

        return ResponseEntity
                .status(200)
                .header("description", "Ссылки успешно получены")
                .body(listLinksDtoResponse);
    }

    @PostMapping("/links")
    public ResponseEntity<LinkDtoResponse> addLink(@RequestHeader("Tg-Chat-Id") Integer id,
                                                   @RequestBody AddLinkDtoRequest addLinkDtoRequest) {
        LinkDtoResponse linkDtoResponse = null; //todo service logic

        return ResponseEntity
                .status(200)
                .header("description", "Ссылка успешно добавлена")
                .body(linkDtoResponse);
    }

    @DeleteMapping("/links")
    public ResponseEntity<LinkDtoResponse> removeLink(@RequestHeader("Tg-Chat-Id") Integer id,
                                                   @RequestBody RemoveLinkDtoRequest removeLinkDtoRequest) {
        LinkDtoResponse linkDtoResponse = null; //todo service logic

        return ResponseEntity
                .status(200)
                .header("description", "Ссылка успешно убрана")
                .body(linkDtoResponse);
    }
}
