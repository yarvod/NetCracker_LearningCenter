package task_4;

public class SleepyImpl implements Sleepyc {
    boolean awake;

    @Override
    public void sleep() {
        this.awake = false;
    }

    @Override
    public void wakeUp() {
        this.awake = true;
    }

    @Override
    public void ask() {
        if (this.awake == true) {
            System.out.println("BOO!");
        } else {
            System.out.println("zzz...");
        }
    }
}
