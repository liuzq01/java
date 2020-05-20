package IOtest;

import java.io.File;

public class Dir implements Comparable
{
private File file;
private int level;

    public Dir(File file, int level)
    {
        this.file = file;
        this.level = level;
    }

    public File getFile()
    {
        return file;
    }

    public int getLevel()
    {
        return level;
    }

    @Override
    public String toString()
    {
        return file + ": " + level+'\n';
    }

    //按照level倒序排
    @Override
    public int compareTo(Object o)
    {
        if (o instanceof Dir)
        {
            Dir o1 = (Dir) o;
            return -Integer.compare(this.level,o1.level);
        }
        throw new RuntimeException("数据不对");
    }
}
