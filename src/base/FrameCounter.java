package base;

public class FrameCounter {
    int countMax;
    int count; //current count

    public FrameCounter(int countMax) {
        this.countMax = countMax;
        this.count = 0;
    }

    public boolean run() {
        //true = complete count
        //false = not done yet
        if (count < countMax) {
            count++;
            return false;
        }
        else {
            return true;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
