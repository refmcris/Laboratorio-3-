/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Estudiante
 */
public class Tablas extends DefaultTableModel{
    public Tablas(Object datos[][], Object encabezados[]){
        super(datos,encabezados);
        
    }
    @Override
    public boolean isCellEditable(int row, int column){
        //return true;
        return false;
    }
    
}
