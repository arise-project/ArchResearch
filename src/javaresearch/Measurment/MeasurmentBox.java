/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Measurment;

import javaresearch.Sensors.SensorNode;

/**
 *
 * @author Eugene
 */
public class MeasurmentBox {

  public String Name;

  public Integer Humidity;

  public Integer Temperature;

  public Integer TemperatureErrorType;

  public Integer HumidityErrorType;

  public Boolean HasHumidityError;

  public Boolean HasTemperatureError;

  public Integer PositionRow;

  public Integer PositionColumn;

  public Boolean Active;

  public Integer Enabled;

  public SensorNode SensorNode;

  public void GetHumidityMessage() {
  }

  public void GtTemperatureMessage() {
  }

}
