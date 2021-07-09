package FerreteriaHuaycoloro;

import java.util.ArrayList;
import java.util.Scanner;
import static FerreteriaHuaycoloro.Ferreteria.leerNumero;
import static FerreteriaHuaycoloro.Ferreteria.leerCadena;

public class Inventario {

    ArrayList<Productos> inventario = new ArrayList<>();

    /*
        Definimos el método agregarProducto para leer los dato del
        producto ingresados por el usuario
     */
    public static void agregarProducto(ArrayList<Productos> inventario) {
        System.out.println("Ha seleccionado agregar productos");
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
        int ID = leerNumero("Ingrese el ID del producto:");
        String nombre = leerCadena("Ingrese el nombre del producto:");
        System.out.println("Ingrese el precio unitario del producto:");
        double precio = sd.nextDouble();
        int cant = leerNumero("Ingrese stock");
        /*
            Definimos un objeto de la clase Productos al cual llamaremos producto,
            que se encargará de registrar los datos ingresados en la lista de
            productos
         */
        Productos producto = new Productos();
        producto.ID = ID;
        producto.nombre = nombre;
        producto.precio = precio;
        producto.cant = cant;
        inventario.add(producto);
        System.out.println("Producto agregado correctamente!");
    }

    /*
        Definimos el método eliminarProducto para leer el ID del
        producto que se desea eliminar
     */
    public static void eliminarProducto(ArrayList<Productos> inventario) {
        System.out.println("Ha seleccionado eliminar producto");
        int ID = leerNumero("Ingrese el ID del producto:");
        for (int i = 0; i < inventario.size(); i++) {
            Productos producto = inventario.get(i);
            if (producto.ID == ID) {
                String opcion = leerCadena("¿Está seguro que desea eliminar el producto " + producto.nombre + "? (si/no)");

                if (opcion.equals("si")) {
                    inventario.remove(i);
                    System.out.println("¡Producto " + producto.nombre + " eliminado correctamente!");
                    return;
                } else {
                    System.out.println("Ha cancelado la operación");
                    return;
                }
            }
        }
        System.out.println("¡El ID ingresado no existe!");
    }

    /*
        Definimos el método modificarProducto para modificar
        los datos del producto seleccionado mediante su ID
     */
    public static void modificarProducto(ArrayList<Productos> inventario) {
        System.out.println("Ha seleccionado modificar producto");
        System.out.println("Ingrese el ID del producto a modificar:");

        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
        int ID = sc.nextInt();
        for (int i = 0; i < inventario.size(); i++) {
            Productos producto = inventario.get(i);
            if (producto.ID == ID) {
                System.out.println("Ha seleccionado el producto " + producto.nombre);
                int opc = leerNumero("Ingrese atributo a modificar: (1)ID (2)Nombre (3)Precio (4)Stock");

                switch (opc) {
                    case 1:
                        producto.ID = leerNumero("Ingrese un nuevo ID:");
                        break;

                    case 2:
                        System.out.println("Ingrese un nuevo nombre de producto");
                        producto.nombre = sd.nextLine();
                        break;

                    case 3:
                        System.out.println("Ingrese el precio unitario del producto");
                        producto.precio = sc.nextDouble();
                        break;

                    case 4:
                        System.out.println("Ingrese nuevo stock");
                        producto.cant = sc.nextInt();
                        break;

                    default:
                        System.out.println("La opción no existe!");
                        return;
                }
                System.out.println("Producto modificado correctamente");
                return;
            }
        }
        System.out.println("¡El ID ingresado no existe!");
    }

}
