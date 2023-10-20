/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Persona;
import Vista.MenuConsulta;
import Vista.MenuConsulta;
import Vista.MenuConsulta;
import Vista.MenuPrincipal;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiante
 */
public class ControlMenuC implements ActionListener{
    MenuConsulta fm;
    MenuPrincipal mp;
    public int cod;
    

    
    public ControlMenuC(MenuConsulta obj){
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
        if(e.getSource().equals(fm.jbactualizar)){
            fm.llenart();
            
            
          
            
        }
        
        
    }
    private void limpiar() {
        fm.jtApe.setText("");
        fm.jtCod.setText("");
        fm.jtnam.setText("");
        fm.jtcorreo.setText("");
        fm.tlf.setText("");
        fm.jtcontra.setText("");
        fm.jcargo.setSelectedItem("Administrador");
        fm.jtApe.requestFocus();
    }

    private void volver() {
        fm.setVisible(false);
        fm.dispose();
        fm.mp.setVisible(true);
        
    }

    
    
}
