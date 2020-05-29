package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chapter12
{
    public static void main(String[] args)
    {
        //exercise 12.2
        Scanner scanner = new Scanner(System.in);
        int a=0;
        int b=0;
        boolean flag=true;
        while (flag)
        {
            try
            {
                System.out.println("input a: ");
                a = scanner.nextInt();
                System.out.println("input b: ");
                b= scanner.nextInt();
                System.out.println("和："+(a+b));
                flag=false;
            } catch ( InputMismatchException e)
            {
                e.printStackTrace();
                scanner.nextLine();     //换行
            }
        }
    }
}
