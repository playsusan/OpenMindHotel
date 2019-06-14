package Ventanas;

import Controlador.controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ventanaIngresoCantidad implements ActionListener{
    
    private ventanaPrincipal ventanaPrincipal;
    private JFrame ventana;
    private JLabel cantidad_clientes;
    public JTextField cantidad;
    private JButton cancelar;
    private JButton continuar;
    private JPanel panelPrincipal;
    private ventanaIngresoRut ventanaIngresoRut;
    private controlador controlador;

    
    public ventanaIngresoCantidad (ventanaPrincipal v){
        
        initVentana();
        initCantidad();
        this.ventanaPrincipal = v;
    }
    
    public void initVentana (){
        ventana = new JFrame("HOTEL OPENMIND");
        ventana.setBounds(500,200,800,600);
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initCantidad(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.pink);
        panelPrincipal.setLayout(null);
        cancelar=new JButton("Cancelar");
	continuar=new JButton("Continuar");
	cantidad_clientes=new JLabel("Ingrese cantidad de Clientes");
	cantidad=new JTextField ();
        
        cantidad_clientes.setBounds(290, 10, 300, 200);
        cantidad_clientes.setFont(cantidad_clientes.getFont().deriveFont(16.0f));
        cantidad.setBounds(290,170,220,50);
        cantidad.setFont(cantidad.getFont().deriveFont(16.0f));
        cancelar.setBounds(160,300,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        continuar.setBounds(410,300,220,100);
        continuar.setFont(continuar.getFont().deriveFont(16.0f));
        
        
        cancelar.addActionListener(this);
        continuar.addActionListener(this);
        
        panelPrincipal.add(cantidad_clientes);
        panelPrincipal.add(cantidad);
        panelPrincipal.add(cancelar);
        panelPrincipal.add(continuar); 
        
        ventana.add(panelPrincipal);
        ventana.validate();
    } 
   
    public void setVisibleVentanaIngresoCantidad(boolean visible) {
      
        ventana.setVisible(visible);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        
        if(source.equals(cancelar)){
            ventana.setVisible(false);
            ventanaPrincipal.setVisibleVentanaPrincipal(true);
        }else if(source.equals(continuar)){
            ventana.setVisible(false);
            String i = cantidad.getText();
            int y = Integer.parseInt(i);
            controlador.setComparador(y);
            controlador.setContCliente();
            if(ventanaIngresoRut==null){
                ventanaPrincipal.setVisibleVentanaPrincipal(false);
                ventanaIngresoRut = new ventanaIngresoRut(ventanaPrincipal); 
            }
            else {
                ventanaIngresoRut.setVisibleIngresoRut(true);
            }

        } else {
        }
    }
}
