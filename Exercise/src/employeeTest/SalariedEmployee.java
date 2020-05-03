package employeeTest;

import javax.naming.Name;
import java.util.Date;
//抽象类测试：子类1
public class SalariedEmployee extends Employee
{
    private double monthlySalary;

    public SalariedEmployee()
    {
    }

    public SalariedEmployee(String name, int number, MyDate birthday)
    {
        super(name, number, birthday);
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary)
    {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary()
    {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings()
    {
        return  monthlySalary;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
