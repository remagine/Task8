package commandandtag;

public class CommandAndTag {
    private final Command command;
    private final Tag tag;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }

    public Tag executeCommand() {
        switch (command) {
            case EXECUTE:
                return tag.execute();
            case CREATE:
                return tag.create();
            default:
                throw new IllegalArgumentException();
        }
    }
}
