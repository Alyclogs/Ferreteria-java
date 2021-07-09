package FerreteriaHuaycoloro;
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
            int elegir = leerNumero("Ingrese el número de función a operar");
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

    public static int leerNumero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextInt();
    }
    
    public static String leerCadena(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine();
    }

    /*
        Definimos el método menuPrincipal para mostrar el menú de inicio
        de la Ferretería
     */
    public static void menuPrincipal() {
        System.out.println();
        System.out.println("=========== Bienvenido a la Ferretería Huaycoloro ===========");
        System.out.println("1: Lista de productos \n2: Agregar producto \n3: Eliminar producto \n"
                + "4: Modificar producto \n5: Mostrar facturas \n6: Realizar una factura \n7: Salir");
        System.out.println("==============================================================");
    }

}
