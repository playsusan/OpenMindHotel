
package Ventanas;

import Controlador.controlador;
import Modelo.ClienteVO;
import Modelo.HabitacionVO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ventanaIngresoBoleta implements ActionListener{
    
        private ventanaPrincipal ventanaPrincipal;
    private JFrame ventana;
    private JPanel panelProductoBoleta;
    private JButton cancelar;
    private JButton finalizar;
    private JLabel titulo;
    private JTextArea cuadroBoleta;
    private controlador controlador;
    private int cont;
    private HabitacionVO habitacion;
    private int jornada;
    private String jornadaText;
    private int cantidadPersonas;
    private ClienteVO[] cliente;
    
    public ventanaIngresoBoleta(ventanaPrincipal ventanaP,HabitacionVO habitacion, int w){
        this.habitacion = habitacion;
        this.ventanaPrincipal= ventanaP;
        this.cantidadPersonas = controlador.getComparador();
        cliente = new ClienteVO[10];
        if (w==0){
            jornada = habitacion.getPrecio_momento();
            jornadaText = "Momento";
        }else if ( w==1){
            jornada = habitacion.getPrecio_jornada();
            jornadaText = "Completa";
        }
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
        
        SetHabitacionOcupada();
        textAreaSetText();
        newRegistro();
        
        panelProductoBoleta.add(titulo);
        panelProductoBoleta.add(finalizar);
        panelProductoBoleta.add(cuadroBoleta);
        
        
        ventana.add(panelProductoBoleta);
        ventana.validate();
        
        
    	
}
     public void textAreaSetText(){
         double sumador =0;
         String boleta = "Habitacion :"+habitacion.getNombre_habitacion()+"\n\nTipo de Jornada: "
                            +jornadaText+"\n\nPersonas Hospedadas: "+cantidadPersonas+"\n";
         for(int i = 0;i<cantidadPersonas;i++){
             cliente[i] = controlador.retornarCliente(i);
             boleta = boleta + "\nCliente:   "+cliente[i].getNombre()+" "+cliente[i].getApellido_p()+"    valor: $"+jornada;
              sumador = sumador + jornada;
              
              
             
         }
         if(cantidadPersonas==3){
             sumador = (sumador  *0.9) ;
             boleta = boleta +"\n\nDescuento Aplicado por cantidad de personas : 10%";
         }if(cantidadPersonas==4){
             sumador = (sumador  *0.8) ;
             boleta = boleta +"\n\nDescuento Aplicado por cantidad de personas : 20%";
         }if(cantidadPersonas==5){
             sumador = (sumador  *0.7) ;
             boleta = boleta +"\n\nDescuento Aplicado por cantidad de personas : 30%";
         }if(cantidadPersonas==6){
             sumador = (sumador  *0.6) ;
             boleta = boleta +"\n\nDescuento Aplicado por cantidad de personas : 40%";
         }if(cantidadPersonas>=7){
             sumador = (sumador  *0.5) ;
             boleta = boleta +"\n\nDescuento Aplicado por cantidad de personas : 50%";
         }
         boleta= boleta + "\n\n\n\nTotal:               $"+sumador;
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

    void setVisible(boolean b) {
        SetHabitacionOcupada();
        ventana.setVisible(b);
    }
    
    void setNewBoleta(HabitacionVO habitacion, int w){
        this.habitacion = habitacion;
        this.cantidadPersonas = controlador.getComparador();
        cliente = new ClienteVO[10];
        if (w==0){
            jornada = habitacion.getPrecio_momento();
            jornadaText = "Momento";
        }else if ( w==1){
            jornada = habitacion.getPrecio_jornada();
            jornadaText = "Completa";
        }
    }
    
    public void newRegistro(){
        for(int i =0;i<cantidadPersonas;i++){
        cliente[i] = controlador.retornarCliente(i);
        controlador.newRegistroEstadia(cliente[i],habitacion,jornadaText);
        }
    }
    
    public void SetHabitacionOcupada(){
        controlador.SethabitacionOcupada(habitacion);
    }
        
}

    
