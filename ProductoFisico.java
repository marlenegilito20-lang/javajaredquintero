package inventario;

public class ProductoFisico extends Producto {
    private double pesoKg;
    private double costoEnvioPorKg;

    public ProductoFisico(String id, String nombre, double precio, int stock, double pesoKg, double costoEnvioPorKg) {
        super(id, nombre, precio, stock);
        this.pesoKg = pesoKg;
        this.costoEnvioPorKg = costoEnvioPorKg;
    }

    @Override
    public double calcularValorInventario() {
        return (precio * stock) + (pesoKg * costoEnvioPorKg * stock);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Físico] ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + 
                           " | Stock: " + stock + " | Peso: " + pesoKg + " kg");
    }

    @Override
    public boolean verificarDisponibilidad(int cantidadRequerida) {
        return this.stock >= cantidadRequerida;
    }

    public double getPesoKg() { return pesoKg; }
    public double getCostoEnvioPorKg() { return costoEnvioPorKg; }
}
