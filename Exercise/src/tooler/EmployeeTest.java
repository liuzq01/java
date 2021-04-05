package tooler;

import java.util.Arrays;
import java.util.Date;

public class EmployeeTest
{
    public static void main(String[] args)
    {
        Employee[] employees = new Employee[3];
        employees[0]=new Employee("liu",100.0,new Date());
        employees[1]=new Employee("li",200.0,new Date());
        employees[2]=new Employee("lin",300.0,new Date());
        for(Employee employee:employees)
        {
            employee.raiseSalary(5);
            System.out.println("name: "+employee.getName()+
                    ",salary: "+employee.getSalary()+
                    ",hireDay: "+employee.getHireDay());
        }
    }
}
