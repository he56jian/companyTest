package com.example.myapplication.ConnectSocket;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.example.myapplication.Database.DataApplication;
import com.example.myapplication.BaseMethods.Utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatManager {
    private Socket socket;
    int PORT;
    String IP;
    BufferedReader reader;
    PrintWriter writer;
    DataApplication dataApplication;
    Utils utils;
    private static final ChatManager instance = new ChatManager();
    public static ChatManager getCM() {
        return instance;
    }
    public int clock = 0;
    private ChatManager() {
        dataApplication = DataApplication.getDataApplication();
    }
    DataOutputStream dataOutpuStream;
    OutputStream out_socket;
    //链接服务器
    public void connect(Context context, String ip, int port) {
        this.IP = ip;
        this.PORT = port;
        utils = new Utils(context);
        if (dataApplication.getStaConnect() == 1) {
            Toast.makeText(context, "已经连接上了" + IP + ":" + PORT, Toast.LENGTH_SHORT).show();
        } else if (dataApplication.getStaConnect() == 2) {
            Toast.makeText(context, "正在连接" + IP + ":" + PORT, Toast.LENGTH_SHORT).show();
        }
        if (dataApplication.getStaConnect() == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    try {
                        dataApplication.setStaConnect(2);
                        utils.subHandler.sendEmptyMessage(2);
                        socket = new Socket(IP, PORT);
                        out_socket =  socket.getOutputStream();
                        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        System.out.println("获取输入流：" + reader);
                        System.out.println("获取输出流：" + writer);
                        utils.subHandler.sendEmptyMessage(1);
                        dataApplication.setStaConnect(1);           //链接成功
                    } catch (IOException ex) {
                        dataApplication.setStaConnect(0);           //链接失败
                        utils.subHandler.sendEmptyMessage(0);
//                        if(clock < 2){
//                            clock++;
//                            SystemClock.sleep(2000);
////                            System.out.println("链接IP：" + IP + "链接port:" + PORT + "，链接失败，等待2s后重新连接");
//                            connect(context, IP, PORT);
//                        }else{
//                            utils.isAvailableByPing(ip);
//                       }
//                    }
                    }
                    Looper.loop();
                }
            }).start();
        }
    }
    //往流中输入int
    public void sendIntToStream(int value) {
        if (writer != null) {
            writer.write(value);
        }
    }

    public void sendByteToStream(byte[] out,Boolean send){
        String o = utils.toHexString(out);
        System.out.print(o);
        if(writer !=null){
//            while()
            new Thread(){
                @Override
                public void run() {
                    try {
                        out_socket.write(out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(send){
                        writer.flush();
                    }
                }
            }.start();
        }
    }

    //往流中输入char[]
    public void sendCharToStream(char[] out,Boolean send) {
        if(writer !=null){
            new Thread(){
                @Override
                public void run() {
                    writer.write(out);
                    if(out[2] == 3){
                        dataApplication.setProtected(true);
                    }else if(out[2] == 4){
                        dataApplication.setProtected(false);
                    }
                    if(send){
                        writer.flush();
                    }
                }
            }.start();
        }
    }

    //发送数据
    public void send() {
        if (writer != null) {
//            writer.write(out);
            writer.flush();
            //开头时#03#和#04#时
//            if (out[2] == 0233 || out[2] == 0234) {
//                dataApplication.protecte = !dataApplication.protecte;
//            }
        }
    }

    public BufferedReader getServerMeg() {
        return this.reader;
    }

    public void closeServer() {
        try {
            writer.close();
            socket.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("关闭出现了异常");
        }

    }

}



