
package Modelo;

public abstract class Inventario{
    
    public boolean seleccionado;
    public int ID;
    public String nombre;
    
    public Inventario() {
    }

    public Inventario(boolean seleccionado, int ID, String nombre) {
        this.seleccionado = seleccionado;
        this.ID = ID;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSeleccionado() {
        return false;
    }
}
