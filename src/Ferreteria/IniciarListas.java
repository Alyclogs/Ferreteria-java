package Ferreteria;

import java.util.ArrayList;

public class IniciarListas {

    ArrayList<Productos> inventario = new ArrayList<>();
    ArrayList<Facturas> facturas = new ArrayList<>();

    //Definimos el método iniciar para obtener los datos de los productos
    public static void iniciar(ArrayList<Productos> inventario) {
        Productos p1 = new Productos();
        p1.ID = 9004;
        p1.nombre = "Par de guantes  ";
        p1.precio = 14.7;
        p1.cant = 16;

        Productos p2 = new Productos();
        p2.ID = 9005;
        p2.nombre = "Martillo carpintero";
        p2.precio = 29.5;
        p2.cant = 7;

        Productos p3 = new Productos();
        p3.ID = 9013;
        p3.nombre = "Alicate multiuso";
        p3.precio = 12.9;
        p3.cant = 8;

        Productos p4 = new Productos();
        p4.ID = 9127;
        p4.nombre = "Serrucho carpintero";
        p4.precio = 27.9;
        p4.cant = 6;

        Productos p5 = new Productos();
        p5.ID = 9128;
        p5.nombre = "Destornillador  ";
        p5.precio = 18.5;
        p5.cant = 18;

        Productos p6 = new Productos();
        p6.ID = 9210;
        p6.nombre = "Taladro mediano  ";
        p6.precio = 99.0;
        p6.cant = 4;

        Productos p7 = new Productos();
        p7.ID = 9512;
        p7.nombre = "Juego de llaves  ";
        p7.precio = 163.2;
        p7.cant = 3;

        Productos p8 = new Productos();
        p8.ID = 9534;
        p8.nombre = "Juego de tornillos";
        p8.precio = 102.7;
        p8.cant = 4;

        Productos p9 = new Productos();
        p9.ID = 9775;
        p9.nombre = "Juego de tuercas";
        p9.precio = 114.5;
        p9.cant = 2;

        Productos p10 = new Productos();
        p10.ID = 9808;
        p10.nombre = "Juego de clavos   ";
        p10.precio = 27.9;
        p10.cant = 4;

        Productos p11 = new Productos();
        p11.ID = 9819;
        p11.nombre = "Cinta métrica    ";
        p11.precio = 10.0;
        p11.cant = 14;

        Productos p12 = new Productos();
        p12.ID = 9823;
        p12.nombre = "Trincheta o tijera";
        p12.precio = 21.7;
        p12.cant = 8;

        Productos p13 = new Productos();
        p13.ID = 9861;
        p13.nombre = "Cinta aislante    ";
        p13.precio = 15.7;
        p13.cant = 16;

        Productos p14 = new Productos();
        p14.ID = 9883;
        p14.nombre = "Amarres de nylon";
        p14.precio = 17.7;
        p14.cant = 7;

        Productos p15 = new Productos();
        p15.ID = 9921;
        p15.nombre = "Lubricante multiusos";
        p15.precio = 21.7;
        p15.cant = 13;

        inventario.add(p1);
        inventario.add(p2);
        inventario.add(p3);
        inventario.add(p4);
        inventario.add(p5);
        inventario.add(p6);
        inventario.add(p7);
        inventario.add(p8);
        inventario.add(p9);
        inventario.add(p10);
        inventario.add(p11);
        inventario.add(p12);
        inventario.add(p13);
        inventario.add(p14);
        inventario.add(p15);
    }

    public static void iniFacturas(ArrayList<Facturas> facturas, ArrayList<Productos> inventario) {
        Facturas f1 = new Facturas();
        f1.nFactura = 1;
        f1.nomCliente = "Marco";
        f1.nomProducto = "Serrucho carpintero";
        f1.cant = 1;
        f1.monto = 27.9;

        facturas.add(f1);
    }
}
