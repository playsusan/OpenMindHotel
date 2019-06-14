
package Modelo;

public class HabitacionVO {
    private String habitacionID;
    private String Disponibilidad;
    private int precio_momento;
    private int precio_jornada;
    private String nombre_habitacion;
    
    public HabitacionVO(){
        
    }

    public String getHabitacionID() {
        return habitacionID;
    }

    public String getDisponibilidad() {
        return Disponibilidad;
    }

    public int getPrecio_momento() {
        return precio_momento;
    }

    public int getPrecio_jornada() {
        return precio_jornada;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setHabitacionID(String habitacionID) {
        this.habitacionID = habitacionID;
    }

    public void setDisponibilidad(String Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public void setPrecio_momento(int precio_momento) {
        this.precio_momento = precio_momento;
    }

    public void setPrecio_jornada(int precio_jornada) {
        this.precio_jornada = precio_jornada;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    @Override
    public String toString() {
        return "HabitacionVO{" + "habitacionID=" + habitacionID + ", Disponibilidad=" + Disponibilidad + ", precio_momento=" + precio_momento + ", precio_jornada=" + precio_jornada + ", nombre_habitacion=" + nombre_habitacion + '}';
    }
    
    
}
