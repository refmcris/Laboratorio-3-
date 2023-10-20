/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorGraficos;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Felipe
 */
public class MenuGraficos extends JFrame{
    public MenuPrincipal mp;
    public JButton jbGraficCargo,jbgraficogen,jbreturnm;
    public MenuGraficos(MenuPrincipal obj){
        super("Menu de Graficas");
        this.mp= obj;
        setSize(550, 320);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        crearGUI()  ;
        
        setVisible(true);

    }
    public void crearGUI(){
        ControladorGraficos btnm = new ControladorGraficos(this);
        JLabel jl = new JLabel("  Menú de graficos estadisticos");
        jl.setBounds(0, 0, 550, 60);
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setForeground(Color.BLACK);
        jl.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(jl);
        ImageIcon im1 = new ImageIcon(getClass().getResource("/imagenes/pie_chart.png"));
        jbGraficCargo = new JButton("Cargos", im1);
        jbGraficCargo.setBounds(30, 80, 158, 180);
        jbGraficCargo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbGraficCargo.setBorderPainted(false);
        jbGraficCargo.setContentAreaFilled(false);
        jbGraficCargo.setFocusPainted(false);
        jbGraficCargo.setHorizontalTextPosition(SwingConstants.CENTER);
        jbGraficCargo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbGraficCargo.addActionListener(btnm);
        
        ImageIcon im11 = new ImageIcon(getClass().getResource("/imagenes/pie_chartt.png"));
        jbgraficogen = new JButton("Generos", im11);
        jbgraficogen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbgraficogen.setBorderPainted(false);
        jbgraficogen.setContentAreaFilled(false);
        jbgraficogen.setFocusPainted(false);
        jbgraficogen.setHorizontalTextPosition(SwingConstants.CENTER);
        jbgraficogen.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbgraficogen.setBounds(180, 80, 200, 180);
        jbgraficogen.setMnemonic('A');    
        jbgraficogen.addActionListener(btnm);
        
        
        
        jbreturnm = new JButton("Retornar al menu");
        jbreturnm.setBounds(320, 250, 200, 30);
        jbreturnm.setMnemonic('v');
        jbreturnm.addActionListener(btnm);
        add(jbreturnm);
        add(jbgraficogen);      
        
        add(jbGraficCargo);
        
    }
    
}
