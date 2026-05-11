package server;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class ChatServer {
   ServerSocket serverSocket;
    int port = 5000;

   ChatServer(int port){
    this.port = port;
   }

void start(){
    try{
  serverSocket = new ServerSocket(port);
  System.out.println("server started" + port);
while(true){
    Socket socket = serverSocket.accept();
    System.out.println("client connected");
} } catch(IOException e){
    System.out.println("server error "+ e.getMessage());
}

}


public static void main(String[] args){
    ChatServer server = new ChatServer(5000);
    server.start();
}

}
