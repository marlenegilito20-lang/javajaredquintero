package inventario;

import java.util.ArrayList;
import java.util.List;

/**
 * INTERFAZ: Descontable
 * Define el contrato para aquellos productos que pueden recibir descuentos promocionales.
 */
interface Descontable {
    void aplicarDescuento(double porcentaje);
}

/**
 * CLASE ABSTRACTA BASE: Producto
 * Define los atributos comunes a todos los productos del inventario
 * y establece métodos abstractos que fuerzan el polimorfismo en las subclases.
 */
abstract class Producto implements Descontable {
    // Atributos protegidos accesibles por clases derivadas
    protected String id;
    protected String nombre;
    protected double precioBase;
    protected int stock;

    // Constructor de la clase abstracta
    public Producto(String id, String nombre, double precioBase, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // Método concreto común a todas las subclases
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
        System.out.println(" Stock actualizado para '" + nombre + "'. Nuevo stock: " + stock);
    }

    // MÉTODOS ABSTRACTOS: Deben ser implementados obligatoriamente por las subclases
    public abstract double calcularPrecioFinal();
    public abstract void mostrarDetalles();

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
    public int getStock() { return stock; }
}

/**
 * CLASE DERIVADA 1: Electronico (Hereda de Producto)
 */
class Electronico extends Producto {
    private int mesesGarantia;
    private double impuestoImportacion; // Porcentaje adicional (ej. 0.15 para 15%)

    public Electronico(String id, String nombre, double precioBase, int stock, int mesesGarantia, double impuestoImportacion) {
        super(id, nombre, precioBase, stock); // Llamada al constructor de la clase madre
        this.mesesGarantia = mesesGarantia;
        this.impuestoImportacion = impuestoImportacion;
    }

    // Implementación polimórfica del cálculo de precio con impuesto
    @Override
    public double calcularPrecioFinal() {
        return precioBase + (precioBase * impuestoImportacion);
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precioBase -= (this.precioBase * (porcentaje / 100.0));
        System.out.println(" Descuento del " + porcentaje + "% aplicado a Electrónico: " + nombre);
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("[ELECTRÓNICO] ID: %s | Nombre: %s | Precio Base: $%.2f | Precio Final (+Impuesto): $%.2f | Garantía: %d meses | Stock: %d\n",
                id, nombre, precioBase, calcularPrecioFinal(), mesesGarantia, stock);
    }
}

/**
 * CLASE DERIVADA 2: Alimento (Hereda de Producto)
 */
class Alimento extends Producto {
    private int diasParaVencer;

    public Alimento(String id, String nombre, double precioBase, int stock, int diasParaVencer) {
        super(id, nombre, precioBase, stock);
        this.diasParaVencer = diasParaVencer;
    }

    // Si le quedan menos de 5 días para vencer, se le aplica un 20% de descuento automático en el precio final
    @Override
    public double calcularPrecioFinal() {
        if (diasParaVencer <= 5) {
            return precioBase * 0.80; // 20% de descuento por liquidación de caducidad
        }
        return precioBase;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precioBase -= (this.precioBase * (porcentaje / 100.0));
        System.out.println(" Descuento del " + porcentaje + "% aplicado a Alimento: " + nombre);
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("[ALIMENTO]   ID: %s | Nombre: %s | Precio Base: $%.2f | Precio Final: $%.2f | Días p/Vencer: %d | Stock: %d\n",
                id, nombre, precioBase, calcularPrecioFinal(), diasParaVencer, stock);
    }
}

/**
 * CLASE DERIVADA 3: Ropa (Hereda de Producto)
 */
class Ropa extends Producto {
    private String talla;
    private String material;

    public Ropa(String id, String nombre, double precioBase, int stock, String talla, String material) {
        super(id, nombre, precioBase, stock);
        this.talla = talla;
        this.material = material;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase; // La ropa mantiene su precio base a menos que se aplique oferta
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precioBase -= (this.precioBase * (porcentaje / 100.0));
        System.out.println(" Descuento del " + porcentaje + "% aplicado a Ropa: " + nombre);
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("[ROPA]       ID: %s | Nombre: %s | Precio: $%.2f | Talla: %s | Material: %s | Stock: %d\n",
                id, nombre, precioBase, talla, material, stock);
    }
}

/**
 * CLASE GESTORA DE INVENTARIO
 */
class GestorInventario {
    // Colección polimórfica: almacena cualquier subclase de Producto
    private List<Producto> listaProductos;

    public GestorInventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        listaProductos.add(p);
        System.out.println("✓ Producto registrado: " + p.getNombre());
    }

    /**
     * DEMOSTRACIÓN DE POLIMORFISMO:
     * El método recorre la lista de tipo genérico `Producto` e invoca `mostrarDetalles()`
     * y `calcularPrecioFinal()`. En tiempo de ejecución, Java determina a qué tipo de objeto
     * (Electronico, Alimento o Ropa) pertenece la referencia y ejecuta su método específico.
     */
    public void generarReportePolimorfico() {
        System.out.println("\n==========================================================================================");
        System.out.println("                      REPORTE POLIMÓRFICO DE INVENTARIO                                   ");
        System.out.println("==========================================================================================");
        double valorTotal = 0.0;

        for (Producto p : listaProductos) {
            p.mostrarDetalles(); // Invocación polimórfica
            valorTotal += (p.calcularPrecioFinal() * p.getStock());
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("VALOR TOTAL VALUADO DEL INVENTARIO: $%.2f\n", valorTotal);
        System.out.println("==========================================================================================\n");
    }

    public List<Producto> getProductos() { return listaProductos; }
}

/**
 * CLASE PRINCIPAL DE PRUEBA Y DEPURACIÓN
 */
public class SistemaInventario {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE GESTIÓN DE INVENTARIOS CON POLIMORFISMO ===\n");

        GestorInventario inventario = new GestorInventario();

        // 1. INSTANCIACIÓN DE SUBCLASES (Polimorfismo en asignación de tipos)
        Producto laptop = new Electronico("E101", "Laptop Gaming", 1200.00, 5, 24, 0.16);
        Producto leche = new Alimento("A201", "Leche Entera 1L", 2.50, 40, 3); // 3 días p/vencer -> Aplica descuento caducidad
        Producto camisa = new Ropa("R301", "Camisa Algodón", 35.00, 20, "L", "100% Algodón");

        // 2. AGREGAR AL INVENTARIO
        inventario.agregarProducto(laptop);
        inventario.agregarProducto(leche);
        inventario.agregarProducto(camisa);

        // 3. PRIMERA DEMOSTRACIÓN POLIMÓRFICA
        inventario.generarReportePolimorfico();

        // 4. DEMOSTRACIÓN DE APLICACIÓN DE DESCUENTOS E INTERFAZ
        System.out.println("=== APLICANDO DESCUENTOS PROMOCIONALES ===");
        laptop.aplicarDescuento(10); // 10% de descuento
        camisa.aplicarDescuento(15); // 15% de descuento

        // 5. ACTUALIZACIÓN DE STOCK (Método heredado de la clase abstracta)
        System.out.println("\n=== REABASTECIMIENTO DE STOCK ===");
        leche.actualizarStock(10);

        // 6. SEGUNDA DEMOSTRACIÓN POLIMÓRFICA (Comprobar estado actualizado)
        inventario.generarReportePolimorfico();
    }
}