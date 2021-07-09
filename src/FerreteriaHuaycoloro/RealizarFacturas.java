package FerreteriaHuaycoloro;

import java.util.ArrayList;
import static FerreteriaHuaycoloro.Ferreteria.leerNumero;
import static FerreteriaHuaycoloro.Ferreteria.leerCadena;

public class RealizarFacturas {

    ArrayList<Productos> inventario = new ArrayList<>();
    ArrayList<Facturas> facturas = new ArrayList<>();

    public static void realizarFactura(ArrayList<Facturas> facturas, ArrayList<Productos> inventario) {
        System.out.println("Ha seleccionado realizar factura");
        int ID = leerNumero("Ingrese el ID del producto vendido:");

        for (int i = 0; i < inventario.size(); i++) {
            Productos producto = inventario.get(i);
            if (producto.ID == ID) {
                System.out.println("Ha seleccionado el producto " + producto.nombre);
                String cliente = leerCadena("Ingrese el nombre del cliente:");
                int cantProducto = leerNumero("Ingrese la cantidad de producto comprada:");

                if (cantProducto > producto.cant) {
                    System.out.println("¡No hay esa cantidad en el inventario!");
                    return;
                } else {
                    Facturas venta = new Facturas();
                    int k = facturas.size() + 1;
                    venta.nFactura = k;
                    venta.nomCliente = cliente;
                    venta.nomProducto = producto.nombre;
                    venta.cant = cantProducto;
                    venta.monto = producto.precio * cantProducto;
                    producto.cant = producto.cant - venta.cant;

                    System.out.println("Ha registrado la factura: \n**************************************\n"
                            + "Nº de Factura: " + k + "\n" + "Nombre del cliente: " + cliente + "\n"
                            + "Producto seleccionado: " + producto.nombre + "\n"
                            + "Cantidad comprada: " + cantProducto + "\nMonto pagado: " + venta.monto);
                    System.out.println("**************************************");
                    String opcion = leerCadena("¿La información ingresada es correcta? (si/no)");

                    if (opcion.equals("si")) {
                        facturas.add(venta);
                        System.out.println("Factura añadida correctamente!");
                        return;
                    } else {
                        System.out.println("Ha cancelado la operación");
                        return;
                    }
                }
            }
        }
        System.out.println("¡El ID ingresado no existe!");
    }
}
