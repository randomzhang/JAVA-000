package demo.jvm01;

/**
 * @ClassName: Hello
 * @Description: TODO
 * @author: randomzhang
 * @date: 2020/10/18  19:57
 */
public class Hello {
    private static int[] numbers = {1, 6, 8};

    /**
     0 new #2 <demo/jvm01/MovingAverage>
     3 dup
     4 invokespecial #3 <demo/jvm01/MovingAverage.<init>>
     7 astore_1
     8 iconst_1
     9 istore_2
     10 iconst_2
     11 istore_3
     12 aload_1
     13 iload_2
     14 i2d
     15 invokevirtual #4 <demo/jvm01/MovingAverage.submit>
     18 aload_1
     19 iload_3
     20 i2d
     21 invokevirtual #4 <demo/jvm01/MovingAverage.submit>
     24 getstatic #5 <demo/jvm01/Hello.numbers>
     27 astore 4
     29 aload 4
     31 arraylength
     32 istore 5
     34 iconst_0
     35 istore 6
     37 iload 6
     39 iload 5
     41 if_icmpge 64 (+23)
     44 aload 4
     46 iload 6
     48 iaload
     49 istore 7
     51 aload_1
     52 iload 7
     54 i2d
     55 invokevirtual #4 <demo/jvm01/MovingAverage.submit>
     58 iinc 6 by 1
     61 goto 37 (-24)
     64 aload_1
     65 invokevirtual #6 <demo/jvm01/MovingAverage.getAvg>
     68 dstore 4
     70 return
     * @param args
     */
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        for (int number: numbers){
            ma.submit(number);
        }
        double avg = ma.getAvg();
    }
}
