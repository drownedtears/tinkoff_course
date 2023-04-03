package link.dto;

public sealed interface LinkDto permits GitHubLinkDto, StackoverflowLinkDto, UnknownLinkDto { }

