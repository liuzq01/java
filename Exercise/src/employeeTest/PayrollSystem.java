package employeeTest;

import java.util.Scanner;

public class PayrollSystem
{
    //抽象类测试
    public static void main(String[] args)
    {

        Employee[] employees=new Employee[2];
        employees[0]=new SalariedEmployee("ksl",11,new MyDate(1992,1,4),10000);
        employees[1]=new HourlyEmployee("pkd",33,new MyDate(1990,5,4),40,8);
        Scanner scanner=new Scanner(System.in);
        System.out.println("input current month:");
        int month=scanner.nextInt();
        for (int i = 0; i < employees.length; i++)
        {
            double salary;
            System.out.println(employees[i].toString());
            if(employees[i].getBirthday().getMonth() == month)
            {
                salary=employees[i].earnings()+100;
            }
            else salary=employees[i].earnings();
            System.out.println("Salary:"+salary);

        }

    }

}
