package inventario;

public class ProductoDigital extends Producto {
    private double tamanoMB;
    private String formato;

    public ProductoDigital(String id, String nombre, double precio, int stock, double tamanoMB, String formato) {
        super(id, nombre, precio, stock);
        this.tamanoMB = tamanoMB;
        this.formato = formato;
    }

    @Override
    public double calcularValorInventario() {
        return precio * stock;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Digital] ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + 
                           " | Formato: " + formato + " | Tamaño: " + tamanoMB + " MB");
    }

    @Override
    public boolean verificarDisponibilidad(int cantidadRequerida) {
        return true; 
    }

    public double getTamanoMB() { return tamanoMB; }
    public String getFormato() { return formato; }
}
