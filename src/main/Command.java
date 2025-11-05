package main;

public abstract class Command {
    Input in;
    Output out;

    public Command(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    public abstract void execute();
}
