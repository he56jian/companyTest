package com.uovision.mysocketserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    int line;
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader bufferedReader;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.start);
        Button end = findViewById(R.id.end);
        textView = findViewById(R.id.message);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            System.out.println("跳到了这里");
                            serverSocket = new ServerSocket(5001);
                            subHandler.sendEmptyMessage(2);
                            socket = serverSocket.accept();          //连接成功了获取socket对象
                            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取输入流
                            subHandler.sendEmptyMessage(1);

                            while (true){
                                System.out.println( "收到的消息："+ line);
                                textView.setText(bufferedReader.read());
                            }
//                            bufferedReader.close();
                        } catch (Exception e) {
                            subHandler.sendEmptyMessage(0);
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            subHandler.sendEmptyMessage(3);
                            serverSocket.close();
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }.start();
            }
        });

    }

    public Handler subHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(MainActivity.this, "连接失败", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(MainActivity.this, "开启成功", Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}
