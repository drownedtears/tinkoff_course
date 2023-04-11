package link.parser;

import link.dto.LinkDto;
import link.dto.UnknownLinkDto;

public record UnknownLinkParser() implements LinkParser {
    @Override
    public LinkDto parse(String link) {
        return new UnknownLinkDto(link);
    }
}
