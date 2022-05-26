
package Vista.Funciones;

import Control.dao.ControlUsuario;
import Modelo.Usuario;
import Vista.Principal.GestionDeInv;
import Vista.Principal.Inicio;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ModificarUsuario extends javax.swing.JFrame {

    public ModificarUsuario() {
        initComponents();
        txtNuevo.setVisible(false);
        txtNuevo.setEnabled(false);
    }

    void crearCampo(JTextField campo) {
        campo.setBackground(Color.white);
        campo.setBorder(new LineBorder(Color.DARK_GRAY, 1));
    }

    void modificar(String usuario, String password) {
        ControlUsuario control = new ControlUsuario();
        Usuario nuevo = new Usuario(usuario, password);
        control.modificarUsuario(nuevo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbSeleccionar = new javax.swing.JComboBox<>();
        lbNuevo = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        txtNuevo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon_cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("¿Qué desea modificar?");

        cbSeleccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- SELECCIONE ----", "Usuario", "Contraseña" }));

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

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon_agregar28x28.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNuevo)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK))
                    .addComponent(lbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        int opc = cbSeleccionar.getSelectedIndex();
        txtNuevo.setEnabled(true);
        txtNuevo.setVisible(true);
        switch (opc) {
            case 1:
                lbNuevo.setText("Ingrese nuevo nombre de usuario");
                crearCampo(txtNuevo);
                break;
            case 2:
                lbNuevo.setText("Ingrese nueva contraseña");
                crearCampo(txtNuevo);
                break;
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int opc = cbSeleccionar.getSelectedIndex();
        String nuevo = txtNuevo.getText();
        GestionDeInv t = GestionDeInv.getObj();
        ControlUsuario control = new ControlUsuario();
        String[] usuarioActual = control.leerUsuario();
        String nuevoNombre, nuevaPassword;

        try {
            switch (opc) {
                case 1:
                    nuevoNombre = nuevo;
                    modificar(nuevoNombre, usuarioActual[1]);
                    t.listarProductos(t.getOrder());
                    t.obtenerUsuario(nuevoNombre);
                    break;
                case 2:
                    nuevaPassword = nuevo;
                    modificar(usuarioActual[0], nuevaPassword);
                    t.listarProductos(t.getOrder());
                    t.obtenerUsuario(usuarioActual[0]);
                    break;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en la inserción de datos..... " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNuevo;
    private javax.swing.JTextField txtNuevo;
    // End of variables declaration//GEN-END:variables
}
