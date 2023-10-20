/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControlMenuP;
import Modelo.Persona;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Estudiante
 */
public class MenuPrincipal extends JFrame {
    
    
    public JButton jbNuevo, jbConsultar,jbActualizar,jbAcerca,jbvolver,jblistado,jbgraficos,jbcerrar;
    public ArrayList<Persona>personas = new ArrayList<>();
    JLabel jltext;
    
    public MenuPrincipal(){
        super("Menu Principal");
       
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
        
    }
    public void crearGUI() {
        ControlMenuP cmp= new ControlMenuP(this);
        jltext = new JLabel("Menu principal");
        jltext.setBounds(60,0,700,60);
        jltext.setHorizontalAlignment(JLabel.CENTER);
        jltext.setFont(new Font("Tahoma", Font.ITALIC|Font.BOLD, 30));
        add(jltext);
        
        jbNuevo = new JButton("Ingreso de datos");
        jbNuevo.setBounds(300, 100, 200, 40);
        jbNuevo.setMnemonic('I'); 
        jbNuevo.addActionListener(cmp);
        add(jbNuevo);
        jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(300, 160, 200, 40);
        jbConsultar.setMnemonic('C');  
        jbConsultar.addActionListener(cmp);
        add(jbConsultar);
        
        
        jbActualizar = new JButton("Actualizar");
        jbActualizar.setBounds(300, 220, 200, 40);
        jbActualizar.setMnemonic('A');    
        jbActualizar.addActionListener(cmp);
        add(jbActualizar);      
        
        jbAcerca = new JButton("Acerca de... ");
        jbAcerca.setBounds(300, 400,200, 40);
        jbAcerca.setMnemonic('A');    
        jbAcerca.addActionListener(cmp);
        add(jbAcerca);
        jblistado = new JButton("Listados");
        jblistado.setBounds(300, 280, 200, 40);
        jblistado.setMnemonic('L');
        jblistado.addActionListener(cmp);
        add(jblistado);
        jbgraficos = new JButton("Graficos");
        jbgraficos.setBounds(300, 340, 200, 40);
        jbgraficos.setMnemonic('G');
        jbgraficos.addActionListener(cmp);
        add(jbgraficos);
        
        jbcerrar = new JButton("Cerrar sesion");
        jbcerrar.setBounds(570, 500, 200, 40);
        jbcerrar.setMnemonic('G');
        jbcerrar.addActionListener((e) -> {
            setVisible(false);
            dispose();
            VentanaLogin obj = new VentanaLogin();
        });
        add(jbcerrar);
        
        
        
    }
   
}
