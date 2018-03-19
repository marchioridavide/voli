/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultitask;

import java.io.*;

/**
 *
 * @author User
 */
public class Passeggero {
    String Nome,Cognome,DataNascita,DocID;
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);
    OutputStream os = System.out;
    PrintWriter pw = new PrintWriter(os);
    public Passeggero(String n,String c,String dn, String DocID){
        this.Nome = n;
        this.Cognome = c;
        this.DataNascita  = dn;
        this.DocID = DocID;
    }
    
    public String getID()
    {
        return this.DocID;
    }
    
    public String getName()
    {
        return this.Nome;
    }
    
    public String getSur()
    {
        return this.Cognome;
    }
    
    public String getDate()
    {
        return this.DataNascita;
    }
}
