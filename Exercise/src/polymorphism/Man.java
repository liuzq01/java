package polymorphism;

public class Man extends Person
{
    private int age;
    private String name;
    public Man()
    {

    }
    public void walk()
    {
        System.out.println("男人走路");
    }
    public void eat()
    {
        System.out.println("男人吃东西");
    }

}
