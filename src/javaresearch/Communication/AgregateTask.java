/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.Stack;
import java.util.TimerTask;
import javaresearch.domain.SensorData;

/**
 *
 * @author Eugene
 */
public class AgregateTask  extends TimerTask{
    protected DataAgregator _agregator;
    
    public AgregateTask(DataAgregator agregator)
    {
        _agregator = agregator;
    }
    
    @Override
    public void run() {
        for (CommunicationManagerInterface _manager : _agregator._managers) {
            Stack<SensorData> received = _manager.GetReceived();
            while(!received.empty())
            {
                _agregator._data.add(received.pop());
            }
        }
        
        _agregator.Save();
    }
}
