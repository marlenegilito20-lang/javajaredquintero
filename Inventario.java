package inventario;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        System.out.println("Producto agregado exitosamente: " + producto.getNombre());
    }

    public void mostrarInventario() {
        System.out.println("\n==========================================");
        System.out.println("     REPORTE GENERAL DE INVENTARIO       ");
        System.out.println("==========================================");
        for (Producto p : listaProductos) {
            p.mostrarDetalles();
        }
    }

    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto p : listaProductos) {
            total += p.calcularValorInventario();
        }
        return total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
