package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;

public class ChatClient{
Socket socket;
String address;
int port;
String username;
DataOutputStream out;
DataInputStream in;


ChatClient(String address, int port, String username){
    this.address = address;
    this.port = port;
    this.username = username;
    }

 void connect(){
    try{
socket = new Socket(address, port);

 in = new DataInputStream(socket.getInputStream());
 out = new DataOutputStream(socket.getOutputStream());
System.out.println(username + " connected to server");
    }
    catch(IOException e){
        System.out.println("Connection error "+ e.getMessage());
    } }

    void sendMessage(String message){
 try{
 out.writeUTF(message);
 out.flush();
    }
    catch(IOException e){
        System.out.println("Send error"+ e.getMessage());
    } }

  void receiveMessage(){
try{
    String response = in.readUTF();
    System.out.println("server: "+ response);
}
catch(IOException e){
    System.out.println("Recieve error: "+ e.getMessage());
}
    } 

void close(){
    try{
    in.close();
    out.close();
    socket.close();
     System.out.println("conncetion closed");
    }catch(IOException e){
    System.out.println("close error: "+ e.getMessage());
} }


public static void main(String[] args){
ChatClient client = new ChatClient("localhost", 5000, "shega");
client.connect();

}



}
