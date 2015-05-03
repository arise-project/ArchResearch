/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.Stack;
import javaresearch.domain.SensorData;

/**
 *
 * @author Eugene
 */
public interface CommunicationManagerInterface {
     Stack<SensorData> GetReceived();
}
