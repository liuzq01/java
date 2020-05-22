package TcpTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpTest2
{
    //exercise2:客户端发送文本给服务器，服务端将文本转换为大写后发送给客户端（未完成）
    //getOutputStream(),getInputStream(),没有字符流，如何传输文本？
    @Test
    public void client() throws IOException
    {
        String str = "D:\\a新建文件夹\\Java学习笔记\\file\\lowerCase.txt";
        FileInputStream fileInputStream = new FileInputStream(str); //相当于复制文件，可以用字节流？
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8090);
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[16];
        int read = fileInputStream.read(bytes);
        while (read != -1)
        {
            outputStream.write(bytes,0,read);
            read = fileInputStream.read(bytes);
        }
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String str1 = "D:\\a新建文件夹\\Java学习笔记\\file\\upCase_client.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(str1);
        byte[] bytes1 = new byte[10];
        int read1 = inputStream.read(bytes1);
        while (read1 != -1)
        {
            fileOutputStream.write(bytes1,0,read1);
            read1 = inputStream.read(bytes1);
        }
        fileOutputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        fileInputStream.close();
    }
    @Test
    public void server() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(8090);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream); //转换流
        String str = "D:\\a新建文件夹\\Java学习笔记\\file\\upCase_server.txt";
        FileWriter fileWriter = new FileWriter(str);
        char[] chars = new char[16];
        int read = inputStreamReader.read(chars);
        while (read != -1)
        {
            String s =String.valueOf(chars);
            String s1 = s.toUpperCase();
            char[] chars1 = s1.toCharArray();
            fileWriter.write(chars1,0,read);
            read = inputStreamReader.read(chars);
        }

        FileInputStream fileInputStream = new FileInputStream(str);
        OutputStream outputStream = accept.getOutputStream();
        byte[] bytes = new byte[16];
        int read1 = fileInputStream.read(bytes);
        while (read1!=-1)
        {
            outputStream.write(bytes,0,read);
            read1 = fileInputStream.read(bytes);
        }
        outputStream.close();
        fileInputStream.close();
        inputStreamReader.close();
        serverSocket.close();
    }
}
