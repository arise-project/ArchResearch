/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;


/**
 *
 * @author Eugene
 */
public class ModbusMaster {
        
    // Our collection of classes that are subscribed as listeners of our
    protected Vector _listeners;
    public Stack<ArrayList<Byte>> _sendBuffer;    
    protected Timer _sendTimer;
    protected Timer _responseTimer;
    public Map<Byte, ArrayList<Byte>> _responsesMock; //todo: this mock responses should be removed after implement modbus
    
    public byte _currentAddr; //todo: mock
    public byte _currentCommand; //todo: mock
    protected int _postNumber;
    
    public ModbusMaster()
    {
        
       _responsesMock = new HashMap<>();
       _responsesMock.put((byte)1,  new ArrayList<Byte>(){{
           add((byte)1);           
           add((byte)2);
           add((byte)3);
           add((byte)4);
           add((byte)5);
       }});       
       
       _responsesMock.put((byte)2,  new ArrayList<Byte>(){{
           add((byte)2);           
           add((byte)1);
           add((byte)2);
           add((byte)3);
           add((byte)4);
       }});
    }
    
    // Method for listener classes to register themselves
    public void addPackageReceivedEventListener(PackageReceivedEventInterface listener)
    {
        if (_listeners == null)
            _listeners = new Vector();
             
        _listeners.addElement(listener);
    }
    
    
    // "fires" the event
    public void firePackageReceivedEvent(ArrayList<Byte> packageData)
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
    
    public void Init(int postNumber, PackageReceivedEventInterface listener)
    {
        InitPort(postNumber);
        addPackageReceivedEventListener(listener);
    }
    
    private void InitPort(int postNumber)
    {
        //todo: implement
        _postNumber = postNumber;
    }
    
    public void Start()
    {
         _sendTimer = new Timer();
        _responseTimer = new Timer();
        
        _sendTimer.schedule(new SendTask(this), 0, 400);
        _responseTimer.schedule(new ResponseTask(this), 0, 200);
    }
    
    public void Stop()
    {
        _sendTimer.cancel();
        _responseTimer.cancel();
    }
    
    
    public void Send(ArrayList<Byte> packageData)
    {
        if(_sendBuffer == null)
            _sendBuffer = new Stack<ArrayList<Byte>>();
        _sendBuffer.add(packageData);
    }   
    
    public ArrayList<Byte> Read()
    {
        //todo : read resonse there
        ArrayList<Byte> response = _responsesMock.get(_currentAddr);
        _currentAddr = 0;
        _currentCommand = 0;
        return response;
    }   
    
    
    public void SendInternal(ArrayList<Byte> bytes)
    {
        //todo: send request there
        _currentAddr = bytes.get(0);
        _currentCommand = bytes.get(1);
    }
            
}
