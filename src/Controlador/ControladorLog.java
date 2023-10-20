/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.MenuPrincipal;
import Vista.VentanaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class ControladorLog implements ActionListener{
    VentanaLogin vl;
    public ControladorLog(VentanaLogin obj){
        this.vl = obj;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vl.jpPassw)) {
            llenart();
            
        }
        if (e.getSource().equals(vl.jtVer)) {
            evento_jtVer();
            
        }
        if(e.getSource().equals(vl.jbIngresar)){
            llenart();
        }
    }
     
    public  void evento_jtVer(){
        if(vl.jtVer.isSelected()){
            vl.jtVer.setIcon(vl.ver); 
            vl.jpPassw.setEchoChar((char) 0); 
        }else{
            vl.jtVer.setIcon(vl.no_ver); 
            vl.jpPassw.setEchoChar('*'); 
        }
        vl.jpPassw.requestFocus(); 
    }
    
    
    public void llenart(){
        String login = vl.jtLogin.getText();
        char caracteres[] = vl.jpPassw.getPassword(); 
        String passw = String.valueOf(caracteres);
        
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
            if(login.equals("admin") && passw.equals("admin")){
                        JOptionPane.showMessageDialog(null, "Ingreso correcto");
                        existe = true;
                        vl.setVisible(false);
                        vl.dispose();
                        MenuPrincipal obj = new MenuPrincipal();
                        
                
                
                
            }
            try {
                while ((linea=br.readLine()) != null) {                    
                    //System.out.println(linea);
                    tokens = linea.split(";");
                    
                        
                    
                    if(login.equals(tokens[0]) && passw.equals(tokens[5])){
                        JOptionPane.showMessageDialog(null, "Ingreso correcto");
                        existe = true;
                        vl.setVisible(false);
                        vl.dispose();
                        MenuPrincipal obj = new MenuPrincipal();
                        
                
                
                
            }
                }// fin while
                if (!existe) {
                    JOptionPane.showMessageDialog(null, 
                        "el  usuario" + login + " no existe/ Contraseña incorrecta");
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

    
    
    }
}

    
    


