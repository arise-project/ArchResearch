/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Enumeration;


/**
 *
 * @author Eugene
 */
public class ModbusMaster {
    
    // Our collection of classes that are subscribed as listeners of our
    protected Vector _listeners;
    
    // Method for listener classes to register themselves
    public void addPackageReceivedEventListener(PackageReceivedEventInterface listener)
    {
        if (_listeners == null)
            _listeners = new Vector();
             
        _listeners.addElement(listener);
    }
    
    
    // "fires" the event
    protected void firePackageReceivedEvent(ArrayList<Byte> packageData)
    {
        if (_listeners != null && _listeners.isEmpty())
        {
            Enumeration e = _listeners.elements();
            while (e.hasMoreElements())
            {
                ((PackageReceivedEventInterface)e.nextElement()).PackageReceived(packageData);
            }
        }
    }
    
    public void Init()
    {
        
    }
    
    public void Start()
    {
        
    }
    
    public void Stop()
    {
        
    }
    
    
    public void Send()
    {
        
    }
    
    private void Read()
    {
        
    }    
    
}
