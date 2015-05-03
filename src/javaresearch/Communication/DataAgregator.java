/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;
import java.util.Timer;
import javaresearch.domain.SensorData;

/**
 *
 * @author Eugene
 */
public class DataAgregator {
    
    protected Timer _agregateTimer;
    protected ArrayList<CommunicationManagerInterface> _managers;
    public ArrayList<SensorData> _data;
    
    public DataAgregator()
    {
        _data = new ArrayList<>();
        _agregateTimer = new Timer();        
        _managers = new ArrayList<>();
        _agregateTimer.schedule(new AgregateTask(this), 0, 400);
    }
    
    
    public void Attach(CommunicationManagerInterface manager)
    {
        _managers.add(manager);
    }
        
    public void Detach(CommunicationManagerInterface manager)
    {
        _managers.remove(manager);
    }
    
    public void Finish()
    {
        _agregateTimer.cancel();
    }
    
    public void Save()
    {
        //todo: implement save to db
    }       
}
