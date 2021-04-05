package ComparableTest;

import java.util.Objects;

public class Good21 implements Comparable
{
    String name;
    double price;
    public Good21()
    {

    }
    public Good21(String name,double price)
    {
        this.name=name;
        this.price=price;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }


    @Override
    public int compareTo(Object o)
    {
        if (o instanceof Good21)
        {
         Good21 good21= (Good21) o;
         return Double.compare(this.price,good21.price);
        }
        throw new RuntimeException("数据有误");
    }

    @Override
    public String toString()
    {
        return "Good21{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good21 good21 = (Good21) o;
        return Double.compare(good21.price, price) == 0 &&
                Objects.equals(name, good21.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, price);
    }
}
