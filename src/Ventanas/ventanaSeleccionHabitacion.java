
package Ventanas;

import Controlador.controlador;
import Modelo.HabitacionVO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ventanaSeleccionHabitacion implements ActionListener{
    private ventanaPrincipal ventanaPrincipal;
    private ventanaIngresoBoleta ventanaIngresoBoleta;
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
    private JRadioButton momento;
    private JRadioButton jornada;
    private JLabel seleccion_habitacion;
    private JLabel seleccion_jornada;
    private JLabel precio_momento;
    private JLabel precio_jornada;
    private JButton continuar;
    private JButton cancelar;
    private HabitacionVO[] habitacion;
    private controlador controlador;
    
    public ventanaSeleccionHabitacion(ventanaPrincipal C){
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
        seleccion_habitacion=new JLabel("Elija Habitacion ");
        seleccion_jornada=new JLabel ("Elija jornada");
        precio_momento=new JLabel ();
        precio_jornada=new JLabel ();
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
        momento = new JRadioButton("Momento:   $");
        jornada = new JRadioButton("Jornada:   $");
        
        SetAviability();
        setTextRAdioButton();
        
        ButtonGroup radioGroup = new ButtonGroup();
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
        
        ButtonGroup radioGroup2 = new ButtonGroup();
        radioGroup2.add(momento);
        radioGroup2.add(jornada);
        
        
        
        seleccion_habitacion.setBounds(330,10, 200, 50);
        seleccion_habitacion.setFont(seleccion_habitacion.getFont().deriveFont(16.0f));
        seleccion_jornada.setBounds(340,270, 200, 50);
        seleccion_jornada.setFont(seleccion_jornada.getFont().deriveFont(16.0f));
        precio_momento.setBounds(270,330, 100, 30);
        precio_momento.setFont(precio_momento.getFont().deriveFont(12.0f));
        precio_jornada.setBounds(520,330, 100, 30);
        precio_jornada.setFont(precio_jornada.getFont().deriveFont(12.0f));
        habitacion1.setBounds(160,70,220,30);
        habitacion2.setBounds(160,110,220,30);
        habitacion3.setBounds(160,150,220,30);
        habitacion4.setBounds(160,190,220,30);
        habitacion5.setBounds(160,230,220,30);
        habitacion6.setBounds(410,70,220,30);
        habitacion7.setBounds(410,110,220,30);
        habitacion8.setBounds(410,150,220,30);
        habitacion9.setBounds(410,190,220,30);
        habitacion10.setBounds(410,230,220,30);
        momento.setBounds(160,330,100,30);
        jornada.setBounds(410,330,100,30);
        cancelar.setBounds(160,420,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        continuar.setBounds(410,420,220,100);
        continuar.setFont(continuar.getFont().deriveFont(16.0f));
        
        habitacion1.addActionListener(this);
        habitacion2.addActionListener(this);
        habitacion3.addActionListener(this);
        habitacion4.addActionListener(this);
        habitacion5.addActionListener(this);
        habitacion6.addActionListener(this);
        habitacion7.addActionListener(this);
        habitacion8.addActionListener(this);
        habitacion9.addActionListener(this);
        habitacion10.addActionListener(this);
        cancelar.addActionListener(this);
        continuar.addActionListener(this);
        
        panel.add(seleccion_habitacion);
        panel.add(seleccion_jornada);
        panel.add(precio_momento);
        panel.add(precio_jornada);
        
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
        panel.add(momento);
        panel.add(jornada);
        panel.add(cancelar);
        panel.add(continuar); 
        
        ventana.add(panel);
        ventana.validate();
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(habitacion1.isSelected()){
            precio_momento.setText(""+habitacion[0].getPrecio_momento());
            precio_jornada.setText(""+habitacion[0].getPrecio_jornada());
        }
        if(habitacion2.isSelected()){
            precio_momento.setText(""+habitacion[1].getPrecio_momento());
            precio_jornada.setText(""+habitacion[1].getPrecio_jornada());
        }
        if(habitacion3.isSelected()){
            precio_momento.setText(""+habitacion[2].getPrecio_momento());
            precio_jornada.setText(""+habitacion[2].getPrecio_jornada());
        }
        if(habitacion4.isSelected()){
            precio_momento.setText(""+habitacion[3].getPrecio_momento());
            precio_jornada.setText(""+habitacion[3].getPrecio_jornada());
        }
        if(habitacion5.isSelected()){
            precio_momento.setText(""+habitacion[4].getPrecio_momento());
            precio_jornada.setText(""+habitacion[4].getPrecio_jornada());
        }
        if(habitacion6.isSelected()){
            precio_momento.setText(""+habitacion[5].getPrecio_momento());
            precio_jornada.setText(""+habitacion[5].getPrecio_jornada());
        }
        if(habitacion7.isSelected()){
            precio_momento.setText(""+habitacion[6].getPrecio_momento());
            precio_jornada.setText(""+habitacion[6].getPrecio_jornada());
        }
        if(habitacion8.isSelected()){
            precio_momento.setText(""+habitacion[7].getPrecio_momento());
            precio_jornada.setText(""+habitacion[7].getPrecio_jornada());
        }
        if(habitacion9.isSelected()){
            precio_momento.setText(""+habitacion[8].getPrecio_momento());
            precio_jornada.setText(""+habitacion[8].getPrecio_jornada());
        }
        if(habitacion10.isSelected()){
            precio_momento.setText(""+habitacion[9].getPrecio_momento());
            precio_jornada.setText(""+habitacion[9].getPrecio_jornada());
        }
        if(e.getSource().equals(cancelar)){
            ventana.setVisible(false);
            ventanaPrincipal.setVisibleVentanaPrincipal(true);
        }else if(e.getSource().equals(continuar)){
            ventana.setVisible(false);
                int v = ButtonPressed();
                int w = ButtonPressedJornada();
             
            if(ventanaIngresoBoleta==null){
                ventanaPrincipal.setVisibleVentanaPrincipal(false);
                ventanaIngresoBoleta = new ventanaIngresoBoleta(ventanaPrincipal, habitacion[v],w); 
            }
            else {
                ventanaIngresoBoleta.setNewBoleta(habitacion[v], w);
                ventanaIngresoBoleta.textAreaSetText();
                ventanaIngresoBoleta.newRegistro();
                ventanaIngresoBoleta.setVisible(true);
                
            }

        }
    }

    public void setVisible(boolean b) {
        SetAviability();
        ventana.setVisible(b);
    }
    
    public void GetHabitaciones(){
        habitacion = new HabitacionVO[10];
        for(int i = 0; i<10; i++){
            habitacion[i] = controlador.GetRoom(i);
            
        }
    }
    public void SetAviability(){
        GetHabitaciones();
        for(int i = 0; i<10; i++){
        
        int v = Integer.parseInt(habitacion[i].getDisponibilidad());
        if(v==0 && i==0){
        habitacion1.setEnabled(true);
        }if(v==0 && i==1){
        habitacion2.setEnabled(true);
        }if(v==0 && i==2){
        habitacion3.setEnabled(true);
        }if(v==0 && i==3){
        habitacion4.setEnabled(true);
        }if(v==0 && i==4){
        habitacion5.setEnabled(true);
        }if(v==0 && i==5){
        habitacion6.setEnabled(true);
        }if(v==0 && i==6){
        habitacion7.setEnabled(true);
        }if(v==0 && i==7){
        habitacion8.setEnabled(true);
        }if(v==0 && i==8){
        habitacion9.setEnabled(true);
        }if(v==0 && i==9){
        habitacion10.setEnabled(true);
        }else if(v==1 && i==0){
        habitacion1.setEnabled(false);
        }else if(v==1 && i==1){
        habitacion2.setEnabled(false);
        }else if(v==1 && i==2){
        habitacion3.setEnabled(false);
        }else if(v==1 && i==3){
        habitacion4.setEnabled(false);
        }else if(v==1 && i==4){
        habitacion5.setEnabled(false);
        }else if(v==1 && i==5){
        habitacion6.setEnabled(false);
        }else if(v==1 && i==6){
        habitacion7.setEnabled(false);
        }else if(v==1 && i==7){
        habitacion8.setEnabled(false);
        }else if(v==1 && i==8){
        habitacion9.setEnabled(false);
        }else if(v==1 && i==9){
        habitacion10.setEnabled(false);
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
    public int ButtonPressedJornada(){
        int v=0;
        if(momento.isSelected()){
            v=0;
        }if(jornada.isSelected()){
            v=1;
        }
       return v;    
    }
    } 
    

