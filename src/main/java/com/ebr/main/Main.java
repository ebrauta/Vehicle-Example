/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebr.main;


import com.ebr.classes.BaseVehicle;
import com.ebr.classes.Bus;
import com.ebr.classes.Car;
import com.ebr.classes.Moto;

//import com.ebr.classes.Rent;
import com.ebr.exceptions.AccelerationCarOffException;
import com.ebr.exceptions.BreakingCarOffException;

import com.ebr.exceptions.InvalidChassisException;
import com.ebr.exceptions.RefuellingCarOnException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Eduardo
 */

public class Main{
    
    public static void Information(BaseVehicle vehicle) throws BreakingCarOffException, AccelerationCarOffException{
        try {
            vehicle.refuel(10); 
            String info = "Tipo de Veículo: " + vehicle.getVehicleType()
                    + "\nModelo: " + vehicle.getName()
                    + "\nCor: " + vehicle.getColor()
                    + "\nAno de fabricação: " + vehicle.getYearModel()
                    + "\nQuantidade de Combustível no Tanque: " + vehicle.getAmountOfFuel() + " litros"
                    + "\nNúmero de Rodas: " + vehicle.getNumberOfWheels()
                    + String.format("\nO Veículo %s está ligado? %b", vehicle.getName(), vehicle.isOn());
            JOptionPane.showMessageDialog(null, info);
            vehicle.refuel(10);
            vehicle.prepare();
            vehicle.on();
            JOptionPane.showMessageDialog(null, String.format("Velocidade atual do veículo: %.2f km/h", vehicle.getSpeed())
                    + "\nAcelerando....");
            vehicle.accelerating();
            JOptionPane.showMessageDialog(null, String.format("Velocidade atual do veículo: %.2f km/h", vehicle.getSpeed())
                    + "\nFreiando....");
            vehicle.breaking();
            JOptionPane.showMessageDialog(null, String.format("Velocidade atual do veículo: %.2f km/h", vehicle.getSpeed()));
        } catch (RefuellingCarOnException rce) {
            System.out.println("Você não pode abastecer um veículo enquanto ele estiver ligado.");
	} catch (Exception e) {
            System.out.println("** Ocorreu um erro: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) throws AccelerationCarOffException {
      //Rent ld = new Rent();
      //ld.run();
        try{
            BaseVehicle corsa = new Car("Corsa","GM","vermelho",1999);
            corsa.setChassis("ABCDE");
            Information(corsa);
            BaseVehicle cg125 = new Moto("CG-125","Honda","preto",2015);
            cg125.setChassis("EDCBA");
            Information(cg125);
            BaseVehicle viaggio = new Bus("MPOLO VIAGGIO","Mercedez","azul",2007);
            viaggio.setChassis("AEBDC");
            Information(viaggio);
        } catch (InvalidChassisException ice){
            System.err.println("O chassi é inválido. " + ice.getMessage());
        } catch (BreakingCarOffException e){
            System.err.println("Ocorreu um erro. " + e.getMessage());
        }
    }
}
