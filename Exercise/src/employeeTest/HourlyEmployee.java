package employeeTest;

//抽象类测试：子类2
public class HourlyEmployee extends Employee
{
private double wage;
private double hour;

    public HourlyEmployee(String name, int number, MyDate birthday)
    {
        super(name, number, birthday);
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour)
    {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public double getWage()
    {
        return wage;
    }

    public void setWage(double wage)
    {
        this.wage = wage;
    }

    public double getHour()
    {
        return hour;
    }

    public void setHour(double hour)
    {
        this.hour = hour;
    }

    @Override
    public double earnings()
    {
        return wage*hour;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
