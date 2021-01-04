/*
 * Vehicle CAR
 */
package com.ebr.classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public final class Car extends BaseVehicle{
    private int numOfDoors;
   
    public int getNumOfDoors(){
        return numOfDoors;
    }
    public void setNumOfDoors(int numOfDoors){
        this.numOfDoors = numOfDoors;
    }
    public Car(){
        this.numOfWheels = 4;
        this.setVehicleType("Carro");
    }
    public Car(String name, String brand, String color, int year){
        this.numOfWheels = 4;
        this.setVehicleType("Carro");
        this.setName(name);
        this.setBrand(brand);
        this.setColor(color);
        this.setYearModel(year);
    }
    @Override
    public void prepare(){
        JOptionPane.showMessageDialog(null, "Colocar o cinto de segurança");
        JOptionPane.showMessageDialog(null, "Acertar os retrovisores");
    }
}
