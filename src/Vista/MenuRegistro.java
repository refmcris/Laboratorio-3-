/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControlMenuR;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Estudiante
 */
public class MenuRegistro extends JFrame{
    public MenuPrincipal mp;
    public JButton jbreturnm,jbGuardar,jblimp;
    public JTextField jtApe,jtnam,jtCod,jtcorreo,tlf,jtedad,jtgenero;
    public JComboBox<String> jcargo;
    public JPasswordField jtcontra;
    public MenuRegistro(MenuPrincipal obj){
        super("Menu formulario  ");
        this.mp=obj;
        
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        GUI();
        
        
        setVisible(true);
    }

    private void GUI() {
        ControlMenuR btnm= new ControlMenuR(this);
        
        JLabel jlCod = new JLabel("Cedula:");
        jlCod.setBounds(40, 40, 120, 30);
        add(jlCod);
        jtCod = new JTextField();
        jtCod.setBounds(160, 40, 200, 30);
        jtCod.setDocument(new LimitadorCaracteres(jtCod,10,0));
       
        add(jtCod);
        
        JLabel jlApe= new JLabel("Apellido:");
        jlApe.setBounds(40,80,120,30);
        add(jlApe);
        
        jtApe= new JTextField();
        jtApe.setBounds(160, 80, 200, 30);
        jtApe.setDocument(new LimitadorCaracteres(jtApe,15,1));
        jtApe.setVisible(true);
        add(jtApe);
        
        JLabel jlnam= new JLabel("Nombre:");
        jlnam.setBounds(40,130,120,30);
        add(jlnam);
        
        jtnam= new JTextField();
        jtnam.setBounds(160, 130, 200, 30);
        jtnam.setDocument(new LimitadorCaracteres(jtnam,15,1));
        jtnam.setVisible(true);
        add(jtnam);
        
        JLabel jlcorr= new JLabel("Correo:");
        jlcorr.setBounds(40,230,120,30);
        add(jlcorr);
        
        jtcorreo= new JTextField();
        jtcorreo.setBounds(160, 230, 200, 30);
        jtcorreo.setVisible(true);
        add(jtcorreo);
        
        JLabel jltelefono= new JLabel("Telefono:");
        jltelefono.setBounds(40,270,120,30);
        add(jltelefono);
        
        tlf= new JTextField();
        tlf.setBounds(160, 270, 200, 30);
        tlf.setDocument(new LimitadorCaracteres(tlf,10,0));
        tlf.setVisible(true);
        add(tlf);
        
        JLabel jlestr= new JLabel("Contraseña:");
        jlestr.setBounds(40,180,120,30);
        
        add(jlestr);
        jtcontra = new JPasswordField();
        jtcontra.setBounds(160, 180, 200, 30);
        jtcontra.setEchoChar('*');
        jtcontra.setVisible(true);
        
       
        add(jtcontra);
        
        JLabel jlgen = new JLabel("Genero M/F:");
        jlgen.setBounds(380 , 40, 120, 30);
        add(jlgen);
        jtgenero = new JTextField();
        jtgenero.setBounds(460, 40, 200, 30);
        jtgenero.setDocument(new LimitadorCaracteres(jtgenero,1,1));
        jtgenero.setVisible(true);
        add(jtgenero);
        
        JLabel jledad = new JLabel("Edad:");
        jledad.setBounds(380 , 80, 120, 30);
        add(jledad);
        jtedad = new JTextField();
        jtedad.setBounds(460, 80, 200, 30);
        jtedad.setDocument(new LimitadorCaracteres(jtedad,2,0));
        jtedad.setVisible(true);
        add(jtedad);
        
        

        
        JLabel jlcontr= new JLabel("Cargo:");
        jlcontr.setBounds(40,310,120,30);
        add(jlcontr);
        
        jcargo = new JComboBox<>();
        jcargo.addItem("Administrador");
        jcargo.addItem("Proveedor");
        jcargo.addItem("Cliente");
        jcargo.addItem("Gestor de ventas");
        jcargo.setBounds(160, 310, 120, 30);
        jcargo.setVisible(true);
        add(jcargo);
        
        jbGuardar = new JButton("Guardar");
        jbGuardar.setBounds(60, 420, 150, 30);
        jbGuardar.setMnemonic('G');
        jbGuardar.addActionListener(btnm);
        add(jbGuardar);
        
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
    
    
}
