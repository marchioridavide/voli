/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultitask;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ServerMultiTask {
    public static int numeroPosti=160;
    public static List<Passeggero> passeggeri = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          ServerSocket sSocket;
        Socket connessione = null;
        
        int port = 2345; 
        try{
           sSocket = new ServerSocket(port);
           System.out.println("In attesa di connessioni...");
           while (true)
           {
               connessione = sSocket.accept();
               new Thread(connessione);
           }
        }catch(Exception e)
        {}
        
        try{
            connessione.close();
        }
        catch(Exception ex)
        {}
    }
    
}
