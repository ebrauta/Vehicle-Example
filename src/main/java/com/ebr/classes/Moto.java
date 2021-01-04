/*
 * Vehicle MOTORCYCLE
 */
package com.ebr.classes;

import com.ebr.exceptions.AccelerationCarOffException;
import com.ebr.exceptions.BreakingCarOffException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public final class Moto extends BaseVehicle{
    public Moto(){
        this.numOfWheels = 2;
        this.setVehicleType("Motocicleta");
    }
    public Moto(String name, String brand, String color, int year){
        this.numOfWheels = 2;
        this.setVehicleType("Motocicleta");
        this.setName(name);
        this.setBrand(brand);
        this.setColor(color);
        this.setYearModel(year);
    }
    @Override
    public void accelerating() throws AccelerationCarOffException{
        if(this.isOn()){
            this.speed += 3;
        } else {
            throw new AccelerationCarOffException();
        }
    }
    @Override
    public void breaking() throws BreakingCarOffException{
        if(this.isOn()){
            this.speed -= 3;
        } else {
            throw new BreakingCarOffException();
        }
    }
    @Override
    public void prepare(){
        JOptionPane.showMessageDialog(null, "Colocar o capacete!");
    }
}
