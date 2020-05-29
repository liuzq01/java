package exercise2;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Chapter10
{
    //exercise 10.7
    public static void main(String[] args)
    {
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++)
        {
            accounts[i] = new Account(i, 100);
        }
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true)
        {
            System.out.println("input ID: ");
            i = scanner.nextInt();
            if (i < 0 || i > 9)
            {
                System.out.println("输入正确的ID（0~9）：");
                continue;
            }
            int menu = 0;
            while (true)
            {
                System.out.println("Main Menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.println("Enter a choice: ");
                menu = scanner.nextInt();
                if (menu < 1 || menu > 4)
                {
                    System.out.println("选择有误，重新输入");
                    continue;
                }
                if (menu == 1)
                {
                    System.out.println("当前账号ID： " + i + " ，余额为：" + accounts[i].getBalance());
                    continue;
                }
                if (menu == 2)
                {
                    System.out.println("取钱，输入金额：");
                    double money = scanner.nextDouble();
                    accounts[i].withDraw(money);
                    System.out.println("当前账号ID： " + i + " ，余额为：" + accounts[i].getBalance());
                    continue;
                }
                if (menu == 3)
                {
                    System.out.println("存钱，输入金额：");
                    double money = scanner.nextDouble();
                    accounts[i].deposit(money);
                    System.out.println("当前账号ID： " + i + " ，余额为：" + accounts[i].getBalance());
                    continue;
                }
                if (menu == 4) break;
            }
        }
    }

}
