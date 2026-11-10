package inventario;

public interface Catalogable {
    void mostrarDetalles();
    boolean verificarDisponibilidad(int cantidadRequerida);
}
