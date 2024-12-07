package Clases;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class movimientoPDF {

    public void prueba(usuario u, List<movimiento> listaMovimientos, String totalVentas) throws FileNotFoundException {
        // Crear el documento en tamaño A4
        Document document = new Document(PageSize.A4, 36, 36, 0, 0);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ReporteMovimientos.pdf"));
            document.open();
            
            PdfPTable tablaCabecera = new PdfPTable(2); // Dos columnas
            tablaCabecera.setWidthPercentage(120); // Tabla ocupa todo el ancho
            tablaCabecera.setWidths(new float[]{1, 2}); // Proporción del ancho entre la imagen y los datos

            // Cargar la imagen
            Image logo = Image.getInstance("C:/Users/ASUS/Documents/NetBeansProjects/e2servicePeru/LogoAjustado.JPG");
            logo.scaleToFit(143, 65); // Ajustar el tamaño de la imagen

            // Crear celda para la imagen
            PdfPCell celdaImagen = new PdfPCell(logo);
            celdaImagen.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar horizontalmente
            celdaImagen.setVerticalAlignment(Element.ALIGN_MIDDLE); // Centrar verticalmente
            celdaImagen.setBackgroundColor(new Color(25, 23, 137)); // Fondo azul oscuro
            celdaImagen.setBorder(PdfPCell.NO_BORDER); // Sin bordes
            celdaImagen.setFixedHeight(120); // Altura fija

            // Crear celda para los datos de la empresa
            String nombreEmpresa = "E2 Service Perú S.A.C.";
            String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String elaboradoPor = "Elaborado por: " + u.getUnombres();

            Paragraph datosEmpresa = new Paragraph(
                nombreEmpresa + "\n" +
                "Fecha de emisión: " + fechaActual + "\n" +
                elaboradoPor,
                new Font(Font.HELVETICA, 14, Font.NORMAL, new Color(255,255,255))
            );
            datosEmpresa.setAlignment(Element.ALIGN_LEFT); // Alinear a la izquierda

            PdfPCell celdaDatos = new PdfPCell();
            celdaDatos.addElement(datosEmpresa);
            celdaDatos.setHorizontalAlignment(Element.ALIGN_LEFT); // Alinear el contenido horizontalmente
            celdaDatos.setVerticalAlignment(Element.ALIGN_MIDDLE); // Alinear el contenido verticalmente
            celdaDatos.setBackgroundColor(new Color(25, 23, 137)); // Fondo azul oscuro
            celdaDatos.setBorder(PdfPCell.NO_BORDER); // Sin bordes

            // Agregar las celdas a la tabla
            tablaCabecera.addCell(celdaImagen);
            tablaCabecera.addCell(celdaDatos);

            // Agregar la tabla al documento
            document.add(tablaCabecera);

            // Alinear toda la tabla a la derecha
            tablaCabecera.setHorizontalAlignment(Element.ALIGN_RIGHT);

            // Título del reporte
            Paragraph titulo = new Paragraph("Reporte de Movimientos", new Font(Font.HELVETICA, 16, Font.BOLD));
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setSpacingBefore(20);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            // Crear la tabla de movimientos
            PdfPTable movimientosTable = new PdfPTable(7); // 7 columnas
            movimientosTable.setWidthPercentage(100); // Tabla ocupa el 100% del ancho de la página
            movimientosTable.setSpacingBefore(10); // Espacio antes de la tabla

            // Títulos de las columnas
            String[] titulos = {"ID", "Producto", "Usuario", "Tipo", "Cantidad", "Fecha", "Observaciones"};

            // Añadir títulos a la tabla
            for (String tituloColumna : titulos) {
                PdfPCell cell = new PdfPCell(new Paragraph(tituloColumna, new Font(Font.HELVETICA, 10, Font.BOLD)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(Color.LIGHT_GRAY); // Fondo gris
                cell.setPadding(5);
                movimientosTable.addCell(cell);
            }

            // Agregar los datos de la lista de movimientos
            for (movimiento mov : listaMovimientos) {
                movimientosTable.addCell(new PdfPCell(new Paragraph(String.valueOf(mov.getId_movimiento()), new Font(Font.HELVETICA, 10))));
                movimientosTable.addCell(new PdfPCell(new Paragraph(mov.getProducto(), new Font(Font.HELVETICA, 10))));
                movimientosTable.addCell(new PdfPCell(new Paragraph(mov.getUsuario(), new Font(Font.HELVETICA, 10))));
                movimientosTable.addCell(new PdfPCell(new Paragraph(mov.getTipo_movimiento(), new Font(Font.HELVETICA, 10))));
                movimientosTable.addCell(new PdfPCell(new Paragraph(String.valueOf((int) mov.getCantidad()), new Font(Font.HELVETICA, 10))));
                movimientosTable.addCell(new PdfPCell(new Paragraph(mov.getFecha_movimiento().toString(), new Font(Font.HELVETICA, 10))));
                movimientosTable.addCell(new PdfPCell(new Paragraph(mov.getObservaciones(), new Font(Font.HELVETICA, 10))));
            }

            // Agregar la tabla al documento
            document.add(movimientosTable);

        } catch (DocumentException | java.io.IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            document.close(); // Cerrar el documento
        }
    }
    
    private PdfPCell crearCeldaConColor(String texto) {
        PdfPCell celda = new PdfPCell(new Paragraph(texto, new Font(Font.HELVETICA, 10, Font.NORMAL)));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setBackgroundColor(new Color(25, 23, 137)); // Fondo azul oscuro
        celda.setPadding(5); // Espaciado interno
        celda.setBorderColor(Color.WHITE); // Bordes blancos para mayor contraste
        return celda;
    }
}
