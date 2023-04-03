package bot.command;

public class CommandContainer {
    private final Command commandChainHead;

    public CommandContainer() {
        Command unknownCommand = new UnknownCommand();
        Command listCommand = new ListCommand(unknownCommand);
        Command trackCommand = new TrackCommand(listCommand);
        Command untrackCommand = new TrackCommand(trackCommand);
        Command helpCommand = new HelpCommand(untrackCommand);
        this.commandChainHead = new StartCommand(helpCommand);
    }
    
    public Command getCommandChainHead() {
        return commandChainHead;
    }
}
