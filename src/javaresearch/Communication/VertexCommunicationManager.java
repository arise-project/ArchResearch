/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import javaresearch.domain.Humidity;
import javaresearch.domain.SensorData;
import javaresearch.domain.Temperature;

/**
 *
 * @author Eugene
 */
public class VertexCommunicationManager implements PackageReceivedEventInterface, CommunicationManagerInterface {
    
    protected ModbusMaster _master;
    protected ValueCalculator _calculator;
    public Stack<SensorData> _received;
    
    public VertexCommunicationManager()
    {
        _calculator = new ValueCalculator();
        _master = new ModbusMaster();
        _master.Init(2, this);
    }
    
    @Override
    public void PackageReceived(ArrayList<Byte> packageData)
    {
        if(_received == null)
            _received = new Stack<>();
        
        Date currentDate = new Date();
        final Humidity h = new Humidity();
        h.value = packageData.get(2);
        h.Received = currentDate;
        
        final Temperature t = new Temperature();
        t.value = packageData.get(3);
        t.Received = currentDate;
                
        _received.add(new SensorData(){{
            humidity = h;
            temperature = t;
        }});
    }
    
    public Stack<SensorData> GetReceived()
    {
        return _received;
    }
}
