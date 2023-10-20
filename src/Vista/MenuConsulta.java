/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;


import Controlador.ControlMenuC;
import Modelo.Persona;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Estudiante
 */
public class MenuConsulta extends JFrame{
    Tablas mt;
    JTable tabla;
    
    public MenuPrincipal mp;
    public JButton jbreturnm,jbactualizar,jblimp;
    public JTextField jtApe,jtnam,jtCod,jtcontra,jtcorreo,tlf,jtgenero,jtedad;
    public JComboBox<String> jcargo;
    public int ced;
    public boolean sw;
    
    public MenuConsulta(MenuPrincipal obj){
        super("Menu Consulta"); 
        this.mp=obj;
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        GUI();


        setVisible(true);
        
    }
    
    public void GUI() {
        ControlMenuC btnm= new ControlMenuC(this);
        
        
        
        JLabel jlCod = new JLabel("Cedula:");
        jlCod.setBounds(40, 40, 120, 30);
        add(jlCod);
        jtCod = new JTextField();
        jtCod.setBounds(160, 40, 200, 30);
        
        add(jtCod);

        JLabel jlApe= new JLabel("Apellido:");
        jlApe.setBounds(40,80,120,30);
        
        add(jlApe);
        
        jtApe= new JTextField();
        jtApe.setBounds(160, 80, 200, 30);
        jtApe.setEnabled(false);
        add(jtApe);
        
        JLabel jlnam= new JLabel("Nombre:");
        jlnam.setBounds(40,130,120,30);
        add(jlnam);
        
        jtnam= new JTextField();
        jtnam.setBounds(160, 130, 200, 30);
        jtnam.setEnabled(false);
        add(jtnam);
        
        JLabel jlcorr= new JLabel("Correo:");
        jlcorr.setBounds(40,230,120,30);
        add(jlcorr);
        
        jtcorreo= new JTextField();
        jtcorreo.setBounds(160, 230, 200, 30);
        jtcorreo.setEnabled(false);
        add(jtcorreo);
        
        JLabel jltelefono= new JLabel("Telefono:");
        jltelefono.setBounds(40,270,120,30);
        add(jltelefono);
        
        tlf= new JTextField();
        tlf.setBounds(160, 270, 200, 30);
        tlf.setEnabled(false);
        add(tlf);
        
        JLabel jlestr= new JLabel("Contrasena:");
        jlestr.setBounds(40,180,120,30);
        add(jlestr);
        jtcontra = new JTextField();
        jtcontra.setBounds(160, 180, 200, 30);
        jtcontra.setEnabled(false);
        
       
        add(jtcontra);
        

        
        JLabel jlcontr= new JLabel("Cargo:");
        jlcontr.setBounds(40,310,120,30);
        add(jlcontr);
        
        jcargo = new JComboBox<>();
        jcargo.addItem("Administrador");
        jcargo.addItem("Proveedor");
        jcargo.addItem("Cliente");
        jcargo.addItem("Gestor de ventas");
        jcargo.setBounds(160, 310, 120, 30);
        jcargo.setEnabled(false);
        add(jcargo);
        JLabel jlgen = new JLabel("Genero M/F:");
        jlgen.setBounds(380 , 40, 120, 30);
        add(jlgen);
        jtgenero = new JTextField();
        jtgenero.setBounds(460, 40, 200, 30);
        jtgenero.setDocument(new LimitadorCaracteres(jtgenero,1,1));
        jtgenero.setEnabled(false);
        add(jtgenero);
        
        
        JLabel jledad = new JLabel("Edad:");
        jledad.setBounds(380 , 80, 120, 30);
        add(jledad);
        jtedad = new JTextField();
        jtedad.setBounds(460, 80, 200, 30);
        jtedad.setDocument(new LimitadorCaracteres(jtedad,2,0));
        jtedad.setEnabled(false);
        add(jtedad);
        
        jbactualizar = new JButton("Consultar");
        jbactualizar.setBounds(60, 420, 150, 30);
        jbactualizar.setMnemonic('G');
        jbactualizar.addActionListener(btnm);
        jbactualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtCod.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"La cedula no puede estar en blanco");
                }else{
                    ced = Integer.parseInt(jtCod.getText());
                    llenart();
                    
                }

            }
            
        });
        add(jbactualizar);
        
        jblimp = new JButton("Limpiar");
        jblimp.setBounds(230, 420, 150, 30);
        jblimp.setMnemonic('L');
        jblimp.addActionListener(btnm);
        add(jblimp);
        
        jbreturnm = new JButton("Retornar al menu");
        jbreturnm.setBounds(400, 420, 200, 30);
        jbreturnm.setMnemonic('v');
        jbreturnm.addActionListener(btnm);
        add(jbreturnm);
        JPanel jp = new JPanel();
        jp.setBounds(20, 30, 650, 320);
        jp.setBackground(Color.GRAY);
        jp.setBorder(new EtchedBorder());
        add(jp);

    }

     public boolean llenart(){

         
        /*for(int i = 0; i< mp.personas.size();i++){
            Persona ad= mp.personas.get(i);
            if (ced == ad.getCedula()) {
                
                contador+=1;
                jtApe.setText(ad.getApellido());
                jtCod.setText(String.valueOf(ad.getCedula()));
                jtnam.setText(ad.getNombre());
                jtcorreo.setText(ad.getCorreo());
                tlf.setText(String.valueOf(ad.getTlf()));
                jtcontra.setText(ad.getContraseña());
                jcargo.setSelectedItem(ad.getCargo());
               
            }
         
        */
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
                    System.out.println(tokens[0]);
                    
                    System.out.println(jtCod.getText()+"Parse");
                    if(tokens[0].equals(jtCod.getText())){
                        existe = true;
                        JOptionPane.showMessageDialog(null, "Los datos de el usuario son:");
                        jtApe.setText(tokens[1]);
                        jtCod.setText(tokens[0]);
                        jtnam.setText(tokens[2]);
                        jtcorreo.setText(tokens[3]);
                        tlf.setText(tokens[4]);
                        jtcontra.setText(tokens[5]);
                        jcargo.setSelectedItem(tokens[6]);
                        jtedad.setText(tokens[7]);
                        jtgenero.setText(tokens[8]);
                        
                        break; // romper el while, para que no siga buscando en el archivo
                    }
                }// fin while
                if (!existe) {
                    JOptionPane.showMessageDialog(null, 
                        "la cedula" + ced + " no existe");
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
}

    

    

