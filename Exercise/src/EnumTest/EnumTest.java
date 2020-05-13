package EnumTest;

public class EnumTest
{
    public static void main(String[] args)
    {
        System.out.println(Season.SPRING);

        System.out.println("*******");

        Season[] values = Season.values();
        for (Season v : values)
        {
            System.out.println(v);
        }

        System.out.println("*******");

        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer);
    }
}
