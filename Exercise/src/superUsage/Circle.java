package superUsage;

public class Circle
{
    private double radius;  //半径
    public Circle()
    {
        radius=1;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    //返回圆的面积
    public double findArea()
    {
        return 3.14*radius*radius;
    }
}
