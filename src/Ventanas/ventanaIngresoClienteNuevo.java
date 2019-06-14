
package Ventanas;

import Controlador.controlador;
import Modelo.ClienteVO;
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


public class ventanaIngresoClienteNuevo implements ActionListener{

    private ventanaPrincipal ventanaPrincipal;
    private JFrame ventana;
    private JLabel ingreso_cliente;
    private JLabel cliente_rut;
    private JLabel cliente_nombre;
    private JLabel cliente_apellido_p;
    private JLabel cliente_apellido_m;
    private JLabel sexo;
    private JLabel fecha_nacimiento;
    private JLabel nacionalidad;
    private JRadioButton sexo_Masculino;
    private JRadioButton sexo_Femenino;
    private JTextField cliente_rutText;
    private JTextField cliente_nombreText;
    private JTextField cliente_apellido_pText;
    private JTextField cliente_apellido_mText;
    private JTextField fecha_nacimientoText;
    private JTextField nacionalidadText;
    private JButton cancelar;
    private JButton registrar;
    private JPanel panelRut;
    private ButtonGroup bg;
    private String rutText;
    private ventanaIngresoRut ventanaIngresoRut;
    private ventanaSeleccionHabitacion ventanaSeleccionHabitacion;
    private ClienteVO cliente;
    
    public ventanaIngresoClienteNuevo(ventanaPrincipal C, JTextField rut,ventanaIngresoRut r ){
        this.ventanaIngresoRut = r;
        
        rutText=rut.getText();
        initVentana();
        initClienteNuevo();
        this.ventanaPrincipal = C;
    }
    public void initVentana (){
        ventana = new JFrame("HOTEL OPENMIND");
        ventana.setBounds(500,200,800,600);
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    private void initClienteNuevo(){
        panelRut = new JPanel();
        panelRut.setBackground(Color.pink);
        panelRut.setLayout(null);
        cancelar=new JButton("Cancelar");
	registrar=new JButton("Registrar");
        ingreso_cliente=new JLabel("Datos del Cliente");
        cliente_rut=new JLabel("RUT : ");
        cliente_nombre=new JLabel("Nombre : ");
        cliente_apellido_p=new JLabel("Apellido Paterno : ");
        cliente_apellido_m=new JLabel("Apellido Materno : ");
        sexo=new JLabel("Sexo : ");
        fecha_nacimiento=new JLabel("Fecha de nacimiento: ");
        nacionalidad=new JLabel("Nacionalidad: ");
        cliente_rutText=new JTextField(rutText);
        cliente_nombreText=new JTextField ();
        cliente_apellido_pText=new JTextField ();
        cliente_apellido_mText=new JTextField ();
        fecha_nacimientoText=new JTextField();
        nacionalidadText=new JTextField();
        sexo_Masculino = new JRadioButton("Masculino");
        sexo_Femenino = new JRadioButton("Femenino");
        
        bg = new ButtonGroup();
        bg.add(sexo_Femenino);
        bg.add(sexo_Masculino);
        
        
        ingreso_cliente.setBounds(310, 30, 250, 50);
        ingreso_cliente.setFont(ingreso_cliente.getFont().deriveFont(22.0f));
        cliente_rut.setBounds(220,100,220,50);
        cliente_rut.setFont(cliente_rut.getFont().deriveFont(16.0f));
        cliente_rutText.setBounds(400,115,220,20); 
        cliente_rutText.setFont(cliente_rutText.getFont().deriveFont(16.0f));
        cliente_nombre.setBounds(220,130,220,50);    
        cliente_nombre.setFont(cliente_nombre.getFont().deriveFont(16.0f));
        cliente_nombreText.setBounds(400,145,220,20);  
        cliente_nombreText.setFont(cliente_nombreText.getFont().deriveFont(16.0f));
        cliente_apellido_p.setBounds(220,160,220,50);  
        cliente_apellido_p.setFont(cliente_apellido_p.getFont().deriveFont(16.0f));
        cliente_apellido_pText.setBounds(400,175,220,20);
        cliente_apellido_pText.setFont(cliente_apellido_pText.getFont().deriveFont(16.0f));
        cliente_apellido_m.setBounds(220,190,220,50);    
        cliente_apellido_m.setFont(cliente_apellido_m.getFont().deriveFont(16.0f));
        cliente_apellido_mText.setBounds(400,205,220,20);
        cliente_apellido_mText.setFont(cliente_apellido_mText.getFont().deriveFont(16.0f));
        sexo.setBounds(220,235,220,20);
        sexo.setFont(sexo.getFont().deriveFont(16.0f));
        sexo_Masculino.setBounds(400,235,120,20);
        sexo_Masculino.setFont(sexo_Masculino.getFont().deriveFont(16.0f));
        sexo_Femenino.setBounds(550,235,120,20);
        sexo_Femenino.setFont(sexo_Femenino.getFont().deriveFont(16.0f));
        fecha_nacimiento.setBounds(220,250,220,50);   
        fecha_nacimiento.setFont(fecha_nacimiento.getFont().deriveFont(16.0f));
        fecha_nacimientoText.setBounds(400,265,220,20);
        fecha_nacimientoText.setFont(fecha_nacimientoText.getFont().deriveFont(16.0f));
        nacionalidad.setBounds(220,280,220,50);      
        nacionalidad.setFont(nacionalidad.getFont().deriveFont(16.0f));
        nacionalidadText.setBounds(400,295,220,20);
        nacionalidadText.setFont(nacionalidadText.getFont().deriveFont(16.0f));
        cancelar.setBounds(160,360,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        registrar.setBounds(410,360,220,100);
        registrar.setFont(registrar.getFont().deriveFont(16.0f));
        
        cancelar.addActionListener(this);
        registrar.addActionListener(this);
        
        panelRut.add(ingreso_cliente);
        panelRut.add(cliente_rut);
        panelRut.add(cliente_rutText);
        panelRut.add(cliente_nombre);
        panelRut.add(cliente_nombreText);
        panelRut.add(cliente_apellido_p);
        panelRut.add(cliente_apellido_pText);
        panelRut.add(cliente_apellido_m);
        panelRut.add(cliente_apellido_mText);
        panelRut.add(sexo);
        panelRut.add(sexo_Masculino);
        panelRut.add(sexo_Femenino);
        panelRut.add(fecha_nacimiento);
        panelRut.add(fecha_nacimientoText);
        panelRut.add(nacionalidad);
        panelRut.add(nacionalidadText);
        panelRut.add(cancelar);
        panelRut.add(registrar); 
        
        ventana.add(panelRut);
        ventana.validate();
    }   
    void setVisibleIngresoClienteNuevo(boolean b,String rut) {
        cliente_rutText.setText(rutText);
        setTextIngresoClienteNuevo();
        ventana.setVisible(b);
     }
    
    void setTextIngresoClienteNuevo (){
    cliente_nombreText.setText("");
    cliente_apellido_pText.setText("");
    cliente_apellido_mText.setText("");
    fecha_nacimientoText.setText("");
    nacionalidadText.setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    JButton source = (JButton)e.getSource();
        if(source.equals(cancelar)){
            ventana.setVisible(false);
            ventanaPrincipal.setVisibleVentanaPrincipal(true);
        }else if(source.equals(registrar)){
            controlador.sumadorMasUno();
            cliente = new ClienteVO(cliente_rutText.getText(),cliente_nombreText.getText(),cliente_apellido_pText.getText(),cliente_apellido_mText.getText(),returnSexo(),fecha_nacimientoText.getText(),nacionalidadText.getText());
            controlador.PasarCliente(cliente);
            controlador.RegistrarCliente(cliente);
            if(controlador.getComparador()==controlador.getSumador()){
                ventana.setVisible(false);
                ventanaSeleccionHabitacion = new ventanaSeleccionHabitacion(ventanaPrincipal);
            
            }else{
                ventana.setVisible(false);
                ventanaIngresoRut.setVisibleIngresoRut(true);
            }
        }

        }
  
    public String returnSexo(){
        if(sexo_Femenino.isSelected()){
            return "Mujer";
        }else if(sexo_Masculino.isSelected()){
            return "Hombre";
        }
        return null;
    }
}
