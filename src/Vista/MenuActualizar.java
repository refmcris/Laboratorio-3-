/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControlMenuAct;
import Modelo.Persona;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Felipe
 */
public class MenuActualizar extends JFrame{
    public MenuPrincipal mp;
    public JButton jbreturnm,jbactualizar,jblimp,jbguardar;
    public JTextField jtApe,jtnam,jtCod,jtcontra,jtcorreo,tlf,jtgenero,jtedad;
    public JComboBox<String> jcargo;
    public int ced;
    public boolean sw;
    
    public MenuActualizar(MenuPrincipal obj){
        super("Menu Consulta"); 
        this.mp=obj;
        setSize(750,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        GUI();


        setVisible(true);
        this.mp=obj;
    }

 public void GUI() {
        
        ControlMenuAct btnm = new ControlMenuAct(this);
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
        
        jbguardar = new JButton("Actualizar");
        jbguardar.setBounds(20, 420, 150, 30);
        jbguardar.setMnemonic('A');
        jbguardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtApe.getText().isEmpty() || jtnam.getText().isEmpty() || jtcontra.getText().isEmpty() || jtcorreo.getText().isEmpty() || jtgenero.getText().isEmpty() ||  jtedad.getText().isEmpty() || tlf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Los campos no pueden estar vacios");
                    
                
                    
                    
                    
                }else{
                    ced = Integer.parseInt(jtCod.getText());
                    actualizar();
                }
                
                
            }
            
        });
        add(jbguardar);
        
        
        jbactualizar = new JButton("Consultar");
        jbactualizar.setBounds(180, 420, 150, 30);
        jbactualizar.setMnemonic('A');
        //jbactualizar.addActionListener(btnm);
        jbactualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtCod.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"La cedula no puede estar en blanco");
                    
                    
                    
                }else{
                    ced = Integer.parseInt(jtCod.getText());
                    consultar();
                }
                
                
            }
            
        });
        add(jbactualizar);
        
        jblimp = new JButton("Limpiar");
        jblimp.setBounds(350, 420, 150, 30);
        jblimp.setMnemonic('L');
        jblimp.addActionListener(btnm);
        add(jblimp);
        
        jbreturnm = new JButton("Retornar al menu");
        jbreturnm.setBounds(520, 420, 150, 30);
        jbreturnm.setMnemonic('v');
        jbreturnm.addActionListener(btnm);
        add(jbreturnm);
        JPanel jp = new JPanel();
        jp.setBounds(20, 30, 650, 320);
        jp.setBackground(Color.GRAY);
        jp.setBorder(new EtchedBorder());
        add(jp);

    }
    public void consultar(){
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
            ArrayList<String> lineas = new ArrayList<>();
            String tokens[];
            try {
                while ((linea=br.readLine()) != null) {                    
                    //System.out.println(linea);
                    tokens = linea.split(";");
                    

                    if(tokens[0].equals(jtCod.getText())){
                        existe = true;
                        JOptionPane.showMessageDialog(null, "Los datos de el usuario son:");
                        jtCod.setEnabled(false);
                        jtApe.setEnabled(true);
                        jtnam.setEnabled(true);
                        jtcorreo.setEnabled(true);
                        tlf.setEnabled(true);
                        jtcontra.setEnabled(true);
                        jcargo.setEnabled(true);
                        jtgenero.setEnabled(true);
                        jtedad.setEnabled(true);
                        
                        jtApe.setText(tokens[1]);
                        jtCod.setText(tokens[0]);
                        jtnam.setText(tokens[2]);
                        jtcorreo.setText(tokens[3]);
                        tlf.setText(tokens[4]);
                        jtcontra.setText(tokens[5]);
                        jcargo.setSelectedItem(tokens[6]);
                        jtedad.setText(tokens[7]);
                        jtgenero.setText(tokens[8]);
                        
                    }else{
                        lineas.add(linea);
                    }
                }
                
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

        
        
    
}
    
    public void actualizar(){
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
            ArrayList<String> lineas = new ArrayList<>();
            String tokens[];
            try {
                while ((linea=br.readLine()) != null) {                    
                    //System.out.println(linea);
                    tokens = linea.split(";");
                    

                    if(tokens[0].equals(jtCod.getText())){
                        existe = true;
                        String nom = jtnam.getText();
                        String contra = jtcontra.getText();
                        String correo= jtcorreo.getText();
                        int tlff = Integer.parseInt(tlf.getText());
                        String gen = jtgenero.getText();
                        String cargo = (String) (jcargo.getSelectedItem());
                        int edad = Integer.parseInt(jtedad.getText());
                        JOptionPane.showMessageDialog(null, "La actualizacion fue exitosa.");
                        String ape = jtApe.getText();
                        tokens[1]= ape;
                        tokens[2]=nom;
                        tokens[3]=correo;
                        tokens[4]=String.valueOf(tlff);
                        tokens[5]=contra;
                        tokens[6]=cargo;
                        tokens[7]=String.valueOf(edad);
                        tokens[8]=gen;
                        
                        
                
                        
                        String editada = String.join(";", tokens);
                        lineas.add(editada);    
                    }else{
                        lineas.add(linea);
                    }
                }
                BufferedWriter escritor = new BufferedWriter(new FileWriter("src/personas.csv"));
                    for (String l : lineas) {
                        escritor.write(l);
                        escritor.newLine();
                    }
                    escritor.close();
               
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
        
    }
    
    
}