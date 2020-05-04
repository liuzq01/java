package ExceptionTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EcmDef
{
    private static double a;
    private static double b;

    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);

        try
        {
            System.out.println("input a:");
            a= scanner.nextInt();
            System.out.println("input b:");
            b=scanner.nextInt();
            EcmDef ecmDef=new EcmDef();
            double  res = ecmDef.devidedFunction(a, b);
            System.out.println("a/b = "+res);
        }
        catch (InputMismatchException e)
        {
            System.out.println("输入的不是数");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch (ArithmeticException e)
        {
            System.out.println("分母不能为0");
        }
        catch (EcdefException e)
        {
            System.out.println(e.getMessage());
        }
    }
    //两数相除的方法
    public double devidedFunction(double a,double b) throws EcdefException
    {
        if (a < 0 || b < 0)
        {
            throw new EcdefException("不能为负"); //自定义异常
        }
        return a/b;
    }
}
