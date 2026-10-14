# Sistema de Gestión de Estudiantes (Java)

Proyecto académico de consola para practicar programación orientada a objetos.

## Funciones
- Crear estudiantes con nombre y matrícula.
- Registrar calificaciones entre 0 y 100.
- Calcular el promedio.
- Determinar si el promedio es aprobatorio (70 o más).
- Mostrar los datos del estudiante.

## Requisitos
- JDK 11 o posterior.
- IntelliJ IDEA, Eclipse, NetBeans o VS Code con soporte Java.

## Estructura
- `src/Main.java`: programa principal y clase `Estudiante`.
- `README.md`: documentación e instrucciones.
- `.gitignore`: excluye archivos generados por el IDE y Java.

## Ejecutar desde la terminal
Desde la carpeta del proyecto:

```bash
javac -d out src/Main.java
java -cp out Main
```

También puedes abrir la carpeta en IntelliJ IDEA, Eclipse o NetBeans y ejecutar la clase `Main`.

## Salida esperada
- Ana López: notas [85.0, 92.0, 78.0], promedio 85.00, Aprobado.
- Carlos Ruiz: notas [60.0, 68.0], promedio 64.00, No aprobado.

## Depuración
1. Abre `src/Main.java` en el IDE.
2. Coloca un breakpoint en `calcularPromedio()` o `agregarCalificacion()`.
3. Inicia **Debug**.
4. Avanza paso a paso y observa `calificaciones`, `suma` y el resultado del promedio.
5. Prueba una nota fuera del rango para comprobar la validación.

## Publicar en GitHub
1. Crea un repositorio vacío en https://github.com/new con el nombre `sistema-gestion-estudiantes-java`.
2. Abre la terminal en la carpeta raíz del proyecto y ejecuta:

```bash
git init
git add .
git commit -m "Crear sistema de gestión de estudiantes en Java"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/sistema-gestion-estudiantes-java.git
git push -u origin main
```

Sustituye `TU-USUARIO` por tu usuario de GitHub. Autentícate si Git lo solicita.

## Conceptos aplicados
- Clase: `Estudiante`.
- Objetos: `estudiante1` y `estudiante2`.
- Atributos: `nombre`, `matricula`, `calificaciones`.
- Constructor: `Estudiante(String nombre, String matricula)`.
- Métodos: `agregarCalificacion`, `calcularPromedio`, `estaAprobado`, `mostrarInformacion`.
- Encapsulación básica: atributos `private` y operaciones públicas.
- Validación de datos: entradas vacías y calificaciones fuera de rango.
