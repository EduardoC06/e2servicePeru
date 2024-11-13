
package Clases;

import java.util.Date;
import java.util.List;

public class comprobante {
//    private int cdComprobante;
//    private int CCdCliente;
//    private int UCdtrabajador;
//    private String CTipoPago;
//    private Date COFechaP;
//    private float COIGV;
//    private float COTotal;
    

    private int id_comprobante;
    private int id_usuario;
    private int id_cliente;
    private Date fecha;
    private float igv;
    private float total;
    private List<detalleComprobante> detalles;
    private cliente cliente;

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public comprobante(int id_usuario, Date fecha, float igv, float total, List<detalleComprobante> detalles, cliente cliente) {
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.igv = igv;
        this.total = total;
        this.detalles = detalles;
        this.cliente = cliente;
    }

    public comprobante(int id_usuario, int id_cliente, Date fecha, float igv, float total, List<detalleComprobante> detalles, cliente cliente) {
        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.igv = igv;
        this.total = total;
        this.detalles = detalles;
        this.cliente = cliente;
    }
    
    
    public comprobante(int id_comprobante, int id_usuario, int id_cliente, Date fecha, float igv, float total, List<detalleComprobante> detalles) {
        this.id_comprobante = id_comprobante;
        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.igv = igv;
        this.total = total;
        this.detalles = detalles;
    }

    public comprobante(int id_usuario, int id_cliente, Date fecha, float igv, float total, List<detalleComprobante> detalles) {
        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.igv = igv;
        this.total = total;
        this.detalles = detalles;
    }
    
    
    public int getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getIgv() {
        return igv;
    }

    public void setIgv(float igv) {
        this.igv = igv;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public List<detalleComprobante> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detalleComprobante> detalles) {
        this.detalles = detalles;
    }
//    public comprobante(int cdComprobante, int CCdCliente, int UCdtrabajador, String CTipoPago, Date COFechaP, float COIGV, float COTotal, List<detalleComprobante> detalles) {
//        this.cdComprobante = cdComprobante;
//        this.CCdCliente = CCdCliente;
//        this.UCdtrabajador = UCdtrabajador;
//        this.CTipoPago = CTipoPago;
//        this.COFechaP = COFechaP;
//        this.COIGV = COIGV;
//        this.COTotal = COTotal;
//        this.detalles = detalles;
//    }
//
//    public int getCdComprobante() {
//        return cdComprobante;
//    }
//
//    public void setCdComprobante(int cdComprobante) {
//        this.cdComprobante = cdComprobante;
//    }
//
//    public int getCCdCliente() {
//        return CCdCliente;
//    }
//
//    public void setCCdCliente(int CCdCliente) {
//        this.CCdCliente = CCdCliente;
//    }
//
//    public int getUCdtrabajador() {
//        return UCdtrabajador;
//    }
//
//    public void setUCdtrabajador(int UCdtrabajador) {
//        this.UCdtrabajador = UCdtrabajador;
//    }
//
//    public String getCTipoPago() {
//        return CTipoPago;
//    }
//
//    public void setCTipoPago(String CTipoPago) {
//        this.CTipoPago = CTipoPago;
//    }
//
//    public Date getCOFechaP() {
//        return COFechaP;
//    }
//
//    public void setCOFechaP(Date COFechaP) {
//        this.COFechaP = COFechaP;
//    }
//
//    public float getCOIGV() {
//        return COIGV;
//    }
//
//    public void setCOIGV(float COIGV) {
//        this.COIGV = COIGV;
//    }
//
//    public float getCOTotal() {
//        return COTotal;
//    }
//
//    public void setCOTotal(float COTotal) {
//        this.COTotal = COTotal;
//    }

     
}
