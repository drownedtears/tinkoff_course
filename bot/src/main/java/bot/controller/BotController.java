package bot.controller;

import bot.dto.LinkUpdateDtoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @PostMapping("/updates")
    public ResponseEntity<Void> updateLink(@RequestBody LinkUpdateDtoRequest linkUpdateDtoRequest) {
        //todo service logic

        return ResponseEntity
                .status(200)
                .header("description", "Обновление обработано")
                .build();
    }
}
