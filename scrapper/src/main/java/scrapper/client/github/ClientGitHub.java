package scrapper.client.github;


import link.dto.GitHubLinkDto;
import scrapper.client.dto.GitHubDtoResponse;

public sealed interface ClientGitHub permits ClientGitHubImpl {
    GitHubDtoResponse fetchInfo(GitHubLinkDto gitHubLinkDto);
}
