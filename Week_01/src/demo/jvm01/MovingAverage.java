package demo.jvm01;

/**
 * @ClassName: Hello
 * @Description: TODO
 * @author: randomzhang
 * @date: 2020/10/18  19:54
 */
public class MovingAverage {
    private int count = 0;
    private double sum = 0.0;

    public void submit(double value){
        this.count++;
        this.sum += value;
    }

    public double getAvg(){
        if(0 == this.count) {
            return sum;
        }
        return this.sum/this.count;
    }
}
