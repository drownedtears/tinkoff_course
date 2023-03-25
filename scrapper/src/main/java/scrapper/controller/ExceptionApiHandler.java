package scrapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scrapper.dto.ApiErrorDtoResponse;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionApiHandler {

    //поменять класс исключения, когда он станет известен
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

    //поменять класс исключения, когда он станет известен
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorDtoResponse> chatNotFound(RuntimeException e) {
        return ResponseEntity
                .status(404)
                .header("description", "Чат не существует")
                .body(new ApiErrorDtoResponse("Чат не существует", "404",
                        e.getClass().toString(),
                        e.getMessage(),
                        Arrays.stream(e.getStackTrace())
                                .map(StackTraceElement::toString)
                                .toArray(String[]::new)
                ));
    }

    //поменять класс исключения, когда он станет известен
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorDtoResponse> linkNotFound(RuntimeException e) {
        return ResponseEntity
                .status(404)
                .header("description", "Ссылка не найдена")
                .body(new ApiErrorDtoResponse("Чат не существует", "404",
                        e.getClass().toString(),
                        e.getMessage(),
                        Arrays.stream(e.getStackTrace())
                                .map(StackTraceElement::toString)
                                .toArray(String[]::new)
                ));
    }

}
