/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author User
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket connessione = null;
        String server = "localhost";
        int port = 2345;
        InputStreamReader in, input;
        BufferedReader sIN;
        OutputStream out;
        PrintWriter sOUT;
        String msgToSend;
        String received;
        try
        {
          connessione = new Socket(server, port);
        }
        catch(Exception ex)
        {
          System.out.println(ex);
          System.exit(-1);
        }

        try{
            in = new InputStreamReader(connessione.getInputStream());
            sIN = new BufferedReader(in);
            out = connessione.getOutputStream();
            sOUT = new PrintWriter(out);
            input = new InputStreamReader(System.in);
            BufferedReader keyboard = new BufferedReader(input);
            System.out.println("connection established");
            
           while(true){
               
                sOUT.println(keyboard.readLine());
                sOUT.flush();
                received = sIN.readLine();
                System.out.println(received);
           }
        }
        catch(Exception e)
        {
          System.out.println(e);
        }
        
        
        try
        {
          connessione.close();
        }
        catch(Exception close)
        {
          System.out.println(close);
        }
    }
    
}
