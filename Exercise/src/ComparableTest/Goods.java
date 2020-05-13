package ComparableTest;

import java.util.Comparator;

public class Goods implements Comparable
{
    private String name;
    private double price;

    public Goods()
    {
    }

    public Goods(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public int compareTo(Object o)
    {
        if (o instanceof Goods)
        {
            Goods goods = (Goods) o;
            if (this.price < goods.price) return -1;
            if (this.price == goods.price) return 0;
            if (this.price > goods.price) return 1;

            //或者   return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("输入数据有误");
    }

    @Override
    public String toString()
    {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
