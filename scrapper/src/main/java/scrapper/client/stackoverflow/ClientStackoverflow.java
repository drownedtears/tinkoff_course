package scrapper.client.stackoverflow;

import link.dto.StackoverflowLinkDto;
import scrapper.client.dto.StackoverflowDtoResponse;

public sealed interface ClientStackoverflow permits ClientStackoverflowImpl {
    StackoverflowDtoResponse fetchInfo(StackoverflowLinkDto stackoverflowLinkDto);
}
