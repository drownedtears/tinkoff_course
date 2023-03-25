package scrapper.client.github;

import link.dto.GitHubLinkDto;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import scrapper.client.dto.GitHubDtoResponse;

import java.util.Objects;

@Component
@Data
public non-sealed class ClientGitHubImpl implements ClientGitHub {

    private String baseUrl;

    @Override
    public GitHubDtoResponse fetchInfo(GitHubLinkDto gitHubLinkDto) {
        String uri = Objects.isNull(baseUrl) ?
                String.format("https://api.github.com/repos/%s/%s",
                        gitHubLinkDto.nickname(), gitHubLinkDto.repo()) :
                baseUrl;

        return WebClient.create().get()
                .uri(uri)
                .retrieve()
                .bodyToMono(GitHubDtoResponse.class)
                .block();
    }
}
