package polymorphism;

import java.security.PublicKey;

public class Test
{
    public static void main(String[] args)
    {
        Person man=new Man();
        fun(man);
        Person w=new Woman();
        System.out.println("**************");
        fun(w);

    }
    public static void fun(Person p)
    {
        p.walk();
        p.eat();
    }

}
