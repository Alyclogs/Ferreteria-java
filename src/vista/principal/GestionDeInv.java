package Vista.Principal;

import Control.dao.ControlFacturas;
import Modelo.Factura;
import Modelo.Producto;
import Control.Tablas.Render;
import Control.Tablas.ModeloTabla;
import Control.dao.ControlProductos;
import Vista.Funciones.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.*;

public final class GestionDeInv extends javax.swing.JFrame {
    
    public ArrayList<Producto> productos;
    public ArrayList<Factura> facturas;
    public int cont = 0;
    public String order;
    private static GestionDeInv obj = null;

    private GestionDeInv() {
        initComponents();
        productos = new ArrayList<>();
        facturas = new ArrayList<>();
        
        listarProductos("id");
        listarFacturas("id");
        cbOrderProductos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                order = cbOrderProductos.getSelectedItem().toString().toLowerCase();
                listarProductos(order);
            }
        });
        cbOrderFacturas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                order = cbOrderFacturas.getSelectedItem().toString();
                switch (order) {
                    case "ID":
                        order = "id";
                        break;
                    case "Nombre del cliente":
                        order = "nomCliente";
                        break;
                    case "Producto vendido":
                        order = "nomProducto";
                        break;
                    case "Cantidad vendida":
                        order = "cantProducto";
                        break;
                    case "Monto venta":
                        order = "montoVenta";
                        break;
                }
                listarProductos(order);
            }
        });
    }
    
    public static GestionDeInv getObj() {
        if (obj == null) {
            obj = new GestionDeInv();
        }
        return obj;
    }

    public void obtenerUsuario(String usuario) {
        txtUsuario.setText("Sesión iniciada como: " + usuario);
    }
    
    public String getOrder() {
        return order;
    }

    public void listarProductos(String order) {
        TablaProductos.setDefaultRenderer(Object.class, new Render());
        ModeloTabla conf = new ModeloTabla();
        DefaultTableModel modelo = conf.modeloTablaProductos();

        Producto pr;
        ControlProductos control = new ControlProductos();
        ArrayList<Producto> list = control.leerProductos(order);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                pr = list.get(i);
                fila[0] = false;
                fila[1] = pr.getID();
                fila[2] = pr.getNombre();
                fila[3] = pr.getPrecio();
                fila[4] = pr.getStock();
                modelo.addRow(fila);
            }
        }
        TablaProductos.setModel(modelo);
        conf.redimensionarColumnas(TablaProductos, 25, 60, 160, 60, 60);
    }
    
    public void listarFacturas(String order) {
        TablaFacturas.setDefaultRenderer(Object.class, new Render());
        ModeloTabla conf = new ModeloTabla();
        DefaultTableModel modelo = conf.modeloTablaFacturas();

        Factura f;
        ControlFacturas control = new ControlFacturas();
        ArrayList<Factura> list = control.leerFacturas(order);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[6];
                f = list.get(i);
                fila[0] = false;
                fila[1] = f.getID();
                fila[2] = f.getNombre();
                fila[3] = f.getNombreProducto();
                fila[4] = f.getCantidadVendida();
                fila[5] = f.getMontoVendido();
                modelo.addRow(fila);
            }
        }
        TablaFacturas.setModel(modelo);
        conf.redimensionarColumnas(TablaFacturas, 25, 25, 140, 140, 25);
    }

    void buscarEnTabla(JTable tabla, JTextField campo) {
        String ele = campo.getText();
        int filas = tabla.getRowCount();
        String busqueda[][] = new String[filas][3];
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < 3; j++) {
                busqueda[i][j] = tabla.getValueAt(i, j).toString();
                if (busqueda[i][j].startsWith(ele) || busqueda[i][j].toLowerCase().startsWith(ele) || busqueda[i][j].toUpperCase().startsWith(ele)) {
                    tabla.changeSelection(i, 2, false, false);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado el producto", "Producto no encontrado", JOptionPane.INFORMATION_MESSAGE);
    }

    void eliminarProducto() {
        Producto p = new Producto();
        ControlProductos controlP = new ControlProductos();
        for (int i = 0; i < TablaProductos.getRowCount(); i++) {
            if ((boolean) TablaProductos.getValueAt(i, 0)) {
                p.setID(productos.get(i).getID());
                controlP.eliminarProducto(p);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    void eliminarFactura() {
        Factura f = new Factura();
        ControlFacturas controlF = new ControlFacturas();
        for (int i = 0; i < TablaFacturas.getRowCount(); i++) {
            if ((boolean) TablaFacturas.getValueAt(i, 0)) {
                f.setID(facturas.get(i).getID());
                controlF.eliminarFactura(f);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        AgregarProducto = new javax.swing.JButton();
        ModificarProducto = new javax.swing.JButton();
        EliminarProducto = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        cbOrderProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaFacturas = new javax.swing.JTable();
        CrearFactura = new javax.swing.JButton();
        EliminarFactura = new javax.swing.JButton();
        ModificarFactura = new javax.swing.JButton();
        txtBuscarFactura = new javax.swing.JTextField();
        btnBuscarFactura = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbOrderFacturas = new javax.swing.JComboBox<>();
        btnActualizar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        btnResumen = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de inventarios de la Ferreteria Huaycoloro");

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jTabbedPane1.setBackground(new java.awt.Color(65, 65, 65));
        jTabbedPane1.setForeground(new java.awt.Color(175, 175, 175));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        TablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        TablaProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(TablaProductos);

        AgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        AgregarProducto.setText("Agregar  nuevo producto");
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });

        ModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        ModificarProducto.setText("Modificar producto existente");
        ModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarProductoActionPerformed(evt);
            }
        });

        EliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/del.png"))); // NOI18N
        EliminarProducto.setText("Eliminar producto");
        EliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProductoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buscar.png"))); // NOI18N
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        txtBuscarProducto.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar producto"));

        cbOrderProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Precio", "Stock" }));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ordenar por:");

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_arrow.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbOrderProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(AgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbOrderProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Productos", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        TablaFacturas.setBackground(new java.awt.Color(255, 255, 255));
        TablaFacturas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(TablaFacturas);

        CrearFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        CrearFactura.setText("Crear factura");
        CrearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearFacturaActionPerformed(evt);
            }
        });

        EliminarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/del.png"))); // NOI18N
        EliminarFactura.setText("Eliminar factura");
        EliminarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarFacturaActionPerformed(evt);
            }
        });

        ModificarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        ModificarFactura.setText("Modificar factura");
        ModificarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarFacturaActionPerformed(evt);
            }
        });

        txtBuscarFactura.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar factura"));

        btnBuscarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buscar.png"))); // NOI18N
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ordenar por:");

        cbOrderFacturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre del cliente", "Producto vendido", "Cantidad vendida", "Monto venta" }));

        btnActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_arrow.png"))); // NOI18N
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbOrderFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CrearFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EliminarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ModificarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscarFactura, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(CrearFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ModificarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EliminarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbOrderFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Facturas", jPanel3);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ferretería Huaycoloro - Gestión de inventarios");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("Sesión iniciada como: ");

        btnResumen.setBackground(new java.awt.Color(0, 153, 255));
        btnResumen.setForeground(new java.awt.Color(0, 0, 0));
        btnResumen.setText("MOSTRAR RESUMEN");
        btnResumen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenActionPerformed(evt);
            }
        });

        btnEditarUsuario.setText("Editar Usuario");
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        NuevoProducto abrir = new NuevoProducto();
        abrir.setVisible(true);
    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void ModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarProductoActionPerformed
        for (int i = 0; i < TablaProductos.getRowCount(); i++) {
            if ((boolean) TablaProductos.getValueAt(i, 0)) {
                ModificarProducto abrir = new ModificarProducto();
                abrir.obtenerFila(i);
                abrir.obtenerProductoSeleccionado(productos.get(i));
                abrir.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_ModificarProductoActionPerformed

    private void EliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProductoActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este producto?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (opc == 0) {
            this.eliminarProducto();
        }
        listarProductos(order);
    }//GEN-LAST:event_EliminarProductoActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        buscarEnTabla(TablaProductos, txtBuscarProducto);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFacturaActionPerformed
        buscarEnTabla(TablaFacturas, txtBuscarFactura);
    }//GEN-LAST:event_btnBuscarFacturaActionPerformed

    private void CrearFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearFacturaActionPerformed
        NuevaFactura abrir = new NuevaFactura();
        abrir.setVisible(true);
    }//GEN-LAST:event_CrearFacturaActionPerformed

    private void ModificarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarFacturaActionPerformed
        for (int i = 0; i < TablaFacturas.getRowCount(); i++) {
            if ((boolean) TablaFacturas.getValueAt(i, 0)) {
                ModificarFactura abrir = new ModificarFactura();
                abrir.obtenerFacturaSeleccionada(facturas.get(i));
                abrir.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_ModificarFacturaActionPerformed

    private void EliminarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarFacturaActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta factura?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (opc == 0) {
            this.eliminarFactura();
        }
        listarFacturas(order);
    }//GEN-LAST:event_EliminarFacturaActionPerformed

    private void btnResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenActionPerformed
        String resultado;
        double total = 0;
        double mayor = -9999;
        String nomProducto = "";

        for (Factura f: facturas) {
            total = total + f.getMontoVendido();
            if (f.cantidadVendida < mayor) {
                mayor = f.cantidadVendida;
                nomProducto = f.nombreProducto;
            }
        }
        resultado = "Producto con más ventas:\t" + nomProducto + "\nTotal de ganancias:\t" + total;

        JOptionPane.showMessageDialog(this, resultado, "Reporte mensual", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnResumenActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        listarProductos(order);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        ModificarUsuario abrir = new ModificarUsuario();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        listarFacturas(order);
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JButton CrearFactura;
    private javax.swing.JButton EliminarFactura;
    private javax.swing.JButton EliminarProducto;
    private javax.swing.JButton ModificarFactura;
    private javax.swing.JButton ModificarProducto;
    private javax.swing.JTable TablaFacturas;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnResumen;
    private javax.swing.JComboBox<String> cbOrderFacturas;
    private javax.swing.JComboBox<String> cbOrderProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBuscarFactura;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
