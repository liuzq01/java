package cylinderTest;

public class Cylinder extends Circle
{
    private  double length; //高

    public Cylinder()
    {
        this.length = 1;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }
    //返回圆柱的体积
    public double findVolume()
    {
        return findArea( )*length;
    }
}
