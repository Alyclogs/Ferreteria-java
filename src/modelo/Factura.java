
package Modelo;

public class Factura extends Inventario {
    
    public String nombreProducto;
    public double montoVendido;
    public int cantidadVendida;
    
    public Factura() {
        super();
    }

    public Factura(boolean seleccionado, int ID, String nombre, String nombreProducto, int cantidadVendida, double montoVendido) {
        super(seleccionado, ID, nombre);
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
        this.montoVendido = montoVendido;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }
    
    public double getMontoVendido() {
        return montoVendido;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setMontoVendido(double montoVendido) {
        this.montoVendido = montoVendido;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
