/*
 * Vehicle - BUS
 */
package com.ebr.classes;

import com.ebr.exceptions.AccelerationCarOffException;
import com.ebr.exceptions.BreakingCarOffException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Bus extends BaseVehicle{
    private int numOfDoors;
    
    public int getNumOfDoors(){
        return numOfDoors;
    }
    public void setNumOfDoors(int numOfDoors){
        this.numOfDoors = numOfDoors;
    }
    public Bus(){
        this.numOfWheels = 6;
        this.setVehicleType("Onibus");
    }
    public Bus(String name, String brand, String color, int year){
        this.numOfWheels = 6;
        this.setVehicleType("Onibus");
        this.setName(name);
        this.setBrand(brand);
        this.setColor(color);
        this.setYearModel(year);
    }
     @Override
    public void accelerating() throws AccelerationCarOffException{
        if(this.isOn()){
            this.speed += 5;
        } else {
            throw new AccelerationCarOffException();
        }
    }
    @Override
    public void breaking() throws BreakingCarOffException{
        if(this.isOn()){
            this.speed -= 5;
        } else {
            throw new BreakingCarOffException();
        }
    }
    @Override
    public void prepare() {
        JOptionPane.showMessageDialog(null, "Colocar o cinto de segurança");
        JOptionPane.showMessageDialog(null, "Fechar as portas");
    }
    
}
