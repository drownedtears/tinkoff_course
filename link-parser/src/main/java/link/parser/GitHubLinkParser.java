package link.parser;

import link.dto.GitHubLinkDto;
import link.dto.LinkDto;

public record GitHubLinkParser(LinkParser next) implements LinkParser {
    @Override
    public LinkDto parse(String link) {
        if (link.contains("github.com")) {
            String[] split = link.split("/");
            return new GitHubLinkDto("github.com", split[3], split[4]);
        }
        return next.parse(link);
    }
}
