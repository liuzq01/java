package exercise2;

import org.junit.Test;

import java.util.Scanner;

public class Exercise6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int i = 10;
        int sum = 0;
        while (i > 0 && i < 1000)
        {
            System.out.println("input: ");
            i = scanner.nextInt();
            if (i > 0 && i < 10)
            {
                sum = i;
                System.out.println("各位数字之和：" + sum);
            }
            if (i >= 10 && i < 100)
            {
                sum = i / 10 + i % 10;
                System.out.println("各位数字之和：" + sum);
            }
            if (i >= 100 && i < 1000)
            {
                sum = i / 100 + (i / 10) % 10 + i % 10;
                System.out.println("各位数字之和：" + sum);
            }
        }
    }
}
