

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE ESTUDIANTE PRESENCIAL ===");
        EstudiantePresencial estPresencial = new EstudiantePresencial("Ana López", "A001", "Aula 104");
        estPresencial.agregarCalificacion(85);
        estPresencial.agregarCalificacion(92);
        estPresencial.registrarFalta();
        estPresencial.registrarFalta();
        estPresencial.mostrarInformacion();

        System.out.println("\n=== PRUEBA DE ESTUDIANTE EN LÍNEA ===");
        EstudianteEnLinea estEnLinea = new EstudianteEnLinea("Carlos Ruiz", "A002", "Plataforma Moodle");
        estEnLinea.agregarCalificacion(78);
        estEnLinea.agregarCalificacion(90);
        estEnLinea.registrarHorasConexion(15);
        estEnLinea.mostrarInformacion();
    }
}

/**
 * Clase base (superclase) que representa a un estudiante general.
 * Contiene los atributos y métodos comunes.
 */
class Estudiante {
    private String nombre;
    private String matricula;
    private List<Double> calificaciones;
    private static final double NOTA_MINIMA_APROBACION = 70.0;

    /**
     * Constructor de la clase base.
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
     */
    public void agregarCalificacion(double nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 100.");
        }
        calificaciones.add(nota);
    }

    /**
     * Calcula el promedio de las calificaciones registradas.
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
     * Comprueba si el estudiante aprueba según el promedio mínimo.
     */
    public boolean estaAprobado() {
        return !calificaciones.isEmpty() && calcularPromedio() >= NOTA_MINIMA_APROBACION;
    }

    /**
     * Imprime la información general del estudiante.
     */
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Calificaciones: " + calificaciones);
        System.out.printf("Promedio: %.2f%n", calcularPromedio());
        System.out.println("Estado: " + (estaAprobado() ? "Aprobado" : "No aprobado"));
    }
}

/**
 * Clase derivada (subclase) que representa a un estudiante presencial.
 * Utiliza la palabra reservada 'extends' para heredar de Estudiante.
 */
class EstudiantePresencial extends Estudiante {
    // Atributos exclusivos de la subclase presencial
    private String salonClases;
    private int faltas;

    /**
     * Constructor de la subclase. Utiliza 'super' para invocar
     * el constructor de la clase base y reutilizar su lógica.
     */
    public EstudiantePresencial(String nombre, String matricula, String salonClases) {
        super(nombre, matricula);
        this.salonClases = salonClases;
        this.faltas = 0;
    }

    /**
     * Método exclusivo de la subclase para registrar inasistencias.
     */
    public void registrarFalta() {
        this.faltas++;
    }

    /**
     * Sobrescritura (Override) del método mostrarInformacion.
     * Reutiliza el comportamiento base con 'super.mostrarInformacion()' 
     * y añade los detalles específicos del estudiante presencial.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Reutilización de método base
        System.out.println("Modalidad: Presencial");
        System.out.println("Salón de Clases: " + salonClases);
        System.out.println("Número de Faltas: " + faltas);
    }
}

/**
 * Segunda clase derivada (subclase) que representa a un estudiante en línea.
 */
class EstudianteEnLinea extends Estudiante {
    // Atributos exclusivos de la subclase en línea
    private String plataformaVirtual;
    private int horasConexion;

    /**
     * Constructor de la subclase usando 'super'.
     */
    public EstudianteEnLinea(String nombre, String matricula, String plataformaVirtual) {
        super(nombre, matricula);
        this.plataformaVirtual = plataformaVirtual;
        this.horasConexion = 0;
    }

    /**
     * Método exclusivo para acumular horas de conexión en plataforma.
     */
    public void registrarHorasConexion(int horas) {
        if (horas > 0) {
            this.horasConexion += horas;
        }
    }

    /**
     * Sobrescritura del método mostrarInformacion para datos virtuales.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Reutilización de método base
        System.out.println("Modalidad: En Línea");
        System.out.println("Plataforma Virtual: " + plataformaVirtual);
        System.out.println("Horas de Conexión: " + horasConexion + " hrs");
    }
}