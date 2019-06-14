
package Modelo;


public class PedidoVO {
     
    private String pedidoID;
    private String productoID;
    private int cantidad_pedido;
   
    
    public PedidoVO(){
    
}
    public String getPedidoID() {
        return pedidoID;
    }

    public String getProductoID() {
        return productoID;
    }

    public int getCantidad_pedido() {
        return cantidad_pedido;
    }

    public void setPedidoID(String pedidoID) {
        this.pedidoID = pedidoID;
    }

    public void setProductoID(String productoID) {
        this.productoID = productoID;
    }

    public void setCantidad_pedido(int cantidad_pedido) {
        this.cantidad_pedido = cantidad_pedido;
    }
    
    

    
}
