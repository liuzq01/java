package ExceptionTest;
//自定义异常
public class EcdefException extends Exception
{
    private static final long serialVersionUID = -5116101135115950844L;
    public EcdefException()
    {
        super();
    }
    public EcdefException(String s)
    {
        super(s);
    }

}
