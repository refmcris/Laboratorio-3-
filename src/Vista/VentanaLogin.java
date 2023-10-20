/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorLog;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Felipe
 */
public class VentanaLogin extends JFrame{
    public JTextField jtLogin;
    public JPasswordField jpPassw;
    public JToggleButton jtVer; 
    public JButton jbCancelar, jbIngresar;
    public ImageIcon ver, no_ver;
    public VentanaLogin(){
        super("Ingreso al sistema");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        ControladorLog btn = new ControladorLog(this);
        ImageIcon im = new ImageIcon(getClass().getResource(
                "/imagenes/App-login-manager-icon.png"));
        JLabel jlTitulo = new JLabel("Ingreso al sistema", im, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 400, 75);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.WHITE);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
        
        JLabel jlLogin = new JLabel("Login");
        jlLogin.setBounds(10, 90, 100, 30);
        jlLogin.setHorizontalAlignment(JLabel.RIGHT);
        add(jlLogin);
        
        jtLogin = new JTextField();
        jtLogin.setBounds(120, 90, 150, 30);
        jtLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpPassw.requestFocus(); 
            }
        });
        add(jtLogin);
        
        JLabel jlPass = new JLabel("Password");
        jlPass.setBounds(10, 140, 100, 30);
        jlPass.setHorizontalAlignment(JLabel.RIGHT);
        add(jlPass);
        
        jpPassw = new JPasswordField();
        jpPassw.setBounds(120, 140, 150, 30);
        jpPassw.setEchoChar('*');
        jpPassw.addActionListener(btn);
            
        add(jpPassw);
                
        ver = new ImageIcon(getClass().getResource("/imagenes/ver.png"));
        no_ver = new ImageIcon(getClass().getResource("/imagenes/no_ver.png"));
        jtVer = new JToggleButton(no_ver); 
        jtVer.setBounds(275, 140, 50, 30);
        jtVer.setBorderPainted(false);
        jtVer.setContentAreaFilled(false);  
        jtVer.setFocusPainted(false); 
        jtVer.addActionListener(btn);
        add(jtVer); 
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(45, 200, 150, 35);
        jbCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(jbCancelar);
        
        jbIngresar = new JButton("Ingresar");
        jbIngresar.setBounds(205, 200, 150, 35);
        jbIngresar.addActionListener(btn);
        add(jbIngresar);
        
    }
    
    public static void main(String[] args) {
        VentanaLogin vl = new VentanaLogin();
    }
            
    
}
