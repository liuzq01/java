package CollectionTest;

import java.util.Objects;

public class Student extends Person
{
    private String name;
    private int score;
    private int id;

    public Student(String name, int score, int id)
    {
        this.name = name;
        this.score = score;
        this.id = id;
    }
    public int aMehtod()    //重写
    {
        return 0;
    }
    private void aMethod()  //private,不是重写
    {
        //
    }
    public static void aMethod1() //static,不是重写
    {
        //
    }
//    public final void aMethod2()  //报错，final，不能重写
//    {
//        //
//    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, score, id);
    }
}
