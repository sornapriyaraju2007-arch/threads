import java.util.Random;
class NumberGenerator extends Thread {
    public void run() {
        Random rand = new Random();
        int num = rand.nextInt(20) + 1; 
        System.out.println("Generated Number: " + num);

        if (num % 2 == 0) {
            new SquareThread(num).start(); 
        } else {
            new CubeThread(num).start();   
        }
    }
}


class SquareThread extends Thread {
    int num;
    SquareThread(int num) { this.num = num; }

    public void run() {
        System.out.println("Even -> Square of " + num + " = " + (num * num));
    }
}


class CubeThread extends Thread {
    int num;
    CubeThread(int num) { this.num = num; }

    public void run() {
        System.out.println("Odd -> Cube of " + num + " = " + (num * num * num));
    }
}
public class Mainnumber {
    public static void main(String[] args) {
        NumberGenerator gen = new NumberGenerator();
        gen.start(); 
    }