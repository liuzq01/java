package exercise3;

import org.junit.Test;

import java.util.Scanner;

public class Exercise27
{
    //0<y<-x/2+100
    //&& 0<x<200
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input x: ");
        double x = scanner.nextDouble();
        System.out.println("input y: ");
        double y = scanner.nextDouble();
        if (0 < y && y < -x / 2 + 100 && 0 < x && x < 200) System.out.println("点(" + x + "," + y + ") 在三角形内");
        else System.out.println("点(" + x + "," + y + ") 不在三角形内");
    }
}
