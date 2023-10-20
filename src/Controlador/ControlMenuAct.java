
package Controlador;

import Vista.MenuActualizar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenuAct implements ActionListener{
    MenuActualizar ma;
    public ControlMenuAct(MenuActualizar obj){
        this.ma=obj;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ma.jblimp)) {
            limpiar();
            
        }
        if (e.getSource().equals(ma.jbreturnm)) {
            volver();
            
        }
    }

    private void limpiar() {
        ma.jtApe.setText("");
        ma.jtCod.setText("");
        ma.jtnam.setText("");
        ma.jtcorreo.setText("");
        ma.tlf.setText("");
        ma.jtcontra.setText("");
        ma.jcargo.setSelectedItem("Administrador");
        ma.jtApe.requestFocus();
    }

    private void volver() {
        ma.setVisible(false);
        ma.dispose();
        ma.mp.setVisible(true);
    }
    
}
