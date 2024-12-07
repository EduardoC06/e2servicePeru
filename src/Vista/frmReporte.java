package Vista;

import Clases.movimiento;
import Clases.movimientoPDF;
import Clases.usuario;
import DAO.DAOreporte;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class frmReporte extends javax.swing.JFrame {

    DAOreporte daor = new DAOreporte();
    List<movimiento> ListaMovimientos;
    String[] Cabecera = {"id_movimiento", "producto", "usuario", "tipo_movimiento", "cantidad", "fecha_movimiento", "observaciones"};
    DefaultTableModel DTM;
    TableRowSorter<DefaultTableModel> Filtro;
    usuario u;
    String T;

    public frmReporte(usuario u, String T) {
        if (u.getNivel() == 1 || u.getNivel() == 2) {
            initComponents();
            this.u = u;
            this.T = T;
            Mostrarmovimientos("todo");
            setLocationRelativeTo(null);
            cargarResultados("todo");
        } else {
            JOptionPane.showMessageDialog(null, "Reporte enviado por error de aplicacion");
        }
    }

    private void Mostrarmovimientos(String filtro) {
        try {
            ListaMovimientos = daor.ObtenerMovimientos(filtro);
            DTM = new DefaultTableModel(null, Cabecera);
            for (movimiento C : ListaMovimientos) {
                DTM.addRow(C.Convertir());
            }
            tableMovimientos.setModel(DTM);

            Filtro = new TableRowSorter(DTM); //necesario para filtrar
            tableMovimientos.setRowSorter(Filtro);  //necesario para filtrar

            Configuracion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        opcFiltro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbIngreso = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbSalida = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbventa = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbclientes = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        opcM = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMovimientos = new javax.swing.JTable();
        regresar = new javax.swing.JLabel();
        btnDescargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setText("Reportes");

        opcFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Dia", "Semana", "Mes" }));
        opcFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcFiltroActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Ingreso de productos");

        lbIngreso.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        lbIngreso.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbIngreso))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIngreso)
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Salida");

        lbSalida.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        lbSalida.setText("00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lbSalida))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(lbSalida)
                .addGap(17, 17, 17))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Total de venta");

        lbventa.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        lbventa.setText("00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbventa))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(lbventa)
                .addGap(20, 20, 20))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Clientes");

        lbclientes.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        lbclientes.setText("60");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbclientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(lbclientes)
                .addGap(20, 20, 20))
        );

        jPanel6.setBackground(new java.awt.Color(25, 23, 137));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Movimientos");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ordenar por");

        opcM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo ", "Dia", "Semana", "Mes" }));
        opcM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(opcM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(opcM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        txtBuscar.setText("Buscar");
        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tableMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableMovimientos);

        regresar.setText("Regresar");
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarMouseClicked(evt);
            }
        });

        btnDescargar.setText("Descargar PDF");
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDescargar)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(opcFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(opcFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcFiltroActionPerformed
        //opcFiltro.setSelectedIndex(0);
        int filtro = opcFiltro.getSelectedIndex();
        if (filtro == 0) {
            cargarResultados("todo");
        } else if (filtro == 1) {
            cargarResultados("1dia");
        } else if (filtro == 2) {
            cargarResultados("1semana");
        } else if (filtro == 3) {
            cargarResultados("1mes");
        }
    }//GEN-LAST:event_opcFiltroActionPerformed

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        new frmMenuP(u, T).setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Filtrar();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        txtBuscar.setText(null);
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        movimientoPDF pd = new movimientoPDF();
        try {
            pd.prueba(u, ListaMovimientos, lbventa.getText());
            JOptionPane.showMessageDialog(this, "Reporte generado exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void opcMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcMActionPerformed
        int filtro = opcM.getSelectedIndex();
        if (filtro == 0) {
            Mostrarmovimientos("todo");
        } else if (filtro == 1) {
            Mostrarmovimientos("1dia");
        } else if (filtro == 2) {
            Mostrarmovimientos("1semana");
        } else if (filtro == 3) {
            Mostrarmovimientos("1mes");
        }
    }//GEN-LAST:event_opcMActionPerformed

    private void cargarResultados(String filtroT) {

        LinkedList<Double> lista = daor.obtenerReporte(filtroT);

        if (lista.size() >= 4) {
            // Mostrar los totales en las etiquetas de la interfaz
            lbIngreso.setText(" " + lista.get(0));  // Total de Entradas
            lbSalida.setText(" " + lista.get(1));    // Total de Salidas
            lbventa.setText(" " + lista.get(2));
            lbclientes.setText(" " + lista.get(3));
        }
    }
    
    
    public void Configuracion() {
        tableMovimientos.getColumnModel().getColumn(0).setMaxWidth(0);
        tableMovimientos.getColumnModel().getColumn(0).setMinWidth(0);
        tableMovimientos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

//    public void agregarEventoSeleccionTabla() { //Evento al presionar muestra los datos del producto en los inputtxt
//        tableMovimientos.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int filaSeleccionada = tableMovimientos.rowAtPoint(e.getPoint());
//                if (filaSeleccionada != -1) {
//                    mostrarProductoS(filaSeleccionada);
//                }
//            }
//        });
//    }
    private void Filtrar() {
        try {
            String Texto = txtBuscar.getText();
            Filtro.setRowFilter(RowFilter.regexFilter(Texto, 1));
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIngreso;
    private javax.swing.JLabel lbSalida;
    private javax.swing.JLabel lbclientes;
    private javax.swing.JLabel lbventa;
    private javax.swing.JComboBox<String> opcFiltro;
    private javax.swing.JComboBox<String> opcM;
    private javax.swing.JLabel regresar;
    private javax.swing.JTable tableMovimientos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
