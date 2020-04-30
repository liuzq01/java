package polymorphism1;

public class GeometricTest
{
    public static void main(String[] args)
    {
        GeometricObject circle= new Circle("red",1.2,2.0);
        GeometricObject rectangle= new MyRectangle("orange",1.6,3,4);
        equalsArea(circle,rectangle);
        System.out.println("circle面积: "+displayGeometricObject(circle));
        System.out.println("circle面积: "+displayGeometricObject(rectangle));

    }
    public static void equalsArea(GeometricObject g1,GeometricObject g2)
    {
        if(g1.findArea()==g2.findArea())
        {
            System.out.println("面积相等");
        }
        else System.out.println("不相等");
    }
    public static double displayGeometricObject(GeometricObject g)
    {
        return g.findArea();
    }

}

