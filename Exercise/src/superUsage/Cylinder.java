package superUsage;

import overwrite.Circle;

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
    //返回圆柱的底面积
    public double findBottomArea()
    {
        return super.findArea();
    }
    //返回圆柱的表面积
    @Override
    public double findArea()
    {
        return 2*super.findArea()+ 2* Math.PI*getRadius()*length;
    }
    //返回圆的体积
    public  double findVolume()
    {
        return super.findArea()*length;
    }
}
