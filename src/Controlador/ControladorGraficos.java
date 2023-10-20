/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.GraficaGen;
import Vista.GraficoCargos;
import Vista.MenuGraficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Felipe
 */
public class ControladorGraficos implements ActionListener{
    MenuGraficos mg;
    public ControladorGraficos(MenuGraficos obj){
        this.mg=obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mg.jbGraficCargo)){
            GraficoCargos g= new GraficoCargos(mg);
            mg.setVisible(false);
            
        }
        if(e.getSource().equals(mg.jbgraficogen)){
            GraficaGen g= new GraficaGen(mg);
            mg.setVisible(false);
            
        }
        if(e.getSource().equals(mg.jbreturnm)){
            volver();
            
        }
        
    }

    private void volver() {
        mg.setVisible(false);
        mg.dispose();
        mg.mp.setVisible(true); 
    }
    
}
