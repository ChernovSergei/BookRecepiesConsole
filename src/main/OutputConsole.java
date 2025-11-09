package main;

public class OutputConsole implements Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }

    @Override
    public void print(Object object) {
        System.out.print(object);
    }
}
