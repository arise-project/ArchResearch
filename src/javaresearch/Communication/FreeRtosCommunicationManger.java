/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import javaresearch.domain.RawFreeRtosData;
import javaresearch.domain.SensorData;

/**
 *
 * @author Eugene
 */
public class FreeRtosCommunicationManger implements PackageReceivedEventInterface, CommunicationManagerInterface {
    
    protected ModbusMaster _master;
    protected ValueCalculator _calculator;
    public Stack<SensorData> _received;
    
    public FreeRtosCommunicationManger()
    {
        _calculator = new ValueCalculator();
        _master = new ModbusMaster();
        _master.Init(1, this);
    }
    
    @Override
    public void PackageReceived(ArrayList<Byte> packageData)
    {
        if(_received == null)
            _received = new Stack<>();
        
        RawFreeRtosData data = new RawFreeRtosData(){{
            Data = new ArrayList<>();
            Received = new Date();
        }};
        
        for(int i = 2; i < packageData.size() - 2; i++)
        {
            data.Data.add(packageData.get(i));
        }
        
        _received.add(_calculator.Calculate(data));
    }
    
    public Stack<SensorData> GetReceived()
    {
        return _received;
    }
}
