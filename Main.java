/**
 * Sistema de Gestión de Estudiantes.
 * Proyecto académico para practicar clases, objetos, atributos,
 * constructores y métodos en Java.
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Se crean dos objetos (instancias) de la clase Estudiante.
        Estudiante estudiante1 = new Estudiante("Ana López", "A001");
        Estudiante estudiante2 = new Estudiante("Carlos Ruiz", "A002");

        // Se prueban los métodos agregando calificaciones.
        estudiante1.agregarCalificacion(85);
        estudiante1.agregarCalificacion(92);
        estudiante1.agregarCalificacion(78);

        estudiante2.agregarCalificacion(60);
        estudiante2.agregarCalificacion(68);

        // Se muestran los resultados para comprobar el comportamiento.
        System.out.println("=== Estudiante 1 ===");
        estudiante1.mostrarInformacion();

        System.out.println("\n=== Estudiante 2 ===");
        estudiante2.mostrarInformacion();
    }
}

/**
 * Representa a un estudiante y administra sus calificaciones.
 */
class Estudiante {
    // Atributos: datos que pertenecen a cada objeto.
    private String nombre;
    private String matricula;
    private List<Double> calificaciones;

    // Constante de clase: promedio mínimo para aprobar.
    private static final double NOTA_MINIMA_APROBACION = 70.0;

    /**
     * Constructor: inicializa nombre, matrícula y lista de calificaciones.
     * @param nombre nombre completo del estudiante
     * @param matricula identificador del estudiante
     */
    public Estudiante(String nombre, String matricula) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("La matrícula no puede estar vacía.");
        }

        this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = new ArrayList<>();
    }

    /**
     * Agrega una calificación válida entre 0 y 100.
     * @param nota calificación a registrar
     */
    public void agregarCalificacion(double nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException(
                "La calificación debe estar entre 0 y 100."
            );
        }
        calificaciones.add(nota);
    }

    /**
     * Calcula el promedio de las calificaciones registradas.
     * Devuelve 0 si todavía no existen calificaciones.
     * @return promedio de calificaciones
     */
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return suma / calificaciones.size();
    }

    /**
     * Comprueba si el estudiante alcanza el promedio mínimo de aprobación.
     * @return true si tiene notas y su promedio es al menos 70; false si no
     */
    public boolean estaAprobado() {
        return !calificaciones.isEmpty()
            && calcularPromedio() >= NOTA_MINIMA_APROBACION;
    }

    /**
     * Imprime la información principal del estudiante.
     */
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Calificaciones: " + calificaciones);
        System.out.printf("Promedio: %.2f%n", calcularPromedio());
        System.out.println("Estado: " + (estaAprobado() ? "Aprobado" : "No aprobado"));
    }
}
