package main;

public abstract class Command {
    Input in;
    Output out;
    Recipe recipe;

    public Command(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    public Command(Input in, Output out, Recipe recipe) {
        this.in = in;
        this.out = out;
        this.recipe = recipe;
    }

    public abstract void execute();
}
