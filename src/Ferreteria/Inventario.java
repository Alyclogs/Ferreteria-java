package Ferreteria;

import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Ingrese el ID del producto:");
        int ID = sc.nextInt();
        System.out.println("Ingrese el nombre del producto:");
        String nombre = sd.nextLine();
        System.out.println("Ingrese el precio unitario del producto:");
        double precio = sd.nextDouble();
        System.out.println("Ingrese stock");
        int cant = sc.nextInt();
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
        System.out.println("Ingrese el ID del producto:");
        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();
        for (int i = 0; i < inventario.size(); i++) {
            Productos producto = inventario.get(i);
            if (producto.ID == ID) {
                System.out.println("¿Está seguro que desea eliminar el producto " + producto.nombre + "? (si/no)");
                String opcion = sc.next();

                if (opcion.equals("si")) {
                    inventario.remove(i);
                    System.out.println("¡Producto eliminado correctamente!");
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
                System.out.println("Ingrese un nuevo ID:");
                producto.ID = sc.nextInt();

                System.out.println("Ingrese un nuevo nombre de producto");
                producto.nombre = sd.nextLine();

                System.out.println("Ingrese el precio unitario del producto");
                producto.precio = sc.nextDouble();

                System.out.println("Ingrese nuevo stock");
                producto.cant = sc.nextInt();

                System.out.println("Producto modificado correctamente");
                return;
            }
        }
        System.out.println("¡El ID ingresado no existe!");
    }

}
