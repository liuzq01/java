package polymorphism;

public class Woman extends Person
{
    private int age;
    private String name;
    public Woman()
    {

    }
    public void walk()
    {
        System.out.println("女人走路");
    }
    public void eat()
    {
        System.out.println("女人吃东西");
    }

}
