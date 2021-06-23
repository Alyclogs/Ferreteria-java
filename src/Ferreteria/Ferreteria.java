package Ferreteria;
//Importamos la clase ArrayList para trabajar con arrays

import java.util.ArrayList;
import java.util.Scanner;

public class Ferreteria {

    public static void main(String[] args) {
        /*
            Definimos el inventario que hace referencia a la clase Productos,
            donde se encuentran definidos los atributos modificables
            del producto
         */
        ArrayList<Productos> inventario = new ArrayList<>();
        ArrayList<Facturas> facturas = new ArrayList<>();
        /*
            Llamamos al método iniciar para obtener la lista de
            productos.
            Llamamos al metodo iniFacturas para obtener la lista
            de facturas
         */
        IniciarListas.iniciar(inventario);
        IniciarListas.iniFacturas(facturas, inventario);
        /*
            El ciclo se repetirá hasta que no hayan datos para
            mostrar
         */
        do {
            /*
                Llamamos al método menuPrincipal para mostrar el menú
                de opciones
             */
            menuPrincipal();
            /*
                Llamamos al método elegirFuncion para
                permitir al usuario elegir la función del menú
             */
            int elegir = elegirFuncion();
            /*
                Según la opción que se elija, se llamará a sus
                métodos respectivos
             */
            switch (elegir) {
                case 1:
                    MostrarListas.mostrarProductos(inventario);
                    break;

                case 2:
                    Inventario.agregarProducto(inventario);
                    break;

                case 3:
                    Inventario.eliminarProducto(inventario);
                    break;

                case 4:
                    Inventario.modificarProducto(inventario);
                    break;

                case 5:
                    MostrarListas.mostrarFacturas(facturas, inventario);
                    break;

                case 6:
                    RealizarFacturas.realizarFactura(facturas, inventario);
                    break;

                case 7:
                    System.out.println("Salir de la ferretería");
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!false);
    }

    /*
        Definimos el método elegirFuncion para leer la opción elegida por
        el usuario
     */
    public static int elegirFuncion() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /*
        Definimos el método menuPrincipal para mostrar el menú de inicio
        de la Ferretería
     */
    public static void menuPrincipal() {
        System.out.println();
        System.out.println("=========== Bienvenido a la Ferretería Los Castros ===========");
        System.out.println("1: Productos de productos \n2: Agregar producto \n3: Eliminar producto \n"
                + "4: Modificar producto \n5: Mostrar facturas \n6: Realizar una factura \n7: Salir");
        System.out.println("==============================================================");
        System.out.println("Ingrese el número de función a operar");
    }

}
