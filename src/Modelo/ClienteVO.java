
package Modelo;


public class ClienteVO {
    
    private String rut;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String sexo;
    private String fechaNacimiento;
    private String nacionalidad;
    
    public ClienteVO(String r, String nom, String aP, String aM, String S, String fN, String nac){
        this.rut = r;
        this.nombre = nom;
        this.apellido_p = aP;
        this.apellido_m = aM;
        this.sexo = S;
        this.fechaNacimiento = fN;
        this.nacionalidad = nac;
        
    }

    @Override
    public String toString() {
        return "ClienteVO{" + "rut=" + rut + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad=" + nacionalidad + '}';
    }
    
    public ClienteVO(){
        
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    
    
    
    
}
