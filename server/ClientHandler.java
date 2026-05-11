package server;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClientHandler {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String username;

ClientHandler(Socket socket){
this.socket = socket;
try{
in= new DataInputStream(socket.getInputStream());
out = new DataOutputStream(socket.getOutputStream());
}catch(IOException e){
    System.out.println("Stream error: "+ e.getMessage());
    }

}

void receive(){
try{
String message = in.readUTF();
System.out.println("client"+ message);
} catch(IOException e){
    System.out.println("Recieve error: "+ e.getMessage());
} }

void send(String message){
    try{
out.writeUTF(message);
out.flush();
} catch(IOException e){
    System.out.println("Send error: " + e.getMessage());
}}

void close(){
    try{
    in.close();
    out.close();
    socket.close();
    }
    catch(IOException e){
        System.out.println("close error: " +e.getMessage());
    }
}


}
