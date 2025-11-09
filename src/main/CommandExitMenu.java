package main;

public class CommandExitMenu extends Command {

    public CommandExitMenu(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        out.println("Exit implemented.");
    }
}
