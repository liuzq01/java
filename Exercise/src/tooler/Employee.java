package tooler;

import java.util.Date;

public class Employee
{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee()
    {
        name="l";
        salary=0;
        hireDay=null;
    }
    public Employee(String aName,Double aSalary,Date aDay)
    {
        name=aName;
        salary=aSalary;
        hireDay=aDay;
    }

    public void raiseSalary(double percent)
    {
        salary=salary*(1+percent*0.01);
    }
    public String getName()
    {
        return name;
    }
    public double getSalary()
    {
        return salary;
    }
    public Date getHireDay()
    {
        return hireDay;
    }
}
