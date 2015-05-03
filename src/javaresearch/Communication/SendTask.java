/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Eugene
 */
public class SendTask extends TimerTask  {
    protected ModbusMaster _master;
    public SendTask(ModbusMaster master)
    {
        _master = master;        
    }
    
    public void run() {
       ArrayList<Byte> bytes = _master._sendBuffer.pop();
       if(bytes != null && bytes.size() > 0)
       {
           _master.SendInternal(bytes);
           System.out.println("Send bytes");        
       }       
    }

}
