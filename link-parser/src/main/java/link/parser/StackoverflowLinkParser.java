package link.parser;

import link.dto.LinkDto;
import link.dto.StackoverflowLinkDto;

public record StackoverflowLinkParser(LinkParser next) implements LinkParser {
    @Override
    public LinkDto parse(String link) {
        if (link.contains("stackoverflow.com")) {
            String[] split = link.split("/");
            if (split.length > 4 && split[3].equals("questions")) {
                return split[4].equals("") ? next.parse(link) : new StackoverflowLinkDto("stackoverflow.com", split[4]);
            }
        }
        return next.parse(link);
    }
}
