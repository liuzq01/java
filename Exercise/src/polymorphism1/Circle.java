package polymorphism1;

import com.sun.tools.javac.Main;

public class Circle extends GeometricObject
{
    private double radius;

    public Circle()
    {
        radius=1;
    }

    public Circle(String color, double weight, double radius)
    {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    @Override
    public double findArea()
    {
        return Math.PI*radius*radius;
    }
}
