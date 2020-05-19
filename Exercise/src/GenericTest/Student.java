package GenericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student<T>
{
    private String name;
    private int age;
    private T id;

    public Student()
    {
    }

    public Student(String name, int age, T id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void setId(T id)
    {
        this.id = id;
    }
    //静态方法中不能用带泛型的属性
//    public static void show()
//    {
//        System.out.println(id);
//    }

    //泛型方法，这里是E，跟T没关系
    public <E> List<E> copyArraytoList(E[] array)
    {
        ArrayList<E> list=new ArrayList<>();
        for(E e:array)
        {
            list.add(e);
        }
        return list;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student<?> student = (Student<?>) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(id, student.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age, id);
    }
}
