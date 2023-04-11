package bot.dto;

public record ApiErrorDtoResponse(String description, String code, String exceptionName,
                                  String exceptionMessage, String[] stacktrace) {

}
