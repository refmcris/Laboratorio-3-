/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Felipe
 */
public class GraficaGen extends JFrame {
    MenuGraficos mg;
    int contadores[]= new int[2];
    JButton jbreturnm;
    private JFreeChart chart;
    public GraficaGen(MenuGraficos obj){
        
        super("Grafico - Cantidad de hombres y mujeres registrados");
        this.mg=obj;
        setSize(800, 580);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        GUI();
        grafico();
        
        setVisible(true);
    }
    private void grafico() {
        if (!cant_h_m("src/personas.csv")){
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Mujeres", contadores[1]);
            data.setValue("Hombres", contadores[0]);

            chart = ChartFactory.createPieChart3D(
                    "Estadistica hombres y mujeres", 
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
    public boolean cant_h_m(String filename){
        FileReader fr = null;
        boolean error = false;
        try {
            fr = new FileReader(filename);
        } catch (IOException e) {
            error = true;
            JOptionPane.showMessageDialog(null,"Error al tratar de abrir el archivo");
        }
        

    if (!error){
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
        String tokens[];

        try {
             while ((linea = br.readLine()) != null) {
                tokens = linea.split(";");
                switch(tokens[8]){
                    case "M":     contadores[0]++; break;
                    case "F":     contadores[1]++; break;

                    }
                }
            } catch (IOException e) {// atrapar la excepcion que puede lanzar el metodo readLine()
                JOptionPane.showMessageDialog(null,"Error al tratar de leer el archivo ");
            }

            try {// tratar la excepcion que puede lanzar el metodo close()
                fr.close();
            } catch (IOException e) {// atrapar la excepcion que puede lanzar el metodo close()
                JOptionPane.showMessageDialog(null,"Error al tratar de cerrar el archivo ");
            }
        }
        
        return error;
    
}

    private void GUI() {
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
        
    }
    

