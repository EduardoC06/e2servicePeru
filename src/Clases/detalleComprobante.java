
package Clases;

public class detalleComprobante {
    private int id_Detalle;
    private int id_Comprobante;
    private int id_Producto;
    private int Cantidad;
    private float MontoUnitario;
    private float Subtotal;

    public detalleComprobante() {
    }

    public detalleComprobante(int id_Producto, int Cantidad, float MontoUnitario, float Subtotal) {
        this.id_Producto = id_Producto;
        this.Cantidad = Cantidad;
        this.MontoUnitario = MontoUnitario;
        this.Subtotal = Subtotal;
    }

    public int getId_Detalle() {
        return id_Detalle;
    }

    public void setId_Detalle(int id_Detalle) {
        this.id_Detalle = id_Detalle;
    }

    public int getId_Comprobante() {
        return id_Comprobante;
    }

    public void setId_Comprobante(int id_Comprobante) {
        this.id_Comprobante = id_Comprobante;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getMontoUnitario() {
        return MontoUnitario;
    }

    public void setMontoUnitario(float MontoUnitario) {
        this.MontoUnitario = MontoUnitario;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
    
    
    
}
