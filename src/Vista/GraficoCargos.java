/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;


public class GraficoCargos extends JFrame{
    MenuGraficos mg;
    JLabel mensaje;
    int contadores[]= new int[4];
    JButton jbreturnm;
     JFreeChart chart;
    
    public GraficoCargos(MenuGraficos obj){
        super("Grafico por cargos ");
        setSize(800, 580);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

       crearGUI();
       crearGrafico();
        
        setVisible(true);
        this.mg=obj;
    }

    private void crearGUI() {
        mensaje = new JLabel(""); 
        mensaje.setBounds(1, 300, 800, 30);
        mensaje.setFont(new Font("Tahoma", Font.BOLD, 20));
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        add(mensaje);
        
        jbreturnm = new JButton("Retornar al menu");
        jbreturnm.setBounds(580, 500, 200, 30);
        jbreturnm.setMnemonic('v');
        jbreturnm.addActionListener((e) -> {
            volver();
        });
        add(jbreturnm);

    
    }
    private void volver() {
        setVisible(false);
        dispose();
        mg.mp.setVisible(true); 
    }
    public void crearGrafico() {        
        if(!cant_X_nivelEstudios("src/personas.csv")){      
             
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Administrador", contadores[0]);
            data.setValue("Proveedor", contadores[1]);
            data.setValue("Cliente", contadores[2]);
            data.setValue("Gestor de ventas", contadores[3]);
            

         
            chart = ChartFactory.createPieChart3D(
                    "Tipo de cargos", 
                    data, 
                    true, 
                    true,
                    false
            );
            
          
            TextTitle subtitle1 = new TextTitle("Lista de clientes");
            chart.addSubtitle(subtitle1);
            
            
            PiePlot pieplot = (PiePlot) chart.getPlot();  
            pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));   
            
            
            ChartPanel panel = new ChartPanel(chart, false);
            panel.setBounds(10, 20, 760, 450);
            add(panel);
            
        }
    }
    
    public boolean cant_X_nivelEstudios(String fileName) {
        FileReader fr = null; 
        boolean error = false; 

        try {
            fr = new FileReader(fileName);
        } catch (IOException e) {
            error = true;// existio un error 
            mensaje.setText("Error al tratar de abrir el archivo '" + fileName + "'");
        }

        if (!error) {
            
            
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];

            try {
                while ((linea = br.readLine()) != null) {
                    
                    tokens = linea.split(";");
                   
                    switch(tokens[6]){ 
                        case "Administrador":       contadores[0]++; break;
                        case "Proveedor":     contadores[1]++; break;
                        case "Cliente": contadores[2]++; break;
                        case "Gestor de ventas":        contadores[3]++; break;
                        
                    }
                }
            } catch (IOException e) {
                mensaje.setText("Error al tratar de leer el archivo '" + fileName + "'");
            }

            try {
                fr.close();
            } catch (IOException e) {
                mensaje.setText("Error al tratar de cerrar el archivo '" + fileName + "'");
            }
        }
        
        return error;
    }
    
    
    
}
