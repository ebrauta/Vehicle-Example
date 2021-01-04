/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebr.classes;

import com.ebr.exceptions.AccelerationCarOffException;
import com.ebr.exceptions.BreakingCarOffException;
import com.ebr.exceptions.InvalidChassisException;
import com.ebr.exceptions.RefuellingCarOnException;
import com.ebr.interfaces.TurnOn;
import com.ebr.interfaces.Vehicle;
import com.ebr.interfaces.Walker;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public abstract class BaseVehicle implements Vehicle, TurnOn, Walker{
    private String name;
    private String brand;
    private String color;
    private String chassis;
    private String vehicleType;
    private int yearModel;
    protected int numOfWheels;
    private float amountOfFuel;
    private int price;
    private boolean carOn;
    protected float speed;
    
    public BaseVehicle(){
        this.carOn = false;
        this.speed = 0;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getChassis(){
        return chassis;
    }
    public void setChassis(String chassis) throws InvalidChassisException{
        if(chassis.length() == 5){
               this.chassis = chassis;
        } else {
            throw new InvalidChassisException(chassis);
        }
    }
    public String getVehicleType(){
        return vehicleType;
    }
    public void setVehicleType(String vehycleType){
        this.vehicleType = vehycleType;
    }
    public int getYearModel(){
        return yearModel;
    }
    public void setYearModel(int yearModel){
        this.yearModel = yearModel;
    }
    public int getNumberOfWheels(){
        return numOfWheels;
    }
    public float getAmountOfFuel(){
        return amountOfFuel;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public Boolean isOn(){
        return carOn;
    }
    public float getSpeed(){
        return speed;
    }
    @Override
    public final void on(){
        this.carOn = true;
        this.speed = 0;
        JOptionPane.showMessageDialog(null,"O veículo ligou!");
    }
    @Override
    public final void off(){
        this.carOn = false;
        this.speed = 0;
        JOptionPane.showMessageDialog(null,"O veículo desligou!");
    }
    @Override
    public final void refuel(float liters) throws RefuellingCarOnException{
        if(!this.carOn){
            amountOfFuel += liters;
        } else {
            throw new RefuellingCarOnException();
        }
    }
    @Override
    public void accelerating() throws AccelerationCarOffException{
        if(this.carOn){
            this.speed += 10;
        } else {
            throw new AccelerationCarOffException();
        }
    }
    @Override
    public void breaking() throws BreakingCarOffException{
        if(this.carOn){
            this.speed -= 10;
        } else {
            throw new BreakingCarOffException();
        }
    }
    public abstract void prepare();
}
