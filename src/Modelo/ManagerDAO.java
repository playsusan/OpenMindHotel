
package Modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ManagerDAO {
    private String url;
    private String user;
    private String pass;
    private Connection con;
    private static ManagerDAO manager;
    
private ManagerDAO(){
        user = "root";
        pass = "";
        url = "jdbc:mysql://localhost:3306/hotelom";
        con = null;
    }

 public static ManagerDAO obtenerInstancia(){
        if(manager == null){
            manager = new ManagerDAO();
        }
        return manager;
    }
 private boolean conectar(){
        try {        
            con = DriverManager.getConnection(url, user, pass);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al conectar:[" + ex.getMessage() + "]");
        }
        return false;
    }
 
 private void desconectar(){
        if(con != null){
            try {
                if(!con.isClosed()){
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al desconectar:[" + ex.getMessage() + "]");
            }
        }     
    }
 
 public ClienteVO obtenerCliente(String rut){
        ClienteVO cliente = null;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select * from clientes where clientesID = '" + rut + "'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next() == true){
                    cliente = new ClienteVO();
                    cliente.setRut(rut);
                    cliente.setNombre(result.getString("nombres"));
                    cliente.setApellido_p(result.getString("apellidoP"));
                    cliente.setApellido_m(result.getString("apellidoM"));
                    cliente.setSexo(result.getString("sexo"));
                    cliente.setFechaNacimiento(result.getString("fecha_de_nacimiento"));
                    cliente.setNacionalidad(result.getString("nacionalidad"));

                }
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return cliente;
    }
 
     public int obtenerStock(int nombreP){
            
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select cant_stock from producto where productoID = '" + nombreP + "'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                result.next();
                int i = result.getInt("cant_stock");
                this.desconectar();
                return i;
                
                
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return 0;
    } 

    public boolean setStock(int productoID, int Stock) { 
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = "update producto set cant_stock=" + Stock
                          + " where productoID='" + productoID+ "'";
                System.out.println("Modifiacndo:[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al modificar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }

    public ProductoVO getProducto(int i) {
    ProductoVO producto = null;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select * from producto where productoID = '" + i + "'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next() == true){
                    producto = new ProductoVO();
                    producto.setProductoID(""+i);
                    producto.setCant_stock(result.getInt("cant_stock"));
                    producto.setPrecio_producto(result.getInt("precio_producto"));
                    producto.setNombre_producto(result.getString("nombre_producto"));;

                }
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return producto;
    
    }

    public HabitacionVO GetRoom(int i) {
    HabitacionVO habitacion = null;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select * from habitacion where habitacionID = '" + i + "'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next() == true){
                    habitacion = new HabitacionVO();
                    habitacion.setHabitacionID(""+i);
                    habitacion.setDisponibilidad(result.getString("Disponibilidad"));
                    habitacion.setPrecio_momento(result.getInt("precio_momento"));
                    habitacion.setPrecio_jornada(result.getInt("precio_jordana"));
                    habitacion.setNombre_habitacion(result.getString("nombre_habitacion"));
                    
                }
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return habitacion;
    }

    public boolean RegistrarCliente(String sqltext) {
        
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = sqltext;
                System.out.println("Insertando :[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }

    public boolean newRegistroEstadia(String TextoSQL) {
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = TextoSQL;
                System.out.println("Insertando :[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }

    public boolean SetHabitacionOcupada(String TextoSQL) {
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = TextoSQL;
                System.out.println("Modificando :[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al modificar:[" + ex.getMessage() + "]");
            }
        }
        return false;
     }

    public ArrayList ListaClientesHabitacion(String habitacionID) {
        ArrayList listarut = new ArrayList();
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select clientesID from estadia where habitacionID= '"+habitacionID+
                                "' and fecha_ingreso=(select max(fecha_ingreso) from estadia where habitacionID = '"+habitacionID+"')group by clientesID";
                System.out.println("Consultando:[" + sql + "]");
                 ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    String rut = result.getString(1);
                    listarut.add(rut);
                }
                this.desconectar();
                return listarut;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listarut;
    }

    public String ReturnFechaIngreso(String habitacionID) {
        String fecha = "";
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select fecha_ingreso from estadia where habitacionID= '"+habitacionID+
                                "' and fecha_ingreso=(select max(fecha_ingreso) from estadia where habitacionID = '"+habitacionID+"')";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                result.next(); 
                fecha = result.getString(1);;
                
                this.desconectar();
                return fecha;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return fecha;   
    }

    public ArrayList ListaProductosPorHabitacion(String habitacionID) {
        ArrayList listaProductos = new ArrayList();
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select pedidoID from estadia where habitacionID= '"+habitacionID+
                                "' and fecha_ingreso=(select max(fecha_ingreso) from estadia where habitacionID = '"+habitacionID+"') group by pedidoID";
                System.out.println("Consultando:[" + sql + "]");
                 ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    String rut = result.getString(1);
                    listaProductos.add(rut);
                }
                this.desconectar();
                return listaProductos;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return listaProductos;
    }

    public PedidoVO getPedido(String pedidoID, HabitacionVO habitacion) {
         PedidoVO pedido = null;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select * from pedido where PedidoID = '" + pedidoID + "'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next() == true){
                    pedido = new PedidoVO();
                    pedido.setPedidoID(""+pedidoID);
                    pedido.setProductoID(result.getString("productoID"));
                    pedido.setCantidad_pedido(result.getInt("cantidad_pedido"));
                    
                }
                
                this.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        
        return pedido;
    }

    public String getLastPedido() {
                String pedido = "";
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select max(pedidoID) from pedido group by pedidoID order by pedidoID desc";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                result.next(); 
                pedido = result.getString(1);;
                
                this.desconectar();
                return pedido;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return pedido; 
    }

    public boolean CrearNuevoPedido(int newPedido, int ProductoID, int suma) {
            
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = "insert into pedido (pedidoID,productoID,cantidad_pedido) values ('"+newPedido+"','"+ProductoID+"',"+suma+")";
                System.out.println("Insertando :[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }

    public boolean CrearEstadiaPedido(String rut, HabitacionVO habitacion, int newPedido,String tipoJor, String fechaIngreso) {
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = "insert into estadia (clientesID, habitacionID, pedidoID, tipo_jornada, fecha_ingreso) values ('"+
                                rut+"','"+habitacion.getHabitacionID()+"','"+newPedido+"','"+tipoJor+"','"+fechaIngreso+"')";
                System.out.println("Insertando :[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al insertar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }

    public String obtenerTipoJornada(String habitacionID) {
        String tipodJorrnada = "";
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select tipo_jornada from estadia where habitacionID= '"+habitacionID+"' and fecha_ingreso=(select max(fecha_ingreso) from estadia where habitacionID = '"+habitacionID+"') group by pedidoID";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                result.next(); 
                tipodJorrnada = result.getString(1);;
                
                this.desconectar();
                return tipodJorrnada;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return tipodJorrnada; 
    }

    public boolean modificarPedido(PedidoVO arregloPedido) {
        if(conectar()==true){
            try {
                Statement st = con.createStatement();
                String sql = "update pedido set cantidad_pedido=" + arregloPedido.getCantidad_pedido()
                          + " where productoID='" + arregloPedido.getProductoID()+ "' and pedidoID='"+arregloPedido.getPedidoID()+"'";
                System.out.println("Modifiacndo:[" + sql + "]");
                int rowsAffected = st.executeUpdate(sql);
                this.desconectar();
                return (rowsAffected==1);
            } catch (SQLException ex) {
                System.out.println("Error al modificar:[" + ex.getMessage() + "]");
            }
        }
        return false;
    }

    public ArrayList GetProductomasVendido() {
        ArrayList ProductoyCantidad= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select productoID ,cantidad from (select productoID, cast(format(sum(cantidad_pedido),1) as SIGNED)cantidad from pedido group by productoID ) "
                        + "as t where cantidad = (select max(cantidad) from (select pedidoID,cast(format(sum(cantidad_pedido),1) as SIGNED)cantidad from pedido group by productoID ) as w)";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int productoid = result.getInt(1);
                    ProductoyCantidad.add(productoid);
                    int cantidadvendida = result.getInt(2);
                    ProductoyCantidad.add(cantidadvendida);
                }
                this.desconectar();
                return ProductoyCantidad;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return ProductoyCantidad; 
    }
    
        public ArrayList GetProductoMenosVendido() {
        ArrayList ProductoyCantidad= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select productoID ,cantidad from (select productoID, cast(format(sum(cantidad_pedido),1) as SIGNED)cantidad from pedido group by productoID ) "
                        + "as t where cantidad = (select min(cantidad) from (select pedidoID,cast(format(sum(cantidad_pedido),1) as SIGNED)cantidad from pedido group by productoID ) as w)";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int productoid = result.getInt(1);
                    ProductoyCantidad.add(productoid);
                    int cantidadvendida = result.getInt(2);
                    ProductoyCantidad.add(cantidadvendida);
                }
                this.desconectar();
                return ProductoyCantidad;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return ProductoyCantidad; 
    }
        
        public ArrayList GetHabitacionMenosUsada() {
        ArrayList HabitacionyCantidad= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select habitacionID ,veces_ocupada from (select habitacionID, cast(format(count(habitacionID),1) as Signed)veces_ocupada from estadia group by habitacionID)as t where veces_ocupada = "
                        + "(select min(veces_ocupada) from (select habitacionID, cast(format(count(habitacionID),1) as Signed)veces_ocupada from estadia group by habitacionID) as w)";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int nombreHabitacion = result.getInt(1);
                    HabitacionyCantidad.add(nombreHabitacion);
                    int cantidadUsada = result.getInt(2);
                    HabitacionyCantidad.add(cantidadUsada);
                }
                this.desconectar();
                return HabitacionyCantidad;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return HabitacionyCantidad; 
    }


    public ArrayList GetproductoCantidadPiezaMas(int productoid) {
        ArrayList productoCantidadPieza= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select cast(format(sum(cantidad_pedido),1)as Signed) cantidad_por_habitacion,habitacionID from (select T.* ,ES.habitacionID  from "
                        + "(select pedidoID,cantidad_pedido from pedido where `productoID` = '"+productoid+"') as T , estadia ES  where T.pedidoID = ES.pedidoID group by ES.pedidoID)as w group by habitacionID "
                        + "order by habitacionID ASC";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int cantidadPorPieza = result.getInt(1);
                    productoCantidadPieza.add(cantidadPorPieza);
                    int Pieza = result.getInt(2);
                    productoCantidadPieza.add(Pieza);
                }
                this.desconectar();
                return productoCantidadPieza;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return productoCantidadPieza; 
    }
    public ArrayList GetproductoCantidadPiezaMenos(int productoid) {
        ArrayList productoCantidadPieza= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select cast(format(sum(cantidad_pedido),1)as Signed) cantidad_por_habitacion,habitacionID from (select T.* ,ES.habitacionID  from "
                        + "(select pedidoID,cantidad_pedido from pedido where `productoID` = '"+productoid+"') as T , estadia ES  where T.pedidoID = ES.pedidoID group by ES.pedidoID)as w group by habitacionID "
                        + "order by habitacionID DESC";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int cantidadPorPieza = result.getInt(1);
                    productoCantidadPieza.add(cantidadPorPieza);
                    int Pieza = result.getInt(2);
                    productoCantidadPieza.add(Pieza);
                }
                this.desconectar();
                return productoCantidadPieza;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return productoCantidadPieza; 
    }

    public ArrayList getListaFromRoom(int habitacionid) {
           ArrayList ClientesPieza= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select clientesID from estadia where habitacionID ='"+habitacionid+"' group by clientesID";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    String rut = result.getString(1);
                    ClientesPieza.add(rut);
                }
                this.desconectar();
                return ClientesPieza;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return ClientesPieza; 
    }

    public ArrayList getListaPeriodoFromRoom(int habitacionid) {
        ArrayList periodos= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select fecha_ingreso from estadia where habitacionID='"+habitacionid+"' group by fecha_ingreso";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    String rut = result.getString(1);
                    periodos.add(rut);
                }
                this.desconectar();
                return periodos;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return periodos;
    }

    public ArrayList obtenerPedidoIDPeriodo(String fecha) {
               ArrayList pedidosids= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select pedidoID from estadia where fecha_ingreso = '"+fecha+"'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int pedid = result.getInt(1);
                    pedidosids.add(pedid);
                }
                this.desconectar();
                return pedidosids;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return pedidosids;
    }

    public int obtenerCantidadDePersonasPorPeriodo(String fecha) {
        int cantidad =0;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "Select count(clientesID) from (select clientesID from estadia where fecha_ingreso = '"+fecha+"' group by clientesID) as T";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next() == true){
                    cantidad = result.getInt(1);
                   
                }
                this.desconectar();
                return cantidad;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return cantidad;
    }

    public String obtenerTipoJornadaPorPeriodo(String fecha) {
                String tipoJor ="";
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "Select tipo_jornada from estadia where fecha_ingreso = '2019/03/30 23:19:41' group by tipo_jornada";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                if(result.next() == true){
                    tipoJor = result.getString(1);
                   
                }
                this.desconectar();
                return tipoJor;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return tipoJor;
    }

    public ArrayList GetHabitacionMasUsada() {
        ArrayList HabitacionyCantidad= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select habitacionID ,veces_ocupada from (select habitacionID, cast(format(count(habitacionID),1) as Signed)veces_ocupada from estadia group by habitacionID)as t where veces_ocupada = "
                        + "(select max(veces_ocupada) from (select habitacionID, cast(format(count(habitacionID),1) as Signed)veces_ocupada from estadia group by habitacionID) as w)";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int nombreHabitacion = result.getInt(1);
                    HabitacionyCantidad.add(nombreHabitacion);
                    int cantidadUsada = result.getInt(2);
                    HabitacionyCantidad.add(cantidadUsada);
                }
                this.desconectar();
                return HabitacionyCantidad;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return HabitacionyCantidad; 
    }

    public ArrayList GetClientesCantidadEstadia() {
        ArrayList CantidadEstadiaCliente= new ArrayList();;
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select count(fecha_ingreso),clientesID from (select clientesID, fecha_ingreso from estadia group by clientesID,fecha_ingreso) as t group by clientesID order by count(fecha_ingreso) DESC";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int cantidadEstadia = result.getInt(1);
                    CantidadEstadiaCliente.add(cantidadEstadia);
                    String rut = result.getString(2);
                    CantidadEstadiaCliente.add(rut);
                }
                this.desconectar();
                return CantidadEstadiaCliente;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return CantidadEstadiaCliente; 
    }

    public ArrayList GetPiezaUsada(String rut) {
        ArrayList piezas= new ArrayList();;       
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select habitacionID from estadia where clientesID ='"+rut+"' group by habitacionID";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int cantidadEstadia = result.getInt(1);
                    piezas.add(cantidadEstadia);
                }
                this.desconectar();
                return piezas;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return piezas; 
    }
    
        public ArrayList GetEstadiasPorCliente(String rut) {
        ArrayList estadias= new ArrayList();;       
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select fecha_ingreso from estadia where clientesID ='"+rut+"' group by fecha_ingreso";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    String cantidadEstadia = result.getString(1);
                    estadias.add(cantidadEstadia);
                }
                this.desconectar();
                return estadias;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return estadias; 
    }

    public ArrayList GetPedidoPorCliente(String rut,String fecha) {
     ArrayList pedidos= new ArrayList();       
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select pedidoID from ESTADIA where clientesID= '"+rut+"' and fecha_ingreso='"+fecha+"'";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int numeroPedido = result.getInt(1);
                    pedidos.add(numeroPedido);
                }
                this.desconectar();
                return pedidos;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return pedidos; 
    }

    public ArrayList getCantidadPedidoPrecio(String pedidoID) {
        ArrayList CantidadPrecio= new ArrayList();    
        if(this.conectar() == true){
            try {
                Statement st = con.createStatement();
                String sql = "select pedido.cantidad_pedido, producto.precio_producto from pedido,producto where pedidoID= "+pedidoID+" and pedido.productoID=producto.productoID";
                System.out.println("Consultando:[" + sql + "]");
                ResultSet result = st.executeQuery(sql);
                while(result.next() == true){
                    int cantidad = result.getInt(1);
                    CantidadPrecio.add(cantidad);
                    int precio = result.getInt(2);
                    CantidadPrecio.add(precio);
                }
                this.desconectar();
                return CantidadPrecio;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta:[" + ex.getMessage() + "]");
            }
        }
        return CantidadPrecio; 
    }

       

}