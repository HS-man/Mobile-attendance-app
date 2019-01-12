package com.example.mobile_attendance_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPCilent {
	Socket s = null;
    BufferedReader br;
    PrintWriter pw;
    String ip="10.0.2.2";
    int port=8008;
    Boolean connected=false;
    public TCPCilent(){
        connect();
    }
    public void connect(){
        try {
            s=new Socket(ip,port);
            br=new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
            pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
        } catch (IOException e) {
           e.printStackTrace();
        }
        
   } 
    public void send(String msg) {
        pw.println(msg); //写入网卡输出流，由系统调用底层函数，经网卡发送。
        pw.flush();
    }
    public String receive(){
      String msg;
      try {
         msg = br.readLine();//接收一行信息，阻塞语句。
      } catch (IOException ex) { 
          msg=null; 
      }
      return msg;
   }
    public void close() {
        try {
         if(s!=null)  
            s.close();//实现四次握手断开，如图2.3所示.
         pw.close();
         br.close();
       } catch (IOException ex) { 
    	   }
       }
}
