package inventario;

public abstract class Producto implements Catalogable {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
        System.out.println("Stock actualizado para " + nombre + ". Stock actual: " + stock);
    }

    public abstract double calcularValorInventario();

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
}
