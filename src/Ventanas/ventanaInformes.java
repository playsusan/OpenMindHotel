package Ventanas;

import Controlador.controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ventanaInformes implements ActionListener {
	
	
	private JFrame ventana;
	private ventanaPrincipal ventanaPrincipal;
	private JLabel titulo;
	private JPanel panelInforme;
	private controlador controlador;
	private JButton I1informeRut;
	private JTextField I1informeRutText;
	private JLabel  ingresarRut;
	private JButton I2clienteMayorR;
	private JButton I3habitacionMayorR;
	private JButton I4habitacionMenorR;
	private JButton I5productosMasV;
	private JButton I6productosMenosV;
	private JTextArea textoInforme;
	
	private JButton cancelar;
	
    public ventanaInformes(ventanaPrincipal P) {
        initVentana();
        initInforme();
    this.ventanaPrincipal = P;
    }


    public void initVentana (){
    	ventana = new JFrame("INFORMES");
    	ventana.setBounds(500,200,800,600);
    	ventana.setResizable(false);
    	ventana.setVisible(true);
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initInforme(){
    	panelInforme = new JPanel(null); //gridlayoud
    	panelInforme.setBackground(Color.pink);
    	panelInforme.setLayout(null);
    	
    //	cancelar=new JButton("VOLVER AL MENU");
    //	aceptarpedido=new JButton("Ingresar pedido");
    	
    	titulo = new JLabel("INFORMES");
    	
    	I1informeRut = new JButton("Informe RUT");
    	I1informeRutText= new JTextField();
    	I2clienteMayorR = new JButton("Cliente mayor Ingreso");
    	I3habitacionMayorR = new JButton("Habitacion con más registros");
    	I4habitacionMenorR = new JButton("Habitacion con menos registros");
    	I5productosMasV = new JButton("Producto mas vendido");
    	I6productosMenosV = new JButton("Producto menos vendido");
    	textoInforme = new JTextArea();
    	ingresarRut = new JLabel(": Ingresar Rut");
    	
    	cancelar = new JButton("REGRESAR AL MENU");
    	
        I1informeRut.addActionListener(this);
    	I2clienteMayorR.addActionListener(this);
    	I3habitacionMayorR.addActionListener(this);
    	I4habitacionMenorR.addActionListener(this);
    	I5productosMasV.addActionListener(this);
    	I6productosMenosV.addActionListener(this);
    	
    	I1informeRut.setBounds(50,100,250,40);
    	I1informeRut.setFont(I1informeRut.getFont().deriveFont(12.0f));

    	I2clienteMayorR.setBounds(50,150,250,40);
    	I2clienteMayorR.setFont(I2clienteMayorR.getFont().deriveFont(12.0f));

    	I3habitacionMayorR.setBounds(50,200,250,40);
    	I3habitacionMayorR.setFont(I3habitacionMayorR.getFont().deriveFont(12.0f));

    	I4habitacionMenorR.setBounds(50,250,250,40);
    	I4habitacionMenorR.setFont(I4habitacionMenorR.getFont().deriveFont(12.0f));

    	I5productosMasV.setBounds(50,300,250,40);
    	I5productosMasV.setFont(I5productosMasV.getFont().deriveFont(12.0f));
    	
    	I6productosMenosV.setBounds(50,350,250,40);
    	I6productosMenosV.setFont(I6productosMenosV.getFont().deriveFont(12.0f));
    	
        titulo.setBounds(330, -65, 300, 200);
        titulo.setFont(titulo.getFont().deriveFont(22.0f));
        
        textoInforme.setBounds(350, 150, 400, 400);
        textoInforme.setFont(textoInforme.getFont().deriveFont(10.0f));
        
        cancelar.setBounds(50,450,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        
        I1informeRutText.setBounds(350, 100, 100, 30);
        I1informeRutText.setFont(I1informeRutText.getFont().deriveFont(12.0f));
        
        ingresarRut.setBounds(460, 100, 100, 30);
        ingresarRut.setFont(ingresarRut.getFont().deriveFont(12.0f));

    	panelInforme.add(titulo);
    	panelInforme.add(I1informeRut);
    	panelInforme.add(I1informeRutText);
    	panelInforme.add(I2clienteMayorR);
    	panelInforme.add(I3habitacionMayorR);
    	panelInforme.add(I4habitacionMenorR);
    	panelInforme.add(I5productosMasV);
    	panelInforme.add(I6productosMenosV);
    	panelInforme.add(cancelar);
    	panelInforme.add(textoInforme);
    	panelInforme.add(ingresarRut);

    	ventana.add(panelInforme);
    	ventana.validate();
    	
        cancelar.addActionListener(this);
      

    }
    
    void setTextIngresoRut(){
    	
    	I1informeRutText.setText("0");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    JButton source = (JButton)e.getSource();
        if(source.equals(cancelar)){
            ventana.setVisible(false);
            ventanaPrincipal.setVisibleVentanaPrincipal(true);
        }else if(source.equals(ventanaPrincipal)){
            
        }if(source.equals(I1informeRut)){
            
          textoInforme.setText(controlador.DatosCliente(I1informeRutText.getText()));
    
        }if(source.equals(I2clienteMayorR)){
            
          textoInforme.setText(controlador.GetClienteDelAmor());
    
        }if(source.equals(I3habitacionMayorR)){
            
          textoInforme.setText(controlador.GetHabitacionMasUsada());
    
        }if(source.equals(I4habitacionMenorR)){
            
          textoInforme.setText(controlador.GetHabitacionMenosUsada());
    
        }if(source.equals(I5productosMasV)){
            
          textoInforme.setText(controlador.GetProductomasVendido());
    
        }if(source.equals(I6productosMenosV)){
            
          textoInforme.setText(controlador.GetProductomenosVendido());
    
        }
    
    
    }

    void setVisible(boolean b) {
        textoInforme.setText("");
        ventana.setVisible(b);
    }
}