package scrapper.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GitHubDtoResponse {
    @JsonProperty("items")
    private OffsetDateTime updatedAt;
}
