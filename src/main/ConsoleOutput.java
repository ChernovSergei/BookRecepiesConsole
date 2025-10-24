package main;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}
