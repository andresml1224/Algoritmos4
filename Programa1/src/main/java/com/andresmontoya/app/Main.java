package com.andresmontoya.app;

import com.andresmontoya.domain.Estudiante;
import com.andresmontoya.domain.Lista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        String rutaArchivo = "C:\\Users\\prueb\\OneDrive\\Documentos\\Proyectos java\\Algorimos 4\\Programa1\\Datos.txt";
        lista.llenarArchivo(rutaArchivo);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar estudiante");
            System.out.println("2. Borrar estudiantes con promedio menor a 2");
            System.out.println("3. Mostrar todos los estudiantes");
            System.out.println("4. Mostrar estudiantes con promedio mayor a 3");
            System.out.println("5. Ordenar estudiantes por promedio");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Estudiante estudiante = ingresarEstudiante(scanner);
                    lista.insertarEst(estudiante);
                    break;
                case 2:
                    lista.borrarEst();
                    break;
                case 3:
                    lista.mostrarTodos();
                    break;
                case 4:
                    lista.mostrarMayorProm();
                    break;
                case 5:
                    lista.ordenarProm();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    public static Estudiante ingresarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        float[] notas = new float[5];
        System.out.println("Ingrese las 5 notas del estudiante:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextFloat();
            scanner.nextLine();
        }
        return new Estudiante(nombre, notas, 0, null);
    }
}
