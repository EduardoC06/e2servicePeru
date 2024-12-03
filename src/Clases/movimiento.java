
package Clases;
import java.util.Date;
public class movimiento {
   private int id_movimiento;
   private String producto;
   private String usuario;
   private String tipo_movimiento;
   private int cantidad;
   private String fecha_movimiento;
   private String observaciones;

    public movimiento(int id_movimiento, String producto, String usuario, String tipo_movimiento, int cantidad, String fecha_movimiento, String observaciones) {
        this.id_movimiento = id_movimiento;
        this.producto = producto;
        this.usuario = usuario;
        this.tipo_movimiento = tipo_movimiento;
        this.cantidad = cantidad;
        this.fecha_movimiento = fecha_movimiento;
        this.observaciones = observaciones;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(String fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Object[] Convertir() {
        Object[] Fila = {id_movimiento, producto, usuario, tipo_movimiento, cantidad, fecha_movimiento, observaciones};
        return Fila;
    }
   
}
