/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Acerca;
import Vista.MenuActualizar;
import Vista.MenuConsulta;
import Vista.MenuGraficos;
import Vista.MenuListado;
import Vista.MenuPrincipal;
import Vista.MenuPrincipal;
import Vista.MenuRegistro;
import Vista.MenuRegistro;
import Vista.VentanaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiante
 */
public class ControlMenuP implements ActionListener{
    MenuPrincipal mp;
    
    
    public ControlMenuP(MenuPrincipal obj){
        this.mp=obj;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mp.jbNuevo)){
            MenuRegistro m= new MenuRegistro(mp);
            mp.setVisible(false);
        }
        if(e.getSource().equals(mp.jbConsultar)){
             MenuConsulta m= new MenuConsulta(mp);
    
            mp.setVisible(false);
        }
        if(e.getSource().equals(mp.jbActualizar)){
            MenuActualizar m = new MenuActualizar(mp);
            mp.setVisible(false);
        }
        
        if(e.getSource().equals(mp.jbAcerca)){
            Acerca a = new Acerca(mp);
              
              mp.setVisible(true);
        }
        if(e.getSource().equals(mp.jblistado)){
            MenuListado a = new MenuListado(mp);
              
              mp.setVisible(false);
        }
        if(e.getSource().equals(mp.jbgraficos)){
            MenuGraficos a = new MenuGraficos(mp);
            mp.setVisible(false);
            
        }
        
    
    }
    
    
}
