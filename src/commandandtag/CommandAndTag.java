package commandandtag;

import commandandnumber.CommandAndNumber;

public class CommandAndTag {
    private final Command command;
    private final Tag tag;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }

    public void executeCommand() {
        switch (command) {
            case EXECUTE:
                tag.execute();
                break;
            case CREATE:
                tag.create();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
