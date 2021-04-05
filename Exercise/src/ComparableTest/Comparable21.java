package ComparableTest;

import org.junit.Test;

import java.util.Arrays;

public class Comparable21
{
    @Test
    public void sortTest()
    {
        Good21[] g=new  Good21[4];
        g[0]=new Good21("wu",2  );
        g[1]=new Good21("liu",4  );
        g[2]=new Good21("ma",3  );
        g[3]=new Good21("qi",1  );
        System.out.println(Arrays.toString(g));
        Arrays.sort(g);
        System.out.println(Arrays.toString(g));
    }
}
