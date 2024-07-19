/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Interface;

/**
 *
 * @author Rayson
 */
//En esta clase controlador vamos a interractuar entre los componentes de la vista y el modelo
public class Controlador implements ActionListener{
    private Interface vista;
    private Model model;
    public Controlador(Interface vista){
        this.vista=vista;
        this.model=new Model();
    }
    
    public void InicioVista(){
        vista=new Interface();
        vista.numero1.setText(String.valueOf(model.getNum1()));
        vista.numero2.setText(String.valueOf(model.getNum2()));
        vista.resultado.setText(String.valueOf(model.getCalcular()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Model model=new Model();
        try{
        int nume1=Integer.parseInt(vista.numero1.getText());
        model.setNum1(nume1);
        int nume2=Integer.parseInt(vista.numero2.getText());
        model.setNum2(nume2);
        if(vista.comboOperacion.getSelectedItem().equals("Suma")){
            model.setCalcular(model.sumar());
            vista.resultado.setText(String.valueOf(model.getCalcular()));
        }else if(vista.comboOperacion.getSelectedItem().equals("Resta")){
            model.setCalcular(model.restar());
            vista.resultado.setText(String.valueOf(model.getCalcular()));
        }else if(vista.comboOperacion.getSelectedItem().equals("Multiplicacion")){
            model.setCalcular(model.multiplicar());
            vista.resultado.setText(String.valueOf(model.getCalcular()));
        }else if(vista.comboOperacion.getSelectedItem().equals("Division")){
            if(nume1==0.0 || nume2==0.0){
                vista.errorResultado.setText("No se puede dividir entre 0");
                vista.numero1.setText("");
                vista.numero2.setText("");
            }else{
            model.setCalcular(model.dividir());
            vista.resultado.setText(String.valueOf(model.getCalcular()));
            }
   
        }
        }catch(NumberFormatException ex){
            vista.errorResultado.setText("Error: ingrese un valor numérico");
        }
    }
}
