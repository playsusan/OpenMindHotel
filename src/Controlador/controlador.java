
package Controlador;

import Modelo.ClienteVO;
import Modelo.HabitacionVO;
import Modelo.ManagerDAO;
import Modelo.PedidoVO;
import Modelo.ProductoVO;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextField;



public class controlador {
    
    private static int comparador= 0; 
    private static int sumador = 0;
    private static ManagerDAO manager;
    private static ClienteVO cliente;
    private static PedidoVO pedido;
    private static ProductoVO producto;
    private static ClienteVO[] arregloClientes;
    private static PedidoVO[] arregloPedidos;
    private static String[] arregloProductos;
    
    private static int cont=0;
    
    public controlador(){
        arregloPedidos = new PedidoVO[50];
        arregloClientes = new ClienteVO[20];
        arregloProductos = new String[20];
        
    }
    public static ClienteVO getCliente(String rut){
        manager = ManagerDAO.obtenerInstancia();
      
        cliente = manager.obtenerCliente(rut);
        return cliente;
    }
    
    public static void setComparador(int c){
       
        comparador = c;
        sumador = 0;
        
    }
    
    public static void sumadorMasUno(){
        sumador = sumador + 1;
    }
    
    public static int getComparador(){
        return comparador;
    }
    
    public static int getSumador(){
        return sumador;
    }

    public static HabitacionVO GetRoom(int i) {
        i=i+1;  
        manager = ManagerDAO.obtenerInstancia();
        HabitacionVO v = manager.GetRoom(i);
        return v;
        
    }

    public static void setContCliente() {
        cont = 0;
    }

    public static void RegistrarCliente(ClienteVO clie) {
        cliente = clie;
        manager = ManagerDAO.obtenerInstancia();
        String textosql= "insert into clientes (clientesID,nombres,apellidoP,apellidoM,sexo,fecha_de_nacimiento,nacionalidad) values ('"+
                            cliente.getRut()+"','"+cliente.getNombre()+"','"+cliente.getApellido_p()+"','"+
                            cliente.getApellido_m()+"','"+cliente.getSexo()+"','"+cliente.getFechaNacimiento()+"','"+cliente.getNacionalidad()+"')";
        manager.RegistrarCliente(textosql);
    }

    public static ClienteVO returnCliente(String rut) {
        System.out.println("controlador.reutnrcliente: "+rut);
        manager = ManagerDAO.obtenerInstancia();
        System.out.println("controlador.reutnrcliente.manager: "+manager);
        cliente = manager.obtenerCliente(rut);
        System.out.println("Cliente :"+cliente.toString());
        return cliente;
       }
    
    public static int obtenerStock(int prodID){
       manager = ManagerDAO.obtenerInstancia();
        return  manager.obtenerStock(prodID);
    }
    
    public static String obtenerTipoJornada(HabitacionVO habitacion){
        return manager.obtenerTipoJornada(habitacion.getHabitacionID());
        
    }

    public static void realizarCalculoBoletaPedido(String lista, String listaStock, HabitacionVO habitacion) {
        String[] restas;
        String[] stock;
        
        
        restas = lista.split("#");
        stock = listaStock.split("#");

                for(int i=0; i<restas.length;i++){
                    int num = Integer.parseInt(restas[i]);
                    int numStock = Integer.parseInt(stock[i]);

                    if(num != 0){
                        int y = numStock-num;
                        manager.setStock(i+1, y);
                        SetPedido(habitacion, i+1, num);
                        
                    }
                }
             
         
    }
        
    
    public static String StringBoleta(String lista){
        String[] product=lista.split("#");
        String texto = "";
        int total=0;
        int sum;
        
           for(int i=0; i<product.length;i++){
            int num = Integer.parseInt(product[i]);
            if(num != 0){
                
                ProductoVO elemento = manager.getProducto(i+1);
                texto=texto + elemento.getNombre_producto() +"\nCantidad "+num+" Precio Unitario: $"+elemento.getPrecio_producto()+"\n";
                sum= num*elemento.getPrecio_producto();
                total = total+sum;
            }
            
        
         }
           texto=texto+"\n\n\n\n\n Total :      $"+total;
           return texto;
    }   

    public static void PasarCliente(ClienteVO clientes) {
        
        arregloClientes[cont] = clientes;
        System.out.println(arregloClientes[cont].toString());
        cont=cont+1;
        
    }
    
    
    public static ClienteVO retornarCliente(int i){
        return arregloClientes[i];
    }

    public static void newRegistroEstadia(ClienteVO clienteVO, HabitacionVO habitacion,String tipojornada) {
       
       manager = ManagerDAO.obtenerInstancia();
        String TextoSQL = "";
        
        TextoSQL = "insert into estadia (clientesID,habitacionID,pedidoID,tipo_jornada,fecha_ingreso) values ('"+
                            clienteVO.getRut()+"','"+habitacion.getHabitacionID()+"','"+"0"+"','"+
                            tipojornada+"','"+DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now())+"')";
        manager.newRegistroEstadia(TextoSQL);
    }

    public static void SethabitacionOcupada(HabitacionVO habitacion) {
        manager = ManagerDAO.obtenerInstancia();
        String TextoSQL="UPDATE habitacion  SET Disponibilidad = 1 where habitacionID="+habitacion.getHabitacionID();
        
        System.out.println(manager.SetHabitacionOcupada(TextoSQL));
    }

    public static void SetHabitacionLibre(HabitacionVO habitacionVO) {
         manager = ManagerDAO.obtenerInstancia();
        String TextoSQL="UPDATE habitacion  SET Disponibilidad = 0 where habitacionID="+habitacionVO.getHabitacionID();
        
        manager.SetHabitacionOcupada(TextoSQL);
    }

    public static String StringVentanaSalidaBoleta(HabitacionVO habitacion) {
        
        int cant=0;
        String textoFinal="";
        manager = ManagerDAO.obtenerInstancia();
        ArrayList clienteslista =   manager.ListaClientesHabitacion(habitacion.getHabitacionID());
         for(int i =0 ; i< clienteslista.size();i++){
             arregloClientes[i] = returnCliente(""+clienteslista.get(i));
             cant++;
         System.out.println(arregloClientes[i].toString());
         }
         textoFinal="Habitacion: "+habitacion.getHabitacionID()+"       "+habitacion.getNombre_habitacion()+"\n\n\n";
         for(int i=0;i<cant;i++){
             textoFinal=textoFinal +"Cliente:  "+arregloClientes[i].getRut()+"     Nombre:  "+arregloClientes[i].getNombre()+" "+arregloClientes[i].getApellido_p()+"\n";
                     
         }
         
        return textoFinal;
    }
    
    public static void SetPedido(HabitacionVO habitacion, int productoID, int suma)    {    
    
        manager = ManagerDAO.obtenerInstancia();
        String fechaIngreso = manager.ReturnFechaIngreso(habitacion.getHabitacionID());
        ArrayList productoLista =   manager.ListaProductosPorHabitacion(habitacion.getHabitacionID());
        ArrayList listaClientes = manager.ListaClientesHabitacion(habitacion.getHabitacionID());
        String tipoJor = obtenerTipoJornada(habitacion);
        boolean mismoProducto=true;
        int guardarArregloPedido=0;
         
        for(int i =0;i<listaClientes.size();i++){
            arregloClientes[i] = manager.obtenerCliente(""+listaClientes.get(i));
        }
        for(int i =0 ; i< productoLista.size();i++){
                String pedidoId = ""+productoLista.get(i);
                arregloPedidos[i] = manager.getPedido(pedidoId,habitacion);
                int comp = Integer.parseInt(arregloPedidos[i].getProductoID());
                 
                 if(comp == productoID){
                     mismoProducto = true;
                     guardarArregloPedido=i;
                     break;
                 }else{
                     mismoProducto = false;
                 }
        }
         if(mismoProducto==true){
                    int total = arregloPedidos[guardarArregloPedido].getCantidad_pedido()+suma;
                    arregloPedidos[guardarArregloPedido].setCantidad_pedido(total);
                    manager.modificarPedido(arregloPedidos[guardarArregloPedido]);
                    System.out.println(total);
        }else if(mismoProducto==false){
                    int newPedido = Integer.parseInt(manager.getLastPedido());
                    newPedido = newPedido+1;
                    
                    manager.CrearNuevoPedido(newPedido, productoID, suma);
                    for(int i =0;i<listaClientes.size();i++){
                        System.out.println(listaClientes.get(i));    
                    manager.CrearEstadiaPedido(arregloClientes[i].getRut(),habitacion,newPedido,tipoJor,fechaIngreso);
                    }
                }
             }

    public static String GetProductomasVendido() {
        manager = ManagerDAO.obtenerInstancia();
        ArrayList ProductoPrecio = manager.GetProductomasVendido();
        int productoid = Integer.parseInt(""+ProductoPrecio.get(0));
        int cantidad =Integer.parseInt(""+ProductoPrecio.get(1));
        ProductoVO objProducto = manager.getProducto(productoid);
        ArrayList productoCantidadPiezaMas   = manager.GetproductoCantidadPiezaMas(productoid);
        ArrayList productoCantidadPiezaMenos   = manager.GetproductoCantidadPiezaMenos(productoid);
        HabitacionVO habitacionMas = manager.GetRoom(Integer.parseInt(""+productoCantidadPiezaMas.get(1)));
        HabitacionVO habitacionMenos = manager.GetRoom(Integer.parseInt(""+productoCantidadPiezaMenos.get(1)));

        return "El producto mas vendido es: "+objProducto.getNombre_producto()+"\n\nPrecio Unitario del Producto: $"+objProducto.getPrecio_producto()+"\n\nCantidad total vendida del Producto: "+cantidad
                +"\nHabitacion donde fue mas Vendido: "+habitacionMas.getNombre_habitacion()+"\nCantidad Vendida : "+productoCantidadPiezaMas.get(0)+"\nHabitacion donde fue menos Vendido: "+habitacionMenos.getNombre_habitacion()+
                "\nCantidad Vendida : "+productoCantidadPiezaMenos.get(0)+"\n\n Total de ventas del Producto:    $"+(cantidad*objProducto.getPrecio_producto());
    }
    
    public static String GetProductomenosVendido() {
        manager = ManagerDAO.obtenerInstancia();
        ArrayList ProductoPrecio = manager.GetProductoMenosVendido();
        int productoid = Integer.parseInt(""+ProductoPrecio.get(0));
        int cantidad =Integer.parseInt(""+ProductoPrecio.get(1));
        ProductoVO objProducto = manager.getProducto(productoid);
        ArrayList productoCantidadPiezaMas   = manager.GetproductoCantidadPiezaMas(productoid);
        ArrayList productoCantidadPiezaMenos   = manager.GetproductoCantidadPiezaMenos(productoid);
        HabitacionVO habitacionMas = manager.GetRoom(Integer.parseInt(""+productoCantidadPiezaMas.get(1)));
        HabitacionVO habitacionMenos = manager.GetRoom(Integer.parseInt(""+productoCantidadPiezaMenos.get(1)));

        return "El producto mas vendido es: "+objProducto.getNombre_producto()+"\n\nPrecio Unitario del Producto: $"+objProducto.getPrecio_producto()+"\n\nCantidad total vendida del Producto: "+cantidad
                +"\nHabitacion donde fue mas Vendido: "+habitacionMas.getNombre_habitacion()+"\nCantidad Vendida : "+productoCantidadPiezaMas.get(0)+"\nHabitacion donde fue menos Vendido: "+habitacionMenos.getNombre_habitacion()+
                "\nCantidad Vendida : "+productoCantidadPiezaMenos.get(0)+"\n\n Total de ventas del Producto:    $"+(cantidad*objProducto.getPrecio_producto());
    }

    public static String GetHabitacionMenosUsada() {
        
        manager = ManagerDAO.obtenerInstancia();
        ArrayList HabitacionCantidad = manager.GetHabitacionMenosUsada();
        int habitacionid = Integer.parseInt(""+HabitacionCantidad.get(0));
        int cantidad =Integer.parseInt(""+HabitacionCantidad.get(1));
        HabitacionVO objHabitacion = manager.GetRoom(habitacionid);
        ArrayList clienteslista = manager.getListaFromRoom(habitacionid);
        ArrayList listaPeriodo = manager.getListaPeriodoFromRoom(habitacionid);
        System.out.println(listaPeriodo.get(0));
        producto = new ProductoVO();        
        int SumadorJornadaPrecio=0;
        
        int totalSUMA=0;
   
        for(int i=0;i<clienteslista.size();i++){
            arregloClientes[i] = manager.obtenerCliente(""+clienteslista.get(i));
        }
        String textofinal= "La Habitacion menos usada es :"+objHabitacion.getNombre_habitacion()+"\nVeces usada: "+cantidad+"\n\nUtilizada por el/los Cliente/s:\n" ;
        for(int i=0;i<clienteslista.size();i++){
            textofinal = textofinal + arregloClientes[i].getNombre()+" "+arregloClientes[i].getApellido_p()+"\n";
        }
        for(int i=0;i<listaPeriodo.size();i++){
            ArrayList PedidoIDList = manager.obtenerPedidoIDPeriodo(""+listaPeriodo.get(i));
            int cantidadDePersonas = manager.obtenerCantidadDePersonasPorPeriodo(""+listaPeriodo.get(i));
            String tipoJor = manager.obtenerTipoJornadaPorPeriodo(""+listaPeriodo.get(i));
            if(tipoJor.equals("Momento")){
                SumadorJornadaPrecio= SumadorJornadaPrecio + cantidadDePersonas*objHabitacion.getPrecio_momento();
            }if(tipoJor.equals("Completa")){
                SumadorJornadaPrecio= SumadorJornadaPrecio + cantidadDePersonas*objHabitacion.getPrecio_jornada();
            }
                
                
            
            textofinal = textofinal + "Perido: "+PedidoIDList.get(i)+"\n";
            for(int ii=1; ii<PedidoIDList.size();ii++){
                arregloPedidos[ii]=manager.getPedido(""+PedidoIDList.get(ii), objHabitacion);
                producto = manager.getProducto(Integer.parseInt(arregloPedidos[ii].getProductoID()));
                int SumaJornada = producto.getPrecio_producto() * arregloPedidos[ii].getCantidad_pedido();
                textofinal = textofinal + "\nPedido N°:"+arregloPedidos[ii].getPedidoID()+ " ID Producto: "+arregloPedidos[ii].getProductoID()+" cantidad: "+arregloPedidos[ii].getCantidad_pedido()+"       $"+SumaJornada;
                totalSUMA = totalSUMA+ SumaJornada;
            }

        }
            totalSUMA = totalSUMA + SumadorJornadaPrecio;
            textofinal= textofinal+"\n\n\nTotal Gastado en la Habitacion(Estadias y pedidos):  $"+totalSUMA;
        
        
        
        return textofinal;
    }
    
    public static String GetHabitacionMasUsada() {
        
        manager = ManagerDAO.obtenerInstancia();
        ArrayList HabitacionCantidad = manager.GetHabitacionMasUsada();
        int habitacionid = Integer.parseInt(""+HabitacionCantidad.get(0));
        int cantidad =Integer.parseInt(""+HabitacionCantidad.get(1));
        HabitacionVO objHabitacion = manager.GetRoom(habitacionid);
        ArrayList clienteslista = manager.getListaFromRoom(habitacionid);
        ArrayList listaPeriodo = manager.getListaPeriodoFromRoom(habitacionid);
        System.out.println(listaPeriodo.get(0));
        producto = new ProductoVO();        
        int SumadorJornadaPrecio=0;
        
        int totalSUMA=0;
   
        for(int i=0;i<clienteslista.size();i++){
            arregloClientes[i] = manager.obtenerCliente(""+clienteslista.get(i));
        }
        String textofinal= "La Habitacion mas usada es :"+objHabitacion.getNombre_habitacion()+"\nVeces usada: "+cantidad+"\n\nUtilizada por el/los Cliente/s:\n" ;
        for(int i=0;i<clienteslista.size();i++){
            textofinal = textofinal + arregloClientes[i].getNombre()+" "+arregloClientes[i].getApellido_p()+"\n";
        }
        for(int i=0;i<listaPeriodo.size();i++){
            ArrayList PedidoIDList = manager.obtenerPedidoIDPeriodo(""+listaPeriodo.get(i));
            int cantidadDePersonas = manager.obtenerCantidadDePersonasPorPeriodo(""+listaPeriodo.get(i));
            String tipoJor = manager.obtenerTipoJornadaPorPeriodo(""+listaPeriodo.get(i));
            if(tipoJor.equals("Momento")){
                SumadorJornadaPrecio= SumadorJornadaPrecio + cantidadDePersonas*objHabitacion.getPrecio_momento();
            }if(tipoJor.equals("Completa")){
                SumadorJornadaPrecio= SumadorJornadaPrecio + cantidadDePersonas*objHabitacion.getPrecio_jornada();
            }
                
                
            
            textofinal = textofinal + "Perido: "+PedidoIDList.get(i)+"\n";
            for(int ii=1; ii<PedidoIDList.size();ii++){
                arregloPedidos[ii]=manager.getPedido(""+PedidoIDList.get(ii), objHabitacion);
                producto = manager.getProducto(Integer.parseInt(arregloPedidos[ii].getProductoID()));
                System.out.println(arregloPedidos[ii].getCantidad_pedido());
                System.out.println(producto.getPrecio_producto());
                int SumaJornada = producto.getPrecio_producto() * arregloPedidos[ii].getCantidad_pedido();
                textofinal = textofinal + "\nPedido N°:"+arregloPedidos[ii].getPedidoID()+ " ID Producto: "+arregloPedidos[ii].getProductoID()+" cantidad: "+arregloPedidos[ii].getCantidad_pedido()+"       $"+SumaJornada+"";
                totalSUMA = totalSUMA+ SumaJornada;
            }

        }
            totalSUMA = totalSUMA + SumadorJornadaPrecio;
            textofinal= textofinal+"\n\n\nTotal Gastado en la Habitacion(Estadias y pedidos):  $"+totalSUMA;
        
        
        
        return textofinal;
    }

    public static String GetClienteDelAmor() {
        
        manager = ManagerDAO.obtenerInstancia();
        ArrayList EstadiaCantidadCliente = manager.GetClientesCantidadEstadia();
        ArrayList clientesConMayorEstadia = new ArrayList();
        ArrayList rutCliente =new ArrayList();
           System.out.println(EstadiaCantidadCliente);
        String textoFinal="";
        int cantComparada=  Integer.parseInt(""+EstadiaCantidadCliente.get(0));;
        for(int i =0; i< EstadiaCantidadCliente.size(); i+=2){
          int cantEstadia = Integer.parseInt(""+EstadiaCantidadCliente.get(i));
          if(cantEstadia==cantComparada){
          rutCliente.add(""+EstadiaCantidadCliente.get(i+1));
          }
        }
        
         for(int i=0;i<rutCliente.size();i++){  
          arregloClientes[i] = manager.obtenerCliente(""+rutCliente.get(i));
         }
        
        for(int i =0; i< rutCliente.size();i++){
            
            ArrayList piezasUsada = manager.GetPiezaUsada(arregloClientes[i*2].getRut());
            ArrayList estadiasCliente = manager.GetEstadiasPorCliente(arregloClientes[i*2].getRut());
            textoFinal = textoFinal +"Cliente con mas Estadias: "+arregloClientes[i*2].getNombre()+" "+arregloClientes[i*2].getApellido_p()+"Cantidad de Estadias: "+cantComparada+"\n\nHabitaciones usada: \n";
            for(int ii =0;ii<piezasUsada.size();ii++){
                HabitacionVO habitacion = manager.GetRoom(Integer.parseInt(""+piezasUsada.get(ii)));
                textoFinal = textoFinal + habitacion.getNombre_habitacion()+"\n";
            }
            textoFinal= textoFinal +"\n Fechas de Estadias:\n";
            for(int ii =0;ii<estadiasCliente.size();ii++){
                textoFinal=textoFinal + estadiasCliente.get(ii)+"\n";
            }
            
        }
        return textoFinal;
    
    }

    public static String DatosCliente(String rut) {
        
        manager = ManagerDAO.obtenerInstancia();
        cliente = manager.obtenerCliente(rut);
        ArrayList piezasUsada = manager.GetPiezaUsada(rut);
        ArrayList estadiasCliente = manager.GetEstadiasPorCliente(rut);
        int total =0;
        
        String textoFinal="Cliente: "+cliente.getRut()+"\nNombre: "+cliente.getNombre()+" "+cliente.getApellido_p()+" "+cliente.getApellido_m()+"\nSexo: "+cliente.getSexo()+"\nNacionalidad: "+cliente.getNacionalidad()+""
                + "\nFecha de Nacimiento: "+cliente.getFechaNacimiento()+"\n\nHabitaciones Usadas:\n";
        
        
        for(int i =0;i<piezasUsada.size();i++){
                HabitacionVO habitacion = manager.GetRoom(Integer.parseInt(""+piezasUsada.get(i)));
                textoFinal = textoFinal + habitacion.getNombre_habitacion()+"\n";
            }
            textoFinal= textoFinal +"\n Fechas de Estadias:\n";
            for(int i =0;i<estadiasCliente.size();i++){
                ArrayList pedidosDelCliente= manager.GetPedidoPorCliente(rut,""+estadiasCliente.get(i));
                textoFinal=textoFinal + estadiasCliente.get(i)+"\n         Gasto por Periodo: \n $ ";
                for(int ii =0;ii<pedidosDelCliente.size();ii++){
                    ArrayList cantidadPedidoPrecio = manager.getCantidadPedidoPrecio(""+pedidosDelCliente.get(ii));
                    int cantidad = Integer.parseInt(cantidadPedidoPrecio.get(0)+"");
                    int precio =    Integer.parseInt(cantidadPedidoPrecio.get(1)+"");
                    total =total + precio*cantidad;
                }
                textoFinal=textoFinal+total+"\n";
                total=0;
            }
        
        
        return textoFinal;
    }
        
 }
    
    

