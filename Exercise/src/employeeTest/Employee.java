package employeeTest;
//抽象类测试：这是父类
public abstract class Employee
{
    private String name;
    private int number;
    private MyDate birthday;

    public Employee()
    {
    }

    public Employee(String name, int number, MyDate birthday)
    {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public MyDate getBirthday()
    {
        return birthday;
    }

    public abstract double earnings();

    @Override
    public String toString()
    {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() ;
    }
}
