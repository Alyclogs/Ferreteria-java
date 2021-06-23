package Ferreteria;

import java.util.ArrayList;

public class MostrarListas {

    ArrayList<Productos> inventario = new ArrayList<>();

    /*
        Definimos el método m ostrarProductos para mostrar la lista de
        productos
     */
    public static void mostrarProductos(ArrayList<Productos> inventario) {
        System.out.println();
        System.out.println("====================== Productos de productos ============================");
        System.out.println("ID de producto" + "\t" + "Nombre del producto" + "\t" + "Precio unitario" + "\t\t" + "Stock");

        for (int i = 0; i < inventario.size(); i++) {
            Productos producto = inventario.get(i);
            System.out.println(producto.ID + "\t\t" + producto.nombre + "\t\t" + producto.precio + "\t"
                    + "\t" + producto.cant);
        }
    }

    public static void mostrarFacturas(ArrayList<Facturas> facturas, ArrayList<Productos> inventario) {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("Nro de factura" + "\t" + "Nombre del cliente" + "\t" + "Nombre del producto" + "\t"
                + "" + "Cantidad comprada" + "\t" + "Monto pagado");

        for (int i = 0; i < facturas.size(); i++) {
            Facturas venta = facturas.get(i);
            System.out.println(venta.nFactura + "\t\t" + venta.nomCliente + "\t\t\t" + venta.nomProducto + "\t"
                    + "\t" + venta.cant + "\t\t" + venta.monto);
        }
    }
}
