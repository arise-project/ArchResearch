/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresearch.Communication;

import java.util.ArrayList;

/**
 *
 * @author Eugene
 */
public interface PackageReceivedEventInterface {
    void PackageReceived(ArrayList<Byte> packageData);
}
