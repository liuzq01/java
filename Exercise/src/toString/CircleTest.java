package toString;

public class CircleTest
{
    public static void main(String[] args)
    {
        Circle c1=new Circle("black",1,2.3);
        Circle c2=new Circle("black",1,3.5);
        Circle c3=new Circle("red",1,3.5);
        System.out.println("颜色是否相等 "+c1.getColor().equals(c2.getColor()));
        System.out.println("颜色是否相等 "+c3.getColor().equals(c2.getColor()));
        System.out.println("半径是否相等： "+c1.equals(c2));
        System.out.println("半径是否相等： "+c3.equals(c2));
        System.out.println("c2的半径是 "+c2.toString());
        System.out.println("c3的半径是 "+c3);
    }
}
