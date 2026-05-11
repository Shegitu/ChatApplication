package server;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectionManager {
   
ArrayList<ClientHandler> clients = new ArrayList<>();


public void  add(ClientHandler client){

clients.add(client);
System.out.println("client added successfully");
}


public void broadcast(String message){
    if(clients.isEmpty()){
        System.out.println("no clinets available");
    }
    for(ClientHandler client:clients){
        client.send(message);
            }
}

public void remove(ClientHandler client){
    clients.remove(client);
        System.out.println("client removed");
}



}
