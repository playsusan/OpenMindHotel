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
import javax.swing.JTextField;

public class ventanaPedidos implements ActionListener{
	
	private JFrame ventana;
	private ventanaPrincipal ventanaPrincipal;
        private HabitacionVO habitacion;
	
	private JLabel titulo;
	private JLabel P1cocacola;
	private JLabel P2chocolate;
	private JLabel P3caramelolimon;
	private JLabel P4dulces;
	private JLabel P5paila;
	private JLabel P6chupilca;
	private JLabel P7sopamakako;
	private JLabel P8cervezaaustral;
	private JLabel P9cervezaroyal;
	private JLabel P10vinogato;
	private JLabel P11vinosantarita;
	private JLabel P12vinosantahelena;
	private JLabel P13ropahombre;
	private JLabel P14ropamujer;
	private JLabel P15juguetessex;
	private JLabel P16inflable;
	private JLabel P17latigo;
	private JLabel P18condonesK;
	private JLabel P19w40;
	private JLabel P20esposas;
	
	private JTextField P1cocacolaText;
	private JTextField P2chocolateText;
	private JTextField P3caramelolimonText;
	private JTextField P4dulcesText;
	private JTextField P5pailaText;
	private JTextField P6chupilcaText;
	private JTextField P7sopamakakoText;
	private JTextField P8cervezaaustralText;
	private JTextField P9cervezaroyalText;
	private JTextField P10vinogatoText;
	private JTextField P11vinosantaritaText;
	private JTextField P12vinosantahelenaText;
	private JTextField P13ropahombreText;
	private JTextField P14ropamujerText;
	private JTextField P15juguetessexText;
	private JTextField P16inflableText;
	private JTextField P17latigoText;
	private JTextField P18condonesKText;
	private JTextField P19w40Text;
	private JTextField P20esposasText;
	
	private JLabel P1cocacolaStock;
	private JLabel P2chocolateStock;
	private JLabel P3caramelolimonStock;
	private JLabel P4dulcesStock;
	private JLabel P5pailaStock;
	private JLabel P6chupilcaStock;
	private JLabel P7sopamakakoStock;
	private JLabel P8cervezaaustralStock;
	private JLabel P9cervezaroyalStock;
	private JLabel P10vinogatoStock;
	private JLabel P11vinosantaritaStock;
	private JLabel P12vinosantahelenaStock;
	private JLabel P13ropahombreStock;
	private JLabel P14ropamujerStock;
	private JLabel P15juguetessexStock;
	private JLabel P16inflableStock;
	private JLabel P17latigoStock;
	private JLabel P18condonesKStock;
	private JLabel P19w40Stock;
	private JLabel P20esposasStock;
        private controlador controlador;
	
    private JButton cancelar;
    private JButton aceptarpedido;
    private JPanel panelProductos;
    
    private ventanaPedidosBoleta ventanaPedidosBoleta;

    
    public ventanaPedidos(ventanaPrincipal P, HabitacionVO habitacion) {
            this.habitacion = habitacion;
            initVentana();
	    initProductos();
	    this.ventanaPrincipal = P;
	}
	

	public void initVentana (){
	   ventana = new JFrame("HOTEL OPENMIND");
	   ventana.setBounds(500,200,800,600);
	   ventana.setResizable(false);
	   ventana.setVisible(true);
	   ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    private void initProductos(){
    	panelProductos = new JPanel(null); //gridlayoud
    	panelProductos.setBackground(Color.pink);
    	panelProductos.setLayout(null);
    	
    	cancelar=new JButton("Cancelar");
    	aceptarpedido=new JButton("Ingresar pedido");
    	
    	titulo=new JLabel("LISTA DE PRODUCTOS");
    	
    	P1cocacola=new JLabel("Lata de Coca Cola:");
    	P2chocolate=new JLabel("Chocolate 400mg:");
    	P3caramelolimon=new JLabel("Caramelos de Limon:");
    	P4dulces=new JLabel("Dulces Surtidos:");
    	P5paila=new JLabel("Paila Marina:");
    	P6chupilca=new JLabel("Chupilca del Diablo:");
    	P7sopamakako=new JLabel("Sopa do makako:");
    	P8cervezaaustral=new JLabel("Cerveza Austral:");
    	P9cervezaroyal=new JLabel("Cerveza Royal:");
    	P10vinogato=new JLabel("Vino Gato:");
    	P11vinosantarita=new JLabel("Vino Santa Rita:");
    	P12vinosantahelena=new JLabel("Vino Santa Helena:");
    	P13ropahombre=new JLabel("Ropa interior hombre:");
    	P14ropamujer=new JLabel("Ropa interior mujer:");
    	P15juguetessex=new JLabel("Juguetes Sexuales:");
    	P16inflable=new JLabel("Muñeca Inflable:");
    	P17latigo=new JLabel("Latigo de Juguete:");
    	P18condonesK=new JLabel("Condones Kingdome:");
    	P19w40=new JLabel("Lubric. Sexual W40:");
    	P20esposas=new JLabel("Esposas de Juguete:");
    	
    	P1cocacolaText=new JTextField ();
    	P2chocolateText=new JTextField ();
    	P3caramelolimonText=new JTextField ();
    	P4dulcesText=new JTextField ();
    	P5pailaText=new JTextField ();
    	P6chupilcaText=new JTextField ();
    	P7sopamakakoText=new JTextField ();
    	P8cervezaaustralText=new JTextField ();
    	P9cervezaroyalText=new JTextField ();
    	P10vinogatoText=new JTextField ();
    	P11vinosantaritaText=new JTextField ();
    	P12vinosantahelenaText=new JTextField ();
    	P13ropahombreText=new JTextField ();
    	P14ropamujerText=new JTextField ();
    	P15juguetessexText=new JTextField ();
    	P16inflableText=new JTextField ();
    	P17latigoText=new JTextField ();
    	P18condonesKText=new JTextField ();
    	P19w40Text=new JTextField ();
    	P20esposasText=new JTextField ();
        
        P1cocacolaStock=new JLabel ();
    	P2chocolateStock=new JLabel ();
    	P3caramelolimonStock=new JLabel ();
    	P4dulcesStock=new JLabel ();
    	P5pailaStock=new JLabel ();
    	P6chupilcaStock=new JLabel ();
    	P7sopamakakoStock=new JLabel ();
    	P8cervezaaustralStock=new JLabel ();
    	P9cervezaroyalStock=new JLabel ();
    	P10vinogatoStock=new JLabel ();
    	P11vinosantaritaStock=new JLabel ();
    	P12vinosantahelenaStock=new JLabel ();
    	P13ropahombreStock=new JLabel ();
    	P14ropamujerStock=new JLabel ();
    	P15juguetessexStock=new JLabel ();
    	P16inflableStock=new JLabel ();
    	P17latigoStock=new JLabel ();
    	P18condonesKStock=new JLabel ();
    	P19w40Stock=new JLabel ();
    	P20esposasStock=new JLabel ();
        
        setTextPedidoNuevo ();
        setStock();
        
    	
        titulo.setBounds(300, -65, 300, 200);
        titulo.setFont(titulo.getFont().deriveFont(22.0f));
    	
    	P1cocacola.setBounds(120,50,220,50);
    	P1cocacola.setFont(P1cocacola.getFont().deriveFont(16.0f));
    	P1cocacolaText.setBounds(290,65,50,20); 
    	P1cocacolaText.setFont(P1cocacolaText.getFont().deriveFont(16.0f));
    	P1cocacolaStock.setBounds(350,50,220,50);
    	P1cocacolaStock.setFont(P1cocacolaStock.getFont().deriveFont(12.0f));
    	
    	P2chocolate.setBounds(120,80,220,50);
    	P2chocolate.setFont(P2chocolate.getFont().deriveFont(16.0f));
    	P2chocolateText.setBounds(290,95,50,20); 
    	P2chocolateText.setFont(P2chocolateText.getFont().deriveFont(16.0f));
    	P2chocolateStock.setBounds(350,80,220,50);
    	P2chocolateStock.setFont(P2chocolateStock.getFont().deriveFont(12.0f));
        
    	P3caramelolimon.setBounds(120,110,220,50);
    	P3caramelolimon.setFont(P3caramelolimon.getFont().deriveFont(16.0f));
    	P3caramelolimonText.setBounds(290,125,50,20); 
    	P3caramelolimonText.setFont(P3caramelolimonText.getFont().deriveFont(16.0f));
    	P3caramelolimonStock.setBounds(350,110,220,50);
    	P3caramelolimonStock.setFont(P3caramelolimonStock.getFont().deriveFont(12.0f));
        
    	P4dulces.setBounds(120,140,220,50);
    	P4dulces.setFont(P4dulces.getFont().deriveFont(16.0f));
    	P4dulcesText.setBounds(290,155,50,20); 
    	P4dulcesText.setFont(P4dulcesText.getFont().deriveFont(16.0f));
    	P4dulcesStock.setBounds(350,140,220,50); 
    	P4dulcesStock.setFont(P4dulcesStock.getFont().deriveFont(12.0f));
        
    	P5paila.setBounds(120,170,220,50);
    	P5paila.setFont(P5paila.getFont().deriveFont(16.0f));
    	P5pailaText.setBounds(290,185,50,20); 
    	P5pailaText.setFont(P5pailaText.getFont().deriveFont(16.0f));
    	P5pailaStock.setBounds(350,170,220,50); 
    	P5pailaStock.setFont(P5pailaStock.getFont().deriveFont(12.0f));
        
    	P6chupilca.setBounds(120,250,220,50);
    	P6chupilca.setFont(P6chupilca.getFont().deriveFont(16.0f));
    	P6chupilcaText.setBounds(290,265,50,20); 
    	P6chupilcaText.setFont(P6chupilcaText.getFont().deriveFont(16.0f));
    	P6chupilcaStock.setBounds(350,250,220,50); 
    	P6chupilcaStock.setFont(P6chupilcaStock.getFont().deriveFont(12.0f));
        
    	P7sopamakako.setBounds(120,280,220,50);
    	P7sopamakako.setFont(P7sopamakako.getFont().deriveFont(16.0f));
    	P7sopamakakoText.setBounds(290,295,50,20); 
    	P7sopamakakoText.setFont(P7sopamakakoText.getFont().deriveFont(16.0f));
    	P7sopamakakoStock.setBounds(350,280,220,50); 
    	P7sopamakakoStock.setFont(P7sopamakakoStock.getFont().deriveFont(12.0f));
    	
    	P8cervezaaustral.setBounds(120,310,220,50);
    	P8cervezaaustral.setFont(P8cervezaaustral.getFont().deriveFont(16.0f));
    	P8cervezaaustralText.setBounds(290,325,50,20); 
    	P8cervezaaustralText.setFont(P8cervezaaustralText.getFont().deriveFont(16.0f));
    	P8cervezaaustralStock.setBounds(350,310,220,50); 
    	P8cervezaaustralStock.setFont(P8cervezaaustralStock.getFont().deriveFont(12.0f));
        
    	P9cervezaroyal.setBounds(120,340,220,50);
    	P9cervezaroyal.setFont(P9cervezaroyal.getFont().deriveFont(16.0f));
    	P9cervezaroyalText.setBounds(290,355,50,20); 
    	P9cervezaroyalText.setFont(P9cervezaroyalText.getFont().deriveFont(16.0f));
    	P9cervezaroyalStock.setBounds(350,340,220,50); 
    	P9cervezaroyalStock.setFont(P9cervezaroyalStock.getFont().deriveFont(12.0f));
        
    	P10vinogato.setBounds(120,370,220,50);
    	P10vinogato.setFont(P10vinogato.getFont().deriveFont(16.0f));
    	P10vinogatoText.setBounds(290,385,50,20); 
    	P10vinogatoText.setFont(P10vinogatoText.getFont().deriveFont(16.0f));
    	P10vinogatoStock.setBounds(350,370,220,50); 
    	P10vinogatoStock.setFont(P10vinogatoStock.getFont().deriveFont(12.0f));
        
    	P11vinosantarita.setBounds(450,50,220,50);            
    	P11vinosantarita.setFont(P11vinosantarita.getFont().deriveFont(16.0f));
    	P11vinosantaritaText.setBounds(620,65,50,20); 
    	P11vinosantaritaText.setFont(P11vinosantaritaText.getFont().deriveFont(16.0f));
    	P11vinosantaritaStock.setBounds(680,50,220,50); 
    	P11vinosantaritaStock.setFont(P11vinosantaritaStock.getFont().deriveFont(12.0f));
    	
    	P12vinosantahelena.setBounds(450,80,220,50);
    	P12vinosantahelena.setFont(P12vinosantahelena.getFont().deriveFont(16.0f));
    	P12vinosantahelenaText.setBounds(620,95,50,20); 
    	P12vinosantahelenaText.setFont(P12vinosantahelenaText.getFont().deriveFont(16.0f));
    	P12vinosantahelenaStock.setBounds(680,80,220,50); 
    	P12vinosantahelenaStock.setFont(P12vinosantahelenaStock.getFont().deriveFont(12.0f));
        
    	P13ropahombre.setBounds(450,110,220,50);
    	P13ropahombre.setFont(P13ropahombre.getFont().deriveFont(16.0f));
    	P13ropahombreText.setBounds(620,125,50,20); 
    	P13ropahombreText.setFont(P13ropahombreText.getFont().deriveFont(16.0f));
    	P13ropahombreStock.setBounds(680,110,220,50); 
    	P13ropahombreStock.setFont(P13ropahombreStock.getFont().deriveFont(12.0f));
        
    	P14ropamujer.setBounds(450,140,220,50);
    	P14ropamujer.setFont(P14ropamujer.getFont().deriveFont(16.0f));
    	P14ropamujerText.setBounds(620,155,50,20); 
    	P14ropamujerText.setFont(P14ropamujerText.getFont().deriveFont(16.0f));
    	P14ropamujerStock.setBounds(680,140,220,50); 
    	P14ropamujerStock.setFont(P14ropamujerStock.getFont().deriveFont(12.0f));
        
    	P15juguetessex.setBounds(450,170,220,50);
    	P15juguetessex.setFont(P15juguetessex.getFont().deriveFont(16.0f));
    	P15juguetessexText.setBounds(620,185,50,20); 
    	P15juguetessexText.setFont(P15juguetessexText.getFont().deriveFont(16.0f));
    	P15juguetessexStock.setBounds(680,170,220,50); 
    	P15juguetessexStock.setFont(P15juguetessexStock.getFont().deriveFont(12.0f));
    	
    	P16inflable.setBounds(450,250,220,50);
    	P16inflable.setFont(P16inflable.getFont().deriveFont(16.0f));
    	P16inflableText.setBounds(620,265,50,20); 
    	P16inflableText.setFont(P16inflableText.getFont().deriveFont(16.0f));
    	P16inflableStock.setBounds(680,250,220,50); 
    	P16inflableStock.setFont(P16inflableStock.getFont().deriveFont(12.0f));
        
    	P17latigo.setBounds(450,280,220,50);
    	P17latigo.setFont(P17latigo.getFont().deriveFont(16.0f));
    	P17latigoText.setBounds(620,295,50,20); 
    	P17latigoText.setFont(P17latigoText.getFont().deriveFont(16.0f));
    	P17latigoStock.setBounds(680,280,220,50); 
    	P17latigoStock.setFont(P17latigoStock.getFont().deriveFont(12.0f));
        
    	P18condonesK.setBounds(450,310,220,50);
    	P18condonesK.setFont(P18condonesK.getFont().deriveFont(16.0f));
    	P18condonesKText.setBounds(620,325,50,20); 
    	P18condonesKText.setFont(P18condonesKText.getFont().deriveFont(16.0f));
    	P18condonesKStock.setBounds(680,310,220,50); 
    	P18condonesKStock.setFont(P18condonesKStock.getFont().deriveFont(12.0f));
        
    	P19w40.setBounds(450,340,220,50);
    	P19w40.setFont(P19w40.getFont().deriveFont(16.0f));
    	P19w40Text.setBounds(620,355,50,20); 
    	P19w40Text.setFont(P19w40Text.getFont().deriveFont(16.0f));
    	P19w40Stock.setBounds(680,340,220,50); 
    	P19w40Stock.setFont(P19w40Stock.getFont().deriveFont(12.0f));
        
    	P20esposas.setBounds(450,370,220,50);
    	P20esposas.setFont(P20esposas.getFont().deriveFont(16.0f));
    	P20esposasText.setBounds(620,385,50,20); 
    	P20esposasText.setFont(P20esposasText.getFont().deriveFont(16.0f));
    	P20esposasStock.setBounds(680,370,220,50); 
    	P20esposasStock.setFont(P20esposasStock.getFont().deriveFont(12.0f));
    	
        cancelar.setBounds(160,450,220,100);
        cancelar.setFont(cancelar.getFont().deriveFont(16.0f));
        aceptarpedido.setBounds(410,450,220,100);
        aceptarpedido.setFont(aceptarpedido.getFont().deriveFont(16.0f));
    	
    	
        cancelar.addActionListener(this);
        aceptarpedido.addActionListener(this);
        
        panelProductos.add(cancelar);
        panelProductos.add(aceptarpedido);
        
        panelProductos.add(titulo);
        panelProductos.add(P1cocacola);
        panelProductos.add(P1cocacolaText);
        panelProductos.add(P1cocacolaStock);
        panelProductos.add(P2chocolate);
        panelProductos.add(P2chocolateText);
        panelProductos.add(P2chocolateStock);
        panelProductos.add(P3caramelolimon);
        panelProductos.add(P3caramelolimonText);
        panelProductos.add(P3caramelolimonStock);
        panelProductos.add(P4dulces);
        panelProductos.add(P4dulcesText);
        panelProductos.add(P4dulcesStock);
        panelProductos.add(P5paila);
        panelProductos.add(P5pailaText);
        panelProductos.add(P5pailaStock);
        panelProductos.add(P6chupilca);
        panelProductos.add(P6chupilcaText);
        panelProductos.add(P6chupilcaStock);
        panelProductos.add(P7sopamakako);
        panelProductos.add(P7sopamakakoText);
        panelProductos.add(P7sopamakakoStock);
        panelProductos.add(P8cervezaaustral);
        panelProductos.add(P8cervezaaustralText);
        panelProductos.add(P8cervezaaustralStock);
        panelProductos.add(P9cervezaroyal);
        panelProductos.add(P9cervezaroyalText);
        panelProductos.add(P9cervezaroyalStock);
        panelProductos.add(P10vinogato);
        panelProductos.add(P10vinogatoText);
        panelProductos.add(P10vinogatoStock);
        panelProductos.add(P11vinosantarita);
        panelProductos.add(P11vinosantaritaText);
        panelProductos.add(P11vinosantaritaStock);
        panelProductos.add(P12vinosantahelena);
        panelProductos.add(P12vinosantahelenaText);
        panelProductos.add(P12vinosantahelenaStock);
        panelProductos.add(P13ropahombre);
        panelProductos.add(P13ropahombreText);
        panelProductos.add(P13ropahombreStock);
        panelProductos.add(P14ropamujer);
        panelProductos.add(P14ropamujerText);
        panelProductos.add(P14ropamujerStock);
        panelProductos.add(P15juguetessex);
        panelProductos.add(P15juguetessexText);
        panelProductos.add(P15juguetessexStock);
        panelProductos.add(P16inflable);
        panelProductos.add(P16inflableText);
        panelProductos.add(P16inflableStock);
        panelProductos.add(P17latigo);
        panelProductos.add(P17latigoText);
        panelProductos.add(P17latigoStock);
        panelProductos.add(P18condonesK);
        panelProductos.add(P18condonesKText);
        panelProductos.add(P18condonesKStock);
        panelProductos.add(P19w40);
        panelProductos.add(P19w40Text);
        panelProductos.add(P19w40Stock);
        panelProductos.add(P20esposas);
        panelProductos.add(P20esposasText);
        panelProductos.add(P20esposasStock);    


     //   panelProductos.add();
     //   panelProductos.add();
        
        ventana.add(panelProductos);
        ventana.validate();
    	}
    
        void setVisible(boolean b) {
            setTextPedidoNuevo ();
            ventana.setVisible(b);
        }
        
        void setTextPedidoNuevo (){
            	
            	P1cocacolaText.setText("0");
            	P2chocolateText.setText("0");
            	P3caramelolimonText.setText("0");
            	P4dulcesText.setText("0");
            	P5pailaText.setText("0");
            	P6chupilcaText.setText("0");
            	P7sopamakakoText.setText("0");
            	P8cervezaaustralText.setText("0");
            	P9cervezaroyalText.setText("0");
            	P10vinogatoText.setText("0");
            	P11vinosantaritaText.setText("0");
            	P12vinosantahelenaText.setText("0");
            	P13ropahombreText.setText("0");
            	P14ropamujerText.setText("0");
            	P15juguetessexText.setText("0");
            	P16inflableText.setText("0");
            	P17latigoText.setText("0");
            	P18condonesKText.setText("0");;
            	P19w40Text.setText("0");
            	P20esposasText.setText("0");

        }	
        public void setStock(){
            
                
            P1cocacolaStock.setText("Stock "+controlador.obtenerStock(1));
            P2chocolateStock.setText("Stock "+controlador.obtenerStock(2));
            P3caramelolimonStock.setText("Stock "+controlador.obtenerStock(3));
            P4dulcesStock.setText("Stock "+controlador.obtenerStock(4));
            P5pailaStock.setText("Stock "+controlador.obtenerStock(5));
            P6chupilcaStock.setText("Stock "+controlador.obtenerStock(6));
            P7sopamakakoStock.setText("Stock "+controlador.obtenerStock(7));
            P8cervezaaustralStock.setText("Stock "+controlador.obtenerStock(8));
            P9cervezaroyalStock.setText("Stock "+controlador.obtenerStock(9));
            P10vinogatoStock.setText("Stock "+controlador.obtenerStock(10));
            P11vinosantaritaStock.setText("Stock "+controlador.obtenerStock(11));
            P12vinosantahelenaStock.setText("Stock "+controlador.obtenerStock(12));
            P13ropahombreStock.setText("Stock "+controlador.obtenerStock(13));
            P14ropamujerStock.setText("Stock "+controlador.obtenerStock(14));
            P15juguetessexStock.setText("Stock "+controlador.obtenerStock(15));
            P16inflableStock.setText("Stock "+controlador.obtenerStock(16));
            P17latigoStock.setText("Stock "+controlador.obtenerStock(17));
            P18condonesKStock.setText("Stock "+controlador.obtenerStock(18));
            P19w40Stock.setText("Stock "+controlador.obtenerStock(19));
            P20esposasStock.setText("Stock "+controlador.obtenerStock(20));
        }
        
        public String mandarCantidad(){
            
            String data = P1cocacolaText.getText()+"#"+P2chocolateText.getText()+"#"+P3caramelolimonText.getText()+"#"+P4dulcesText.getText()+"#"+	P5pailaText.getText()+"#"+
            	P6chupilcaText.getText()+"#"+P7sopamakakoText.getText()+"#"+P8cervezaaustralText.getText()+"#"+P9cervezaroyalText.getText()+"#"+P10vinogatoText.getText()+"#"+
            	P11vinosantaritaText.getText()+"#"+P12vinosantahelenaText.getText()+"#"+P13ropahombreText.getText()+"#"+P14ropamujerText.getText()+"#"+P15juguetessexText.getText()+"#"+
            	P16inflableText.getText()+"#"+P17latigoText.getText()+"#"+P18condonesKText.getText()+"#"+P19w40Text.getText()+"#"+P20esposasText.getText();
            return data;
        }
        
        public String mandarStock(){
            
            String data = controlador.obtenerStock(1)+"#"+controlador.obtenerStock(2)+"#"+controlador.obtenerStock(3)+"#"+controlador.obtenerStock(4)+"#"+controlador.obtenerStock(5)
            +"#"+controlador.obtenerStock(6)+"#"+controlador.obtenerStock(7)+"#"+controlador.obtenerStock(8)+"#"+controlador.obtenerStock(9)+"#"+controlador.obtenerStock(10)
            +"#"+controlador.obtenerStock(11)+"#"+controlador.obtenerStock(12)+"#"+controlador.obtenerStock(13)+"#"+controlador.obtenerStock(14)+"#"+controlador.obtenerStock(15)        
            +"#"+controlador.obtenerStock(16)+"#"+controlador.obtenerStock(17)+"#"+controlador.obtenerStock(18)+"#"+controlador.obtenerStock(19)+"#"+controlador.obtenerStock(20);                  
            return data;
        }
        
  
        @Override
        public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
            if(source.equals(cancelar)){
                ventana.setVisible(false);
                ventanaPrincipal.setVisibleVentanaPrincipal(true);
            }else if(source.equals(aceptarpedido)){
                String lista = mandarCantidad();
                String listaStock = mandarStock();
                controlador.realizarCalculoBoletaPedido(lista, listaStock,habitacion);
                String boleta = controlador.StringBoleta(lista);
                if(ventanaPedidosBoleta==null){
                    ventanaPedidosBoleta = new ventanaPedidosBoleta(ventanaPrincipal,boleta,habitacion);
                    ventana.setVisible(false);   
                }else{
                    ventana.setVisible(false);
                    ventanaPedidosBoleta.setVisible(true,boleta,habitacion);
                }
            }

            }      
        
}