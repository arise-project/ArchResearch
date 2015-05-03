/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import javaresearch.domain.Humidity;
import javaresearch.domain.RawFreeRtosData;
import javaresearch.domain.SensorData;
import javaresearch.domain.Temperature;

/**
 *
 * @author Eugene
 */
public class ValueCalculator {
    public SensorData Calculate(RawFreeRtosData data)
    {
        SensorData result = new SensorData();
        result.humidity = new Humidity();
        result.humidity.value = 15; //todo : how to retrieve?
        result.humidity.Received = data.Received;
        result.temperature = new Temperature();
        result.temperature.value = 30; //todo : how to retrieve?
        result.temperature.Received = data.Received;
        return result;
    }
}
