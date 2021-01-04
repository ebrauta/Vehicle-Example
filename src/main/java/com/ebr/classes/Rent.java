/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebr.classes;

import com.ebr.exceptions.InvalidChassisException;
import com.ebr.exceptions.RefuellingCarOnException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eduardo
 */
public class Rent extends JFrame implements ActionListener{
    private Car[] cars = new Car[10];
    private Moto[] motos = new Moto[10];
    private Bus[] buses = new Bus[10];
    private int capacity = 10;
    private int quantity = 0;
    private JFrame window = new JFrame();
    private JLabel lb_name = new JLabel("Digite o nome do Veículo");
    private JTextField name = new JTextField();
    private JLabel lb_brand = new JLabel("Digite o fabricante do Veículo");
    private JTextField brand = new JTextField();
    private JLabel lb_color = new JLabel("Digite a cor do Veículo");
    private JTextField color = new JTextField();
    private JLabel lb_year = new JLabel("Digite o ano de fabricação do Veículo");
    private JTextField year = new JTextField();
    private JLabel lb_price = new JLabel("Digite o preço do Veículo");
    private JTextField price = new JTextField();
    private JLabel lb_chasis = new JLabel("Digite o chassi do Veículo");
    private JTextField chasis = new JTextField();
    private JButton search = new JButton("Pesquisar");
    private JButton register = new JButton("Registrar");
    
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(){
        this.capacity = 10;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public void run(){
        search.setActionCommand("Search");
        search.addActionListener(this);
        register.setActionCommand("Register");
        register.addActionListener(this);
        window.setLayout(null);
        addComponent(window, lb_name, 0, 0, 170, 20);
        addComponent(window, name, 0, 30, 170, 20);
        addComponent(window, lb_brand, 0, 55, 170, 20);
        addComponent(window, brand, 0, 85, 170, 20);
        addComponent(window, lb_color, 0, 110, 170, 20);
        addComponent(window, color, 0, 140, 170, 20);
        addComponent(window, lb_year, 0, 165, 170, 20);
        addComponent(window, year, 0, 195, 170, 20);
        addComponent(window, lb_price, 0, 210, 170, 20);
        addComponent(window, price, 0, 240, 170, 20);
        addComponent(window, lb_chasis, 0, 265, 170, 20);
        addComponent(window, chasis, 0, 295, 170, 20);
        addComponent(window, search, 180, 27, 100, 40);
        addComponent(window, register, 180, 137, 100, 40);
        window.setDefaultCloseOperation(HIDE_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocation(Window.HEIGHT/2, Window.WIDTH/2);
        window.setVisible(true);
    }
    
    public String registerVehicle(){
        String[] options = { "Carro", "Motocicleta", "Onibus" };
        int opt = JOptionPane.showOptionDialog(null, "Qual tipo de veículo é este?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String type = options[opt];
        if(quantity<capacity){   
            switch(type){
                case "Carro" -> cars[quantity] = new Car();
                case "Motocicleta" -> motos[quantity] = new Moto();
                case "Onibus" -> buses[quantity] = new Bus();
            }
            quantity++;
        } else {
            System.out.println(String.format("Não há mais %s para alugar.", type));
        }
        return type;
    }
    
    public BaseVehicle searchVehicle(String n){
        for(int i = 0; i < quantity; i++){
            if(cars[i].getName().equals(n)){
                return cars[i];
            } else if(motos[i].getName().equals(n)){
                return motos[i];
            } else if(buses[i].getName().equals(n)){
                return buses[i];
            }
        }
        return null;
    }
    
    private void addComponent(Container container, Component component, int x, int y, int width, int height){
        component.setBounds(x,y,width,height);
        container.add(component);
    }

    private void RegisterAction(){
        this.setCapacity();
        String type = this.registerVehicle();
        int q = quantity -1;
        try {
            if(type.equals("Carro")){
                cars[q].setName(name.getText());
                cars[q].setChassis(chasis.getText());
                cars[q].setBrand(brand.getText());
                cars[q].setColor(color.getText());
                cars[q].setYearModel(Integer.parseInt(year.getText()));
                cars[q].setPrice(Integer.parseInt(price.getText()));
                cars[q].refuel(60);
            } else if(type.equals("Motocicleta")){
                motos[q].setName(name.getText());
                motos[q].setChassis(chasis.getText());
                motos[q].setBrand(brand.getText());
                motos[q].setColor(color.getText());
                motos[q].setYearModel(Integer.parseInt(year.getText()));
                motos[q].setPrice(Integer.parseInt(price.getText())); 
                motos[q].refuel(15);
            } else if(type.equals("Onibus")){
                buses[q].setName(name.getText());
                buses[q].setChassis(chasis.getText());
                buses[q].setBrand(brand.getText());
                buses[q].setColor(color.getText());
                buses[q].setYearModel(Integer.parseInt(year.getText()));
                buses[q].setPrice(Integer.parseInt(price.getText())); 
                buses[q].refuel(240);
            }                         
        } catch(RefuellingCarOnException rce){
            System.err.println("Você não pode abastecer um veículo enquanto o carro estiver ligado.");
        } catch (InvalidChassisException ice){
            System.err.println("O chassi é inválido. " + ice.getMessage());
        } catch (NumberFormatException e){
            System.err.println("Ocorreu um erro. " + e.getMessage());
        }
    }
    
    private void SearchAction(){
        String text = "";
        String name = JOptionPane.showInputDialog("Digite o nome do carro que deseja pesquisar");
        BaseVehicle vehicle = searchVehicle(name);
        if(vehicle == null){
            text = "Não há veículos com este nome.";
        } else {
            text = "Nome: " + vehicle.getName() + 
            "\nFabricante: " + vehicle.getBrand() +
            "\nAno de Fabricação: " + vehicle.getYearModel() +
            "\nPreço do Aluguel: R$" + vehicle.getPrice() + ",00";
        }
        JOptionPane.showMessageDialog(null, text);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         switch(ae.getActionCommand()){
                case "Search" -> SearchAction();
                case "Register" -> RegisterAction();
         }
    }
}
