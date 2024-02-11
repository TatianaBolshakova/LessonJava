package Lesson5;


public abstract class Animal {
    private final String name;
    private final int maxRun;
    private final double maxJump;
    private final int maxSwim;


    public Animal(String name, int maxRun, double maxJump, int maxSwim) {

        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.maxSwim = maxSwim;
    }

    protected boolean run(int magnitude) {
        return  magnitude<=maxRun;
    }

    protected boolean swim(int magnitude) {
        return magnitude<=maxSwim;
    }

    protected boolean jump(double magnitude) {
        return magnitude<=maxJump;
    }


    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public int getMaxSwim() {
        return maxSwim;
    }
}
