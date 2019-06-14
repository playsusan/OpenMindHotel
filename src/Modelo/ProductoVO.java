
package Modelo;


public class ProductoVO {
    private String productoID;
    private int cant_stock;
    private int precio_producto;
    private String nombre_producto;
    
    public ProductoVO(){
        
    }

    public String getProductoID() {
        return productoID;
    }

    public int getCant_stock() {
        return cant_stock;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setProductoID(String productoID) {
        this.productoID = productoID;
    }

    public void setCant_stock(int cant_stock) {
        this.cant_stock = cant_stock;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    
}
