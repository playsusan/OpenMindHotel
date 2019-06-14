
package Ventanas;

import Controlador.controlador;
import Modelo.ClienteVO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ventanaIngresoRut implements ActionListener{
    
    private ventanaPrincipal ventanaPrincipal;
    private JFrame ventana;
    private JLabel ingreso_rut;
    private JTextField rut;
    private JButton cancelar;
    private JButton continuar;
    private JPanel panelRut;
    private ventanaIngresoClienteNuevo ventanaIngresoClienteNuevo;
    private ventanaIngresoMostrarDetalleCliente ventanaIngresoMostrarDetalleCliente;
    private controlador controlador;
    
    public ventanaIngresoRut(ventanaPrincipal C){
        initVentana();
        initRut();
        this.ventanaPrincipal = C;
    }
        public void initVentana (){
        ventana = new JFrame("HOTEL OPENMIND");
        ventana.setBounds(500,200,800,600);
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initRut(){
        panelRut = new JPanel();
        panelRut.setBackground(Color.pink);
        panelRut.setLayout(null);
        cancelar=new JButton("Cancelar");
	continuar=new JButton("Continuar");
        ingreso_rut=new JLabel("Ingrese rut del Cliente N°"+(controlador.getSumador()+1));
	rut=new JTextField ();
        
        ingreso_rut.setBounds(310, 10, 300, 200);
        ingreso_rut.setFont(ingreso_rut.getFont().deriveFont(16.0f));
        rut.setBounds(290,170,220,50);
        rut.setFont(rut.getFont().deriveFont(16.0f));
        cancelar.setBounds(160,300,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        continuar.setBounds(410,300,220,100);
        continuar.setFont(continuar.getFont().deriveFont(16.0f));
        
        cancelar.addActionListener(this);
        continuar.addActionListener(this);
        
        panelRut.add(ingreso_rut);
        panelRut.add(rut);
        panelRut.add(cancelar);
        panelRut.add(continuar); 
        
        ventana.add(panelRut);
        ventana.validate();
    }   
    void setVisibleIngresoRut(boolean b) {
        rut.setText("");
        ingreso_rut.setText("Ingrese rut del Cliente N°"+(controlador.getSumador()+1));
        ventana.setVisible(b);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if(source.equals(cancelar)){
            ventana.setVisible(false);
            ventanaPrincipal.setVisibleVentanaPrincipal(true);
        }else if(source.equals(continuar)){
             ventana.setVisible(false);
             ClienteVO cliente = controlador.getCliente(rut.getText());
             if(cliente == null ){
                 cliente = new ClienteVO("","","","","","","");
             }
            if (rut.getText().equals(cliente.getRut())){
                if(ventanaIngresoMostrarDetalleCliente==null){
                ventana.setVisible(false);
                ventanaIngresoMostrarDetalleCliente = new ventanaIngresoMostrarDetalleCliente(ventanaPrincipal, cliente,this ); 
                }else{
                ventanaIngresoMostrarDetalleCliente.setVisibleIngresoMostrarDetalleCliente(true);
                ventanaIngresoMostrarDetalleCliente.setNewCliente(cliente);
                }
            }else{
                if(ventanaIngresoClienteNuevo==null){
                ventana.setVisible(false);
                ventanaIngresoClienteNuevo = new ventanaIngresoClienteNuevo(ventanaPrincipal, rut, this); 
                }else{
                ventanaIngresoClienteNuevo.setVisibleIngresoClienteNuevo(true,rut.getText());
                }
                }
        }
    }
}

