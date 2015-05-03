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
public class ResponseTask  extends TimerTask {
    protected ModbusMaster _master;
    public ResponseTask(ModbusMaster master)
    {
        _master = master;        
    }
    
    public void run() {
       if(_master._currentAddr != 0 && _master._currentCommand != 0)
       {
           ArrayList<Byte> response = _master.Read();           
           
           if(response != null && response.size() > 0)
           {
               _master.firePackageReceivedEvent(response);
           }
       }
    }
}
