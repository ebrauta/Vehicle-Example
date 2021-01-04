/*
 * Interface - How vehicle works
 */
package com.ebr.interfaces;

import com.ebr.exceptions.RefuellingCarOnException;

/**
 *
 * @author Eduardo
 */
public interface Vehicle {
    void refuel(float liters) throws RefuellingCarOnException;
    void prepare();
}
