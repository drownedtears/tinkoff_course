package link.parser;

import link.dto.LinkDto;

public sealed interface LinkParser permits GitHubLinkParser, StackoverflowLinkParser, UnknownLinkParser {
    LinkDto parse(String link);
}

