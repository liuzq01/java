package exercise2;

import org.junit.Test;

import java.util.Scanner;

public class Exercise13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input month: ");
        int i = scanner.nextInt();
        deposit(0, i);
    }

    static double ss = 0;

    public static void deposit(double s, int i)
    {
        ss = (s + 100) * (1 + 0.05 / 12);
        i--;
        if (i != 0) deposit(ss, i);         //递归调用需要有终止条件
        if (i == 0) System.out.println(ss);   //有条件的return不算最终的返回值，所以方法必须是void的
    }
}
