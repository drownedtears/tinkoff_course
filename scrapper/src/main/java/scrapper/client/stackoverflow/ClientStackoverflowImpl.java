package scrapper.client.stackoverflow;

import link.dto.StackoverflowLinkDto;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import scrapper.client.dto.StackoverflowDtoResponse;

import java.util.Objects;

@Component
@Data
public non-sealed class ClientStackoverflowImpl implements ClientStackoverflow {

    private String baseUrl;

    @Override
    public StackoverflowDtoResponse fetchInfo(StackoverflowLinkDto stackoverflowLinkDto) {
        String uri = Objects.isNull(baseUrl) ?
                String.format("https://api.stackexchange.com/questions/%s?site=stackoverflow",
                        stackoverflowLinkDto.id()) :
                baseUrl;

        return WebClient.create().get()
                .uri(uri)
                .retrieve()
                .bodyToMono(StackoverflowDtoResponse.class)
                .block();
    }
}
