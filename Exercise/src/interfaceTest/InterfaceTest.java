package interfaceTest;

public class InterfaceTest
{
    public static void main(String[] args)
    {
        System.out.println(Flyable.maxSpeed);
    }
}
interface Flyable{
    public static final int maxSpeed=3333;
    int minSpeed=33; //省略了public static final
    public abstract void fly();
    void walk(); //省略了public abstract

    //静态方法
   public static void step()
    {
        System.out.println("bu");
    }
}
interface Boat{
    double size=89;
    double weight();
}
class trans implements Flyable,Boat{

    @Override
    public void fly()
    {

    }

    @Override
    public void walk()
    {

    }


    @Override
    public double weight()
    {
        return 0;
    }
}