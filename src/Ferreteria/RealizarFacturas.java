package Ferreteria;

import java.util.ArrayList;
import java.util.Scanner;

public class RealizarFacturas {

    ArrayList<Productos> inventario = new ArrayList<>();
    ArrayList<Facturas> facturas = new ArrayList<>();

    public static void realizarFactura(ArrayList<Facturas> facturas, ArrayList<Productos> inventario) {
        System.out.println("Ha seleccionado realizar factura");
        System.out.println("Ingrese el ID del producto vendido:");
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
        int ID = sc.nextInt();

        for (int i = 0; i < inventario.size(); i++) {
            Productos producto = inventario.get(i);
            if (producto.ID == ID) {
                System.out.println("Ha seleccionado el producto " + producto.nombre);
                System.out.println("Ingrese el nombre del cliente:");
                String cliente = sd.nextLine();
                System.out.println("Ingrese la cantidad de producto comprada:");
                int cantProducto = sc.nextInt();

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
                    System.out.println("¿La información ingresada es correcta? (si/no)");
                    String opcion = sc.next();

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
