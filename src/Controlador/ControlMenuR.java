/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Vista.MenuRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class ControlMenuR implements ActionListener{
    MenuRegistro fm;

    
   
    public ControlMenuR(MenuRegistro obj){

        this.fm= obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(fm.jbreturnm)){
            volver();
        }
        if(e.getSource().equals(fm.jblimp)){
            limpiar();
            
        }
        if(e.getSource().equals(fm.jbGuardar)){

            guardar();
        }
    }
    
    private void guardar (){
        FileWriter fw = null;
        boolean error = false;
        boolean existe = false;
       
        try {
            fw = new FileWriter(
               "src/personas.csv", true);
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, 
                e + "\n\nError al tratar de crear/abrir el archivo");            
        }
        if(!error){
            int cod = Integer.parseInt(fm.jtCod.getText());
            if (!validar_codigo(cod)){
                if(fm.jtApe.getText().isEmpty() || fm.jtnam.getText().isEmpty() || fm.jtcontra.getText().isEmpty() || fm.jtcorreo.getText().isEmpty() || fm.jtgenero.getText().isEmpty() ||  fm.jtedad.getText().isEmpty() || fm.tlf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Los campos no pueden estar vacios");
                    
                }else{
                    String ape = fm.jtApe.getText();
                    String nom = fm.jtnam.getText();
                    String contra = fm.jtcontra.getText();
                    String correo= fm.jtcorreo.getText();
                    String genero = fm.jtgenero.getText();
                    String edad = fm.jtedad.getText();
                    String tlf = fm.tlf.getText();
                    String cargo = (String) fm.jcargo.getSelectedItem();
                    try {
                
                   fw.write(cod + ";" + ape + ";" + nom + ";" + correo + ";" + tlf + ";" + contra + ";" + cargo + ";"+edad+";"+genero+"\r\n");
                    JOptionPane.showMessageDialog(null, 
                        "Se guardo con exito el registro");
                    volver();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, 
                       e + "\n\nError al guardar en el archivo"); 
                }
                try {
                    fw.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, 
                       e + "\n\nError al cerrar el archivo"); 
                }
                    
                }
                
                
                
                
            
            
            }
        }
    }
    
    public boolean validar_codigo (int codigo) {
        FileReader fr = null;
        boolean error = false;
        boolean existe = false;
        try {
            fr = new FileReader(
               "src/personas.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, 
                   e + "\n\nError al abrir el archivo"); 
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];
            try {
                while ((linea=br.readLine()) != null) {                    
                    //System.out.println(linea);
                    tokens = linea.split(";");
                    if(tokens[0].equals(fm.jtCod.getText())){
                        existe = true;
                        JOptionPane.showMessageDialog(null, "Ya hay un usuario registrado con ese codigo");
                        break;
                }
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                   e + "\n\nError al leer el archivo"); 
            }
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                   e + "\n\nError al cerrar el archivo"); 
            }
        }
        
        
        
        return existe;
        
        
    }

    private void limpiar() {
        fm.jtApe.setText("");
        fm.jtCod.setText("");
        fm.jtnam.setText("");
        fm.jtcorreo.setText("");
        fm.tlf.setText("");
        fm.jtcontra.setText("");
        fm.jtgenero.setText("");
        fm.jtedad.setText("");
        fm.jcargo.setSelectedItem("Administrador");
        fm.jtApe.requestFocus();
       
    }

    private void volver() {
        fm.setVisible(false);
        fm.dispose();
        fm.mp.setVisible(true); 
    }
   
   }
   
        
    



