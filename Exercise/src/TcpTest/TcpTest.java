package TcpTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpTest
{
    //exercise1:服务器端读取图片发送给客户端，客户端保存到本地
    @Test
    public void serverTest() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        OutputStream outputStream = accept.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream("D:\\a新建文件夹\\Java学习笔记\\file\\exercise.jpg");
        byte[] bytes=new byte[16];
        int read = fileInputStream.read(bytes);
        while (read!=-1)
        {
            outputStream.write(bytes,0,read);
            read = fileInputStream.read(bytes);
        }
        fileInputStream.close();
        outputStream.close();
        serverSocket.close();
    }
    @Test
    public void clientTest() throws IOException
    {
        InetAddress localHost = InetAddress.getLocalHost();
        Socket socket = new Socket(localHost, 8080);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\a新建文件夹\\Java学习笔记\\file\\TcpTest1.jpg");
        byte[] bytes = new byte[16];
        int read = inputStream.read(bytes);
        while (read!=-1)
        {
            fileOutputStream.write(bytes,0,read);
            read = inputStream.read(bytes);
        }
        fileOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
