package bot.command;

public enum CommandName {
    START("/start - начать"),
    HELP("/help - вывод всех доступных команд"),
    TRACK("/track - начать отслеживать ссылку"),
    UNTRACK("/untrack - прекратить отслеживать ссылку"),
    LIST("/list - вывод всех отслеживаемых ссылок");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getCommandNameShort() {
        return commandName.split(" - ")[0];
    }
    
    public String getCommandDescription() {
        return commandName.split(" - ")[1];
    }
}
