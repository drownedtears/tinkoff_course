package bot.controller;

import bot.dto.ApiErrorDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorDtoResponse> incorrectParams(RuntimeException e) {
        return ResponseEntity
                .status(400)
                .header("description", "Некорректные параметры запроса")
                .body(new ApiErrorDtoResponse("Некорректные параметры запроса", "400",
                        e.getClass().toString(),
                        e.getMessage(),
                        Arrays.stream(e.getStackTrace())
                                .map(StackTraceElement::toString)
                                .toArray(String[]::new)
                ));
    }
}
