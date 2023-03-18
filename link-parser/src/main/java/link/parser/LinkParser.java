package link.parser;

import link.dto.LinkDto;

public sealed interface LinkParser permits GitHubLinkParser, StackoverflowLinkParser {
    LinkDto parse(String link);
}

