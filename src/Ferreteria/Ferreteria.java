/*
Exportar al repositorio:
git add build/classes/Ferreteria/Ferreteria.class
git add src/Ferreteria/Ferreteria.java
*/
package Ferreteria;
//Importamos la clase ArrayList para trabajar con inventarios
import java.util.ArrayList;
import java.util.Scanner;

public class Ferreteria {
	public static void main(String[] args) {
                /*
                Definimos el inventario que hace referencia a la clase Lista,
                donde se encuentran definidos los atributos modificables
                del producto
                */
		ArrayList<Lista> inventario = new ArrayList<>();
                ArrayList<Facturas> facturas = new ArrayList<>();
                /*
                Llamamos al método iniciar para obtener la lista de
                productos.
                Llamamos al metodo iniFacturas para obtener la lista
                de facturas
                */
		iniciar(inventario);
                iniFacturas(facturas, inventario);
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
                            mostrarLista(inventario);
                            break;
				
			case 2:
                            agregarProducto(inventario);
                            break;
				
			case 3:
                            eliminarProducto(inventario);
                            break;
			
			case 4:
                            modificarProducto(inventario);
                            break;
                        
                        case 5:
                            mostrarFacturas(facturas, inventario);
                            break;
			
                        case 6:
                            realizarFactura(facturas, inventario);
                            break;
                            
			case 7:
                            System.out.println ("Salir de la ferretería");
                            return;	
				
                        default:
                            System.out.println ("Opción no válida");
                            break;
			}
		} while (!false);
	}
        
        //Definimos el método iniciar para obtener los datos de los productos
	public static void iniciar(ArrayList<Lista> inventario) {
		Lista p1 = new Lista();
		p1.ID = 9004;
		 p1.nombre = "Par de guantes  ";
		p1.precio = 14.7;
                 p1.cant = 16;
		
		Lista p2 = new Lista();
		p2.ID = 9005;
		 p2.nombre = "Martillo carpintero";
		p2.precio = 29.5;
                 p2.cant = 7;
		
		Lista p3 = new Lista();
		p3.ID = 9013;
		 p3.nombre = "Alicate multiuso";
		p3.precio = 12.9;
                 p3.cant = 8;
                
                Lista p4 = new Lista();
		p4.ID = 9127;
		 p4.nombre = "Serrucho carpintero";
		p4.precio = 27.9;
                 p4.cant = 6;
		
		Lista p5 = new Lista();
		p5.ID = 9128;
		 p5.nombre = "Destornillador  ";
		p5.precio = 18.5;
                 p5.cant = 18;
		
		Lista p6 = new Lista();
		p6.ID = 9210;
		 p6.nombre = "Taladro mediano  ";
		p6.precio = 99.0;
                 p6.cant = 4;
                
                Lista p7 = new Lista();
                p7.ID = 9512;
		 p7.nombre = "Juego de llaves  ";
		p7.precio = 163.2;
                 p7.cant = 3;
		
		Lista p8 = new Lista();
		p8.ID = 9534;
		 p8.nombre = "Juego de tornillos";
		p8.precio = 102.7;
                 p8.cant = 4;
		
		Lista p9 = new Lista();
		p9.ID = 9775;
		 p9.nombre = "Juego de tuercas";
		p9.precio = 114.5;
                 p9.cant = 2;
                
                Lista p10 = new Lista();
		p10.ID = 9808;
		 p10.nombre = "Juego de clavos   ";
		p10.precio = 27.9;
                 p10.cant = 4;
		
		Lista p11 = new Lista();
		p11.ID = 9819;
		 p11.nombre = "Cinta métrica    ";
		p11.precio = 10.0;
                 p11.cant = 14;
		
		Lista p12 = new Lista();
		p12.ID = 9823;
		 p12.nombre = "Trincheta o tijera";
		p12.precio = 21.7;
                 p12.cant = 8;
                
                Lista p13 = new Lista();
		p13.ID = 9861;
		 p13.nombre = "Cinta aislante    ";
		p13.precio = 15.7;
                 p13.cant = 16;
		
		Lista p14 = new Lista();
		p14.ID = 9883;
		 p14.nombre = "Amarres de nylon";
		p14.precio = 17.7;
                 p14.cant = 7;
		
		Lista p15 = new Lista();
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

        /*
        Definimos el método menuPrincipal para mostrar el menú de inicio
        de la Ferretería
	*/
        public static void menuPrincipal() {
		 System.out.println();
		 System.out.println ("=========== Bienvenido a la Ferretería Los Castros ===========");
		 System.out.println ("1: Lista de productos \n2: Agregar producto \n3: Eliminar producto \n"
                         + "4: Modificar producto \n5: Mostrar facturas \n6: Realizar una factura \n7: Salir");
		 System.out.println ("==============================================================");
                 System.out.println ("Ingrese el número de función a operar");		
	}
        
        /*
        Definimos el método elegirFuncion para leer la opción elegida por
        el usuario
	*/
        public static int elegirFuncion(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
        
        /*
        Definimos el método m ostrarLista para mostrar la lista de
        productos
        */
	public static void mostrarLista(ArrayList<Lista> inventario){
		System.out.println();
		 System.out.println ("========================================================");
		System.out.println ("ID de producto" + "\t" + "Nombre del producto" + "\t" + "Precio unitario" + "\t\t" + "Stock");
                 
		for (int i = 0; i < inventario.size(); i++) {
			Lista producto = inventario.get(i);
			System.out.println(producto.ID + "\t\t" + producto.nombre + "\t\t" + producto.precio + "\t"
                                + "\t" + producto.cant);
		}
	}	
        
        /*
        Definimos el método agregarProducto para leer los dato del
        producto ingresados por el usuario
	*/
        public static void agregarProducto(ArrayList<Lista> inventario){
		 System.out.println ("Ha seleccionado agregar productos");
		Scanner sc = new Scanner(System.in);
		 System.out.println ("Ingrese el ID del producto:");
		int ID = sc.nextInt();
		 System.out.println ("Ingrese el nombre del producto (Importante: Sin espacios):");
		String nombre = sc.next();
		 System.out.println ("Ingrese el precio unitario del producto:");
		double precio = sc.nextDouble();
                 System.out.println ("Ingrese nuevo stock");
		int cant = sc.nextInt();
                /*
                Definimos un objeto de la clase Lista al cual llamaremos producto,
                que se encargará de registrar los datos ingresados en la lista de
                productos
                */
		Lista producto = new Lista();
		 producto.ID = ID;
		producto.nombre = nombre;
		 producto.precio = precio;
                producto.cant = cant;
		inventario.add(producto);
		 System.out.println ("Producto agregado correctamente!");
	}
        
        /*
        Definimos el método eliminarProducto para leer el ID del
        producto que se desea eliminar
	*/
        public static void eliminarProducto(ArrayList<Lista> inventario){
		System.out.println ("Ha seleccionado eliminar producto");
		 System.out.println ("Ingrese el ID del producto:");
		Scanner sc = new Scanner(System.in);
		int ID = sc.nextInt();
		for (int i = 0; i < inventario.size(); i++) {
			Lista producto = inventario.get(i);
			if(producto.ID == ID){
				inventario.remove(i);
				 System.out.println ("¡Eliminado correctamente!");
				return;
			}
		}
		 System.out.println ("¡El ID ingresado no existe!");
	}
        
        /*
        Definimos el método modificarProducto para modificar
        los datos del producto seleccionado mediante su ID
	*/
        public static void modificarProducto(ArrayList<Lista> inventario){
		 System.out.println ("Ha seleccionado modificar producto");
		 System.out.println ("Ingrese el ID del producto a modificar:");
		
		Scanner sc = new Scanner(System.in);
		int ID = sc.nextInt();
		for (int i = 0; i < inventario.size(); i++) {
			Lista producto = inventario.get(i);
			if(producto.ID == ID){
				 System.out.println ("Ingrese un nuevo ID:");
				producto.ID = sc.nextInt();
				
				 System.out.println ("Ingrese un nuevo nombre de producto");
				producto.nombre = sc.next();
				
				 System.out.println ("Ingrese el precio unitario del producto");
				producto.precio = sc.nextDouble();
                                
                                 System.out.println ("Ingrese nuevo stock");
				producto.cant = sc.nextInt();
				
				 System.out.println ("Producto modificado correctamente");
				return;
			}
		}
		 System.out.println ("¡El ID ingresado no existe!");
	}
        
                
        public static void iniFacturas(ArrayList<Facturas> facturas, ArrayList<Lista> inventario) {
            Facturas f1 = new Facturas();
                f1.nFactura = 1;
                 f1.nomCliente = "Marco";
                f1.nomProducto = "Serrucho carpintero";
                 f1.cant = 1;
                f1.monto = 27.9;
                
                facturas.add(f1);
        }
        
        public static void mostrarFacturas(ArrayList<Facturas> facturas, ArrayList<Lista> inventario) {
		System.out.println();
		 System.out.println ("========================================================");
		 System.out.println ("Nro de factura" + "\t" + "Nombre del cliente" + "\t" + "Nombre del producto" + "\t"
                         + "" + "Cantidad comprada" + "\t" + "Monto pagado");
                 
		for (int i = 0; i < facturas.size(); i++) {
			Facturas venta = facturas.get(i);
			System.out.println(venta.nFactura + "\t\t" + venta.nomCliente + "\t\t\t" + venta.nomProducto+ "\t"
                                + "\t" +venta.cant+ "\t\t" +venta.monto);
		}
	}
        
        
        public static void realizarFactura(ArrayList<Facturas> facturas, ArrayList<Lista> inventario) {
                System.out.println ("Ha seleccionado realizar factura");
                System.out.println ("Ingrese el ID del producto a vender:");
                Scanner sc = new Scanner(System.in);
		int ID = sc.nextInt();
                
		for (int i = 0; i < inventario.size(); i++) {
                        Lista producto = inventario.get(i);
			if(producto.ID == ID){
                            System.out.println("Ha seleccionado el producto "+producto.nombre);
                            System.out.println ("Ingrese el nombre del cliente:");
                            String cliente = sc.next();
                            System.out.println ("Ingrese la cantidad de producto comprada:");
                            int cantProducto = sc.nextInt();
                            
                            Facturas venta = new Facturas();
                            int k=facturas.size()+1;
                            venta.nFactura = k;
                             venta.nomCliente = cliente;
                            venta.nomProducto = producto.nombre;
                             venta.cant = cantProducto;
                            venta.monto = producto.precio * cantProducto;
                             producto.cant = producto.cant - venta.cant;
                             
                            System.out.println("Ha registrado la factura: \n**************************************\n"
                                    + "Nº de Factura: "+k+"\n"+ "Nombre del cliente: "+cliente+"\n"
                                            + "Producto seleccionado: "+producto.nombre+"\n"
                                            + "Cantidad comprada: "+cantProducto+"\nMonto pagado: "+venta.monto);
                            System.out.println("**************************************");
                            System.out.println("¿La información ingresada es correcta?");
                            String opcion = sc.next();
                            
                            if (opcion.equals("si")) {
                                facturas.add(venta);
                                System.out.println ("Factura añadida correctamente!");
				return;
                            } else 
                                System.out.println ("Ha cancelado el registro de factura");
                                return;	 
			}
		} System.out.println ("¡El ID ingresado no existe!");
        }
}
