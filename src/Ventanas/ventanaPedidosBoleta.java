
package Ventanas;

import Controlador.controlador;
import Modelo.HabitacionVO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ventanaPedidosBoleta implements ActionListener{
    
    private ventanaPrincipal ventanaPrincipal;
    private JFrame ventana;
    private JPanel panelProductoBoleta;
    private JButton cancelar;
    private JButton finalizar;
    private JLabel titulo;
    private JTextArea cuadroBoleta;
    private controlador controlador;
    private String textBoleta;
    private HabitacionVO habitacion;
    
    public ventanaPedidosBoleta(ventanaPrincipal ventanaP,String textoBoleta, HabitacionVO habitacion){
        this.habitacion = habitacion;
        this.textBoleta=textoBoleta;
        this.ventanaPrincipal= ventanaP;
        initVentana();
        initProductosBoleta();
    }
    
    public void initVentana (){
	   ventana = new JFrame("HOTEL OPENMIND");
	   ventana.setBounds(500,200,800,600);
	   ventana.setResizable(false);
	   ventana.setVisible(true);
	   ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
     private void initProductosBoleta(){
    	panelProductoBoleta = new JPanel(null); 
    	panelProductoBoleta.setBackground(Color.pink);
    	panelProductoBoleta.setLayout(null);
    	
    	finalizar=new JButton("FINALIZAR");
    	titulo=new JLabel("BOLETA");
        cuadroBoleta = new JTextArea();
        cuadroBoleta.setEditable(false);
        cuadroBoleta.setCaretColor(Color.BLACK);
        
        titulo.setBounds(250,10,100,100);
        cuadroBoleta.setBounds(50,100,500,400);
        finalizar.setBounds(600,430,100,70);
        
        finalizar.addActionListener(this);
        
        
        titulo.setFont(titulo.getFont().deriveFont(24.0f));        
        cuadroBoleta.setFont(cuadroBoleta.getFont().deriveFont(16.0f));
        
        textAreaSetText();
        
        panelProductoBoleta.add(titulo);
        panelProductoBoleta.add(finalizar);
        panelProductoBoleta.add(cuadroBoleta);
        
        
        ventana.add(panelProductoBoleta);
        ventana.validate();
        
        
    	
}
     public void textAreaSetText(){
         String boleta = "Habitacion :"+habitacion.getNombre_habitacion()+"\n\n\n";
         boleta = boleta + textBoleta;
         cuadroBoleta.setText(boleta);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
            if(source.equals(finalizar)){
                ventana.setVisible(false);
                ventanaPrincipal.setVisibleVentanaPrincipal(true);
            }
    }

    void setVisible(boolean b,String boleta, HabitacionVO habitacion) {
        this.habitacion = habitacion;
        this.textBoleta = boleta;
        textAreaSetText();
        ventana.setVisible(b);
    }
}
