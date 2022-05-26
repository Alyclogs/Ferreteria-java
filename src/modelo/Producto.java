package Modelo;

import java.io.File;


public class Producto extends Inventario {
    
    public double precio;
    public int stock;

    public Producto() {
        super();
    }

    public Producto(boolean seleccionado, int ID, String nombre, double precio, int stock) {
        super(seleccionado, ID, nombre);
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
}
