package inventario;

public class Main {
    public static void main(String[] args) {
        Inventario miInventario = new Inventario();

        // Creación de objetos usando el polimorfismo con la referencia de la clase abstracta
        Producto libro = new ProductoFisico("F001", "Libro de Estructuras de Datos", 450.0, 15, 0.6, 50.0);
        Producto curso = new ProductoDigital("D001", "Curso de Java Avanzado", 1200.0, 100, 1500.0, "MP4/ZIP");

        // Agregar productos
        miInventario.agregarProducto(libro);
        miInventario.agregarProducto(curso);

        // Mostrar inventario
        miInventario.mostrarInventario();

        // Calcular valor total
        System.out.printf("\nValor total valuado del inventario: $%.2f\n", miInventario.calcularValorTotalInventario());

        // Actualizar stock
        System.out.println();
        libro.actualizarStock(5);
    }
}
