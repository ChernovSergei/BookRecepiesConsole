package main;

public class ExitCommand extends Command {

    public ExitCommand(Input in, Output out) {
        super(in, out);
    }

    @Override
    public void execute() {
        out.println("Exit implemented.");
    }
}
