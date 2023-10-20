/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorGraficos;
import Modelo.Persona;
import controlador.ModeloTabla;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Felipe
 */
public class MenuListado extends JFrame{
    ModeloTabla mt;
    JTable tabla;
    MenuPrincipal mp;
    public JComboBox<String> jblistado;
    JButton jbbuscar, jbreturnm;
    
        
    public MenuListado(MenuPrincipal mp){
        super("Listado de clientes Concessionary Now");
        this.mp = mp;
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        crearGUI();
       
        
        setVisible(true);
    }
        
    private void crearGUI() {

        JLabel jl = new JLabel("  Listado de clientes");
        jl.setBounds(0, 0, 500, 50);
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jl);
        
        String encabezados[] = {"Cedula","Nombre","Apellido","Genero"};
        String datos[][] = {{"", "", "", "","",""}};
        mt = new ModeloTabla(datos, encabezados);
        tabla = new JTable(mt);
        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);
        jblistado = new JComboBox<>();
        jblistado.addItem("Listado general");
        jblistado.addItem("Genero M");
        jblistado.addItem("Genero F");
        jblistado.setBounds(40, 220, 120, 30);
        add(jblistado);
        jbbuscar = new JButton("Buscar");
        jbbuscar.setBounds(300, 220, 150, 30);
        jbbuscar.setMnemonic('B');
        jbbuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mt.setRowCount(0);
                try{
                    BufferedReader br = new BufferedReader(new FileReader("src/personas.csv"));
                    String linea;
                    while((linea = br.readLine()) != null){
                        String[] datos = linea.split(";");
                        if(jblistado.getSelectedItem().equals("Genero M")){
                            if(datos[8].equals("M")){
                                mt.addRow(new Object[]{datos[0], datos[1], datos[3],datos[8]});
                            }   
                        }
                        if(jblistado.getSelectedItem().equals("Genero F")){
                            if(datos[8].equals("F")){
                                mt.addRow(new Object[]{datos[0], datos[1], datos[3],datos[8]});
                            }   
                        }
                        if(jblistado.getSelectedItem().equals("Listado general")){
                            mt.addRow(new Object[]{datos[0], datos[1], datos[3],datos[8]});
                        }
                    }
                }catch(Exception ex){ 
                }
            }
        });
        
        jbreturnm = new JButton("Volver al menu");
        jbreturnm.setBounds(180, 220, 100, 30);
        jbreturnm.setMnemonic('v');
        jbreturnm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                mp.setVisible(true);
            }
        });
        add(jbreturnm);
        add(jbbuscar);

        
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(20, 60, 450, 150);
        
        add(js);
    }
}
    
    

