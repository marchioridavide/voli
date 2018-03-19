/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultitask;

import java.util.List;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author notebook
 */
public class protocol {
    public static int add_customer(String command)
    {
        StringTokenizer st = new StringTokenizer(command);
        st.nextToken();
        while(st.hasMoreTokens())
        {
            String name = st.nextToken();
            String surname = st.nextToken();
            String date = st.nextToken();
            System.out.println(date);
            if (isValidDate(date))
            {
                try{
                    ServerMultiTask.passeggeri.add(new Passeggero(name, surname, date, st.nextToken()));
                }
                catch(Exception e)
                {
                    return -2;
                }
            }
            else{
                return -1;
            }
        }
        return 1;
    }
    
    public static int freeplaces()
    {
        return ServerMultiTask.numeroPosti - ServerMultiTask.passeggeri.size();
    }
    
    public static int remove(String args)
    {
        StringTokenizer st = new StringTokenizer(args);
        System.out.println(st.nextToken());
        while (st.hasMoreTokens())
        {
            String ID = st.nextToken();
            System.out.println(ID);
            
            for (int p = 0; p < ServerMultiTask.passeggeri.size(); p++)
            {
               if (ServerMultiTask.passeggeri.get(p).getID().equals(ID)) ServerMultiTask.passeggeri.remove(p);
            }
        }
        return 1;
    }
    
    public static String getCustomer(String args)
    {
        StringTokenizer st = new StringTokenizer(args);
        System.out.println(st.nextToken());
        String result = "cannot find customer";
        
        String ID = st.nextToken();
        System.out.println(ID);
            
        for (int p = 0; p < ServerMultiTask.passeggeri.size(); p++)
        {
           if (ServerMultiTask.passeggeri.get(p).getID().equals(ID)) result = (ServerMultiTask.passeggeri.get(p).getID() + " " + ServerMultiTask.passeggeri.get(p).getName() + " " + ServerMultiTask.passeggeri.get(p).getSur() + " " + ServerMultiTask.passeggeri.get(p).getDate());
        }
        
        return result;
    }
    
    
    public static boolean isValidDate(String inDate) 
    {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
}
