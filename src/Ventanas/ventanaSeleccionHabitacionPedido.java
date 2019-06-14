
package Ventanas;

import Controlador.controlador;
import Modelo.HabitacionVO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ventanaSeleccionHabitacionPedido implements ActionListener{
    
    private ventanaPrincipal ventanaPrincipal;
    private ventanaPedidos ventanaPedidos;
    private JFrame ventana;
    private JPanel panel;
    private JRadioButton habitacion1;
    private JRadioButton habitacion2;
    private JRadioButton habitacion3;
    private JRadioButton habitacion4;
    private JRadioButton habitacion5;
    private JRadioButton habitacion6;
    private JRadioButton habitacion7;
    private JRadioButton habitacion8;
    private JRadioButton habitacion9;
    private JRadioButton habitacion10;
    private HabitacionVO[] habitacion;
    private controlador controlador;
    private JLabel seleccion_habitacion;
    private JButton continuar;
    private JButton cancelar;
    private ButtonGroup radioGroup ;
    
    public ventanaSeleccionHabitacionPedido(ventanaPrincipal C){
        initVentana();
        initSeleccionHabitacion();
        this.ventanaPrincipal = C;
    }
        public void initVentana (){
        ventana = new JFrame("HOTEL OPENMIND");
        ventana.setBounds(500,200,800,600);
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
        private void initSeleccionHabitacion(){
        panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(null);
        cancelar=new JButton("Cancelar");
	continuar=new JButton("Continuar");
        seleccion_habitacion=new JLabel("Seleccione habitacion para el pedido");
        habitacion1 = new JRadioButton();
        habitacion2 = new JRadioButton();
        habitacion3 = new JRadioButton();
        habitacion4 = new JRadioButton();
        habitacion5 = new JRadioButton();
        habitacion6 = new JRadioButton();
        habitacion7 = new JRadioButton();
        habitacion8 = new JRadioButton();
        habitacion9 = new JRadioButton();
        habitacion10 = new JRadioButton();
        
        
        
        radioGroup = new ButtonGroup();
        radioGroup.add(habitacion1);
        radioGroup.add(habitacion2);
        radioGroup.add(habitacion3);
        radioGroup.add(habitacion4);
        radioGroup.add(habitacion5);
        radioGroup.add(habitacion6);
        radioGroup.add(habitacion7);
        radioGroup.add(habitacion8);
        radioGroup.add(habitacion9);
        radioGroup.add(habitacion10);
        
        GetHabitacionesPedidos();
        SetAviability();
        setTextRAdioButton();
        
        seleccion_habitacion.setBounds(260,10, 300, 50);
        seleccion_habitacion.setFont(seleccion_habitacion.getFont().deriveFont(16.0f));
        habitacion1.setBounds(160,100,220,30);
        habitacion2.setBounds(160,140,220,30);
        habitacion3.setBounds(160,180,220,30);
        habitacion4.setBounds(160,220,220,30);
        habitacion5.setBounds(160,260,220,30);
        habitacion6.setBounds(410,100,220,30);
        habitacion7.setBounds(410,140,220,30);
        habitacion8.setBounds(410,180,220,30);
        habitacion9.setBounds(410,220,220,30);
        habitacion10.setBounds(410,260,220,30);
        cancelar.setBounds(160,420,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        continuar.setBounds(410,420,220,100);
        continuar.setFont(continuar.getFont().deriveFont(16.0f));
        
        cancelar.addActionListener(this);
        continuar.addActionListener(this);
        
        panel.add(seleccion_habitacion);
        
        panel.add(habitacion1);
        panel.add(habitacion2);
        panel.add(habitacion3);
        panel.add(habitacion4);
        panel.add(habitacion5);
        panel.add(habitacion6);
        panel.add(habitacion7);
        panel.add(habitacion8);
        panel.add(habitacion9);
        panel.add(habitacion10);
        
        panel.add(cancelar);
        panel.add(continuar); 
        
        ventana.add(panel);
        ventana.validate();
    }   
    public void GetHabitacionesPedidos(){
        habitacion = new HabitacionVO[10];
        for(int i = 0; i<10; i++){
            habitacion[i] = controlador.GetRoom(i);
            
        }
    }
    public void setVisible(boolean b){
           SetAviability();
           ventana.setVisible(b);
       }
    public void SetAviability(){
            for(int i = 0; i<10; i++){

            int v = Integer.parseInt(habitacion[i].getDisponibilidad());
            if(v==0 && i==0){
            habitacion1.setEnabled(false);
            }if(v==0 && i==1){
            habitacion2.setEnabled(false);
            }if(v==0 && i==2){
            habitacion3.setEnabled(false);
            }if(v==0 && i==3){
            habitacion4.setEnabled(false);
            }if(v==0 && i==4){
            habitacion5.setEnabled(false);
            }if(v==0 && i==5){
            habitacion6.setEnabled(false);
            }if(v==0 && i==6){
            habitacion7.setEnabled(false);
            }if(v==0 && i==7){
            habitacion8.setEnabled(false);
            }if(v==0 && i==8){
            habitacion9.setEnabled(false);
            }if(v==0 && i==9){
            habitacion10.setEnabled(false);
            }else if(v==1 && i==0){
            habitacion1.setEnabled(true);
            }else if(v==1 && i==1){
            habitacion2.setEnabled(true);
            }else if(v==1 && i==2){
            habitacion3.setEnabled(true);
            }else if(v==1 && i==3){
            habitacion4.setEnabled(true);
            }else if(v==1 && i==4){
            habitacion5.setEnabled(true);
            }else if(v==1 && i==5){
            habitacion6.setEnabled(true);
            }else if(v==1 && i==6){
            habitacion7.setEnabled(true);
            }else if(v==1 && i==7){
            habitacion8.setEnabled(true);
            }else if(v==1 && i==8){
            habitacion9.setEnabled(true);
            }else if(v==1 && i==9){
            habitacion10.setEnabled(true);
            }   
            }   
        }
     public void setTextRAdioButton(){
        habitacion1.setText(habitacion[0].getNombre_habitacion());
        habitacion2.setText(habitacion[1].getNombre_habitacion());
        habitacion3.setText(habitacion[2].getNombre_habitacion());
        habitacion4.setText(habitacion[3].getNombre_habitacion());
        habitacion5.setText(habitacion[4].getNombre_habitacion());
        habitacion6.setText(habitacion[5].getNombre_habitacion());
        habitacion7.setText(habitacion[6].getNombre_habitacion());
        habitacion8.setText(habitacion[7].getNombre_habitacion());
        habitacion9.setText(habitacion[8].getNombre_habitacion());
        habitacion10.setText(habitacion[9].getNombre_habitacion());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       JButton source = (JButton)e.getSource();
        if(source.equals(cancelar)){
            ventana.setVisible(false);
            ventanaPrincipal.setVisibleVentanaPrincipal(true);
        }else if(source.equals(continuar)){
            ventana.setVisible(false);
             
            if(ventanaPedidos==null){
                int v = ButtonPressed();
                ventanaPrincipal.setVisibleVentanaPrincipal(false);
                ventanaPedidos = new ventanaPedidos(ventanaPrincipal, habitacion[v]); 
            }
            else {
                ventanaPedidos.setVisible(true);
            }

        }
        
    }
    public int ButtonPressed(){
        int v=0;
        if(habitacion1.isSelected()){
            v=0;
        }if(habitacion2.isSelected()){
            v=1;
        }if(habitacion3.isSelected()){
            v=2;
        }if(habitacion4.isSelected()){
            v=3;
        }if(habitacion5.isSelected()){
            v=4;
        }if(habitacion6.isSelected()){
            v=5;
        }if(habitacion7.isSelected()){
            v=6;
        }if(habitacion8.isSelected()){
            v=7;
        }if(habitacion9.isSelected()){
            v=8;
        }if(habitacion10.isSelected()){
            v=9;
        }
       return v;    
    }
    
}
