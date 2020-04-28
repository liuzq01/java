package superUsage;

import overwrite.Cylinder;

public class CylinderTest
{
    public static void main(String[] args)
    {
        Cylinder cy=new Cylinder();
        cy.setRadius(2.1);
        cy.setLength(3.4);
        double volume=cy.findVolume();
        System.out.println("圆柱的体积为："+volume);

        double area=cy.findArea();
        System.out.println("圆柱的表面积为："+area);
        double barea=cy.findBottomArea();
        System.out.println("圆柱的底面积为："+barea);
        System.out.println("********************");
        Cylinder cy1=new Cylinder();
        System.out.println("圆柱的底面积为："+cy1.findVolume());
    }
}
