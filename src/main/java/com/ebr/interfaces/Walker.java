/*
 * Interface - When car on, we can accelerate or brake.
 */
package com.ebr.interfaces;

import com.ebr.exceptions.AccelerationCarOffException;
import com.ebr.exceptions.BreakingCarOffException;

/**
 *
 * @author Eduardo
 */
public interface Walker {
    void accelerating() throws AccelerationCarOffException;
    void breaking() throws BreakingCarOffException;
}
