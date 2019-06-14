
package Ventanas;

import Controlador.controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ventanaPrincipal implements ActionListener {

    public void setVisibleVentanaPrincipal(boolean visible) {
        ventanaPrincipal.setVisible(visible);
    }
  
    private JFrame ventanaPrincipal;
    private JPanel panelPrincipal;
    private JButton pedido;
    private JButton ingreso;  
    private JButton salida;
    private JButton informes;
    private JLabel titulo;
    private ventanaIngresoCantidad ventanaIngreso;
    private ventanaSeleccionHabitacionPedido ventanaSeleccionHabitacionPedido;
    private ventanaInformes ventanaInformes;
    private ventanaSalidaSeleccionHabitacion ventanaSalidaSeleccionHabitacion;
    private controlador controlador;
    
    public ventanaPrincipal(){
        controlador = new controlador();
        initVentana();
        initComponentes();
        
    }
    
    public void initVentana (){
        ventanaPrincipal=new JFrame("HOTEL OPENMIND");
        ventanaPrincipal.setBounds(500,200,800,600);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
       private void initComponentes(){
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.pink);
        panelPrincipal.setLayout(null);
        pedido=new JButton("Servicio a la Habitacion");
	ingreso=new JButton("Ingreso");
	salida=new JButton("Salida");
	informes=new JButton("Informes");
        titulo=new JLabel ("MENU PRINCIPAL");
        
        titulo.setBounds(300, 10, 300, 200);
        titulo.setFont(titulo.getFont().deriveFont(22.0f));
        ingreso.setBounds(160,240,220,100);
        ingreso.setFont(ingreso.getFont().deriveFont(16.0f));
        salida.setBounds(410,240,220,100);
        salida.setFont(salida.getFont().deriveFont(16.0f));
        pedido.setBounds(160,360,220,100);
        pedido.setFont(pedido.getFont().deriveFont(16.0f));
        informes.setBounds(410,360,220,100);
        informes.setFont(informes.getFont().deriveFont(16.0f));
        
        
        pedido.addActionListener(this);
        ingreso.addActionListener(this);
        salida.addActionListener(this);
        informes.addActionListener(this);
        
        panelPrincipal.add(titulo);
        panelPrincipal.add(ingreso);
        panelPrincipal.add(salida);
        panelPrincipal.add(pedido); 
        panelPrincipal.add(informes);
        ventanaPrincipal.add(panelPrincipal);
        ventanaPrincipal.validate();
    }
    
       
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if(source.equals(ingreso)){
            if(ventanaIngreso==null){
                setVisibleVentanaPrincipal(false);
                ventanaIngreso = new ventanaIngresoCantidad(this); 
           }else{
               setVisibleVentanaPrincipal(false);
               ventanaIngreso.setVisibleVentanaIngresoCantidad(true);
           }
            
        }else if(source.equals(pedido)){
            if(ventanaSeleccionHabitacionPedido==null){
                setVisibleVentanaPrincipal(false);
                ventanaSeleccionHabitacionPedido = new ventanaSeleccionHabitacionPedido(this); 
           }else{
               setVisibleVentanaPrincipal(false);
               ventanaSeleccionHabitacionPedido.setVisible(true);
           }
            
        }else if(source.equals(informes)){
            if(ventanaInformes==null){
                setVisibleVentanaPrincipal(false);
                ventanaInformes = new ventanaInformes(this); 
           }else{
               setVisibleVentanaPrincipal(false);
               ventanaInformes.setVisible(true);
           }

        
        }else if(source.equals(salida)){
            if(ventanaSalidaSeleccionHabitacion==null){
                setVisibleVentanaPrincipal(false);
                ventanaSalidaSeleccionHabitacion = new ventanaSalidaSeleccionHabitacion(this); 
           }else{
               setVisibleVentanaPrincipal(false);
               ventanaSalidaSeleccionHabitacion.SetAviability();
               ventanaSalidaSeleccionHabitacion.setVisible(true);
           }
        }
    }
}
