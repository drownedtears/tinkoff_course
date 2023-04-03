package link;

import junit.framework.Assert;
import link.dto.GitHubLinkDto;
import link.dto.UnknownLinkDto;
import link.parser.GitHubLinkParser;
import link.parser.LinkParser;
import link.parser.StackoverflowLinkParser;
import link.parser.UnknownLinkParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LinkParserTest {
    
    @Test
    void testLinkParser() {
        LinkParser unknownLinkParser = new UnknownLinkParser();
        LinkParser gitHubLinkParser = new GitHubLinkParser(unknownLinkParser);
        LinkParser stackOverflowLinkParser = new StackoverflowLinkParser(gitHubLinkParser);
        
        Assert.assertTrue(stackOverflowLinkParser.parse("https://github.com/drownedtears/forum") instanceof GitHubLinkDto);
    
        Assert.assertTrue(stackOverflowLinkParser.parse("https://vk.com/") instanceof UnknownLinkDto);
    }
}
