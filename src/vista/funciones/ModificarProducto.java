package Vista.Funciones;

import Modelo.Producto;
import Control.dao.ControlProductos;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;
import Vista.Principal.GestionDeInv;

public class ModificarProducto extends javax.swing.JFrame {
    
    int pos;
    Producto pSelec;
    
    public ModificarProducto() {
        initComponents();
        txtNuevo.setEnabled(false);
        txtNuevo.setVisible(false);
    }
    
    public void obtenerFila(int pos) {
        this.pos = pos;
    }
    
    public void obtenerProductoSeleccionado(Producto p) {
        lbSelec.setText("Ha seleccionado: " + p.nombre);
        this.pSelec = p;
    }
    
    void crearCampo(JTextField campo) {
        campo.setBackground(Color.white);
        campo.setBorder(new LineBorder(Color.DARK_GRAY, 1));
    }
    
    public void modificar(int id, String nombre, double precio, int stock) {
        Producto p = new Producto(false, id, nombre, precio, stock);
        ControlProductos controlP = new ControlProductos();
        controlP.modificarProducto(p);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbSeleccionar = new javax.swing.JComboBox<>();
        lbNuevo = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        txtNuevo = new javax.swing.JTextField();
        lbSelec = new javax.swing.JLabel();

        setTitle("Modificar producto");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon_agregar28x28.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon_cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingrese atributo a modificar");

        cbSeleccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- SELECCIONE ----", "Nombre", "Precio", "Stock" }));

        lbNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNuevo.setForeground(new java.awt.Color(0, 0, 0));

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon_aceptar.png"))); // NOI18N
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtNuevo.setBackground(new java.awt.Color(204, 204, 204));
        txtNuevo.setForeground(new java.awt.Color(0, 0, 0));
        txtNuevo.setBorder(null);

        lbSelec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSelec.setForeground(new java.awt.Color(0, 0, 0));
        lbSelec.setText("Ha seleccionado: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNuevo)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnOK))
                        .addComponent(lbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbSelec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSelec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(lbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int opc = cbSeleccionar.getSelectedIndex();
        String nuevo = txtNuevo.getText();
        GestionDeInv t = GestionDeInv.getObj();
        
        try {
            switch (opc) {
                case 1:
                    String nuevoNombre = nuevo;
                    modificar(pSelec.getID(), nuevoNombre, pSelec.getPrecio(), pSelec.getStock());
                    t.listarProductos(t.getOrder());
                    break;
                case 2:
                    double nuevoPrecio = Double.parseDouble(nuevo);
                    modificar(pSelec.getID(), pSelec.getNombre(), nuevoPrecio, pSelec.getStock());
                    t.listarProductos(t.getOrder());
                    break;
                case 3:
                    int nuevoStock = Integer.parseInt(nuevo);
                    modificar(pSelec.getID(), pSelec.getNombre(), pSelec.getPrecio(), nuevoStock);
                    t.listarProductos(t.getOrder());
                    break;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en la inserción de datos..... " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        int opc = cbSeleccionar.getSelectedIndex();
        txtNuevo.setEnabled(true);
        txtNuevo.setVisible(true);
        switch (opc) {
            case 1:
                lbNuevo.setText("Ingrese nuevo nombre");
                crearCampo(txtNuevo);
                break;
            case 2:
                lbNuevo.setText("Ingrese nuevo precio");
                crearCampo(txtNuevo);
                break;
            case 3:
                lbNuevo.setText("Ingrese nuevo stock");
                crearCampo(txtNuevo);
                break;
        }
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNuevo;
    private javax.swing.JLabel lbSelec;
    private javax.swing.JTextField txtNuevo;
    // End of variables declaration//GEN-END:variables
}
