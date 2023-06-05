package commandandtag;

public enum Command {
    CREATE("create"), EXECUTE("execute");

    Command(String commandName) {
        this.commandName = commandName;
    }
    private final String commandName;
    public static Command from(String input){
        for(Command command : Command.values()){
            if(command.commandName.equals(input)){
                return command;
            }
        }
        throw new IllegalArgumentException("올바른 명령어를 입력하세요.");
    }
}
