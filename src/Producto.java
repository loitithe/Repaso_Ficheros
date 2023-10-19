public class Producto {
    
    private int id;
    private String nombre;
    private double precio;
    private boolean descuento;
    private char tipo;
    public Producto(int id, String nombre, double precio, boolean descuento, char tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public boolean isDescuento() {
        return descuento;
    }
    public char getTipo() {
        return tipo;
    }

    
}
