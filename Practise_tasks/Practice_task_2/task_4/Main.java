package task_4;

public class Main {
    public static void main(String[] args) {
        Sleepyc sleepyc = new SleepyImpl();

        sleepyc.sleep();
        sleepyc.ask();

        sleepyc.wakeUp();
        sleepyc.ask();
    }
}
