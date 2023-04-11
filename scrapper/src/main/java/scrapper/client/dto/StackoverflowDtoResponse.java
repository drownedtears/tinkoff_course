package scrapper.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class StackoverflowDtoResponse {
    @JsonProperty("items")
    private OffsetDateTime lastEditDate;
}
