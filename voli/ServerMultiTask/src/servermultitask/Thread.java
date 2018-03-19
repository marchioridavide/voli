/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultitask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
/**
 *
 * @author User
 */
public class Thread implements Runnable {
    private Socket connessione = null;
    private InputStreamReader in;
    private BufferedReader sIn;
    private OutputStream out;
    private PrintWriter sOut;
    private BufferedReader fIN;
    String rispostaUt;
    String nome,cognome,nascita;
    int costo=50;
    
     public Thread(Socket conn)
    {
        this.connessione = conn;
        new java.lang.Thread(this).start();
        System.out.println("Il client si è connesso.");
        
     
    }
     
        public void run()
     {
         try{
            out = connessione.getOutputStream(); 
            sOut = new PrintWriter(out);
            in = new InputStreamReader(connessione.getInputStream());
            sIn = new BufferedReader(in);
            loop:
            while(true)
            {
            rispostaUt = sIn.readLine();
            if(rispostaUt.startsWith("add"))
            {
                sOut.println(protocol.add_customer(rispostaUt));
                sOut.flush();
            }
            else if(rispostaUt.startsWith("freeplaces"))
            {
                sOut.println(protocol.freeplaces());
                sOut.flush();
            }
            else if(rispostaUt.startsWith("del"))
            {
                sOut.println(protocol.remove(rispostaUt));
                sOut.flush();
            }
            else if(rispostaUt.startsWith("stop"))
            {
                break;
            }
            else if(rispostaUt.startsWith("get"))
            {
                sOut.println(protocol.getCustomer(rispostaUt));
                sOut.flush();
            }
            else
            {
                sOut.println(rispostaUt + " command does not exists");
                sOut.flush();
            }
            
            }
         }
         catch(Exception e){
             System.err.println(e);
         }
     }
}
