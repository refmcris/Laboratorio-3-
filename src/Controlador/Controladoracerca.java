/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Acerca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USER
 */
public class Controladoracerca implements ActionListener {
    Acerca ac;
    
    public Controladoracerca (Acerca obj){
        this.ac = obj;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ac.jbvolver)){
            volver();
            
        }
    }

    private void volver() {
        ac.setVisible(false);
        ac.dispose();
        ac.mp.setVisible(true);
        

    }
}
