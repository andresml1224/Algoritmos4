package com.andresmontoya.domain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lista {
    private Estudiante head;

    public Lista() {
        this.head = null;
    }

    public Estudiante getHead() {
        return head;
    }

    public void setHead(Estudiante head) {
        this.head = head;
    }

    public void llenarArchivo(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");

                String nombre = partes[0];
                float[] notas = new float[5];
                for (int i = 0; i < 5; i++) {
                    notas[i] = Float.parseFloat(partes[i + 1]);
                }
                Estudiante estudiante = new Estudiante(nombre, notas, 0, null);
                estudiante.setPromedio(estudiante.calculoPromedio());

                if (head == null) {
                    head = estudiante;
                    head = estudiante;
                    head = estudiante;
                } else {
                    Estudiante apuntador = head;
                    while (apuntador.getNext() != null) {
                        apuntador = apuntador.getNext();
                    }
                    apuntador.setNext(estudiante);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
        }
    }
    public void insertarEst(Estudiante estudiante) {
        if (head == null) {
            head = estudiante;
        } else {
            Estudiante apuntador = head;
            while (apuntador.getNext() != null) {
                apuntador = apuntador.getNext();
            }
            apuntador.setNext(estudiante);
        }
    }
    public void borrarEst() {
        Estudiante apuntador = head;
        Estudiante prev = null;

        while (apuntador != null && apuntador.getPromedio() < 2) {
            head = apuntador.getNext();
            apuntador = head;
        }

        while (apuntador != null) {
            while (apuntador != null && apuntador.getPromedio() >= 2) {
                prev = apuntador;
                apuntador = apuntador.getNext();
            }

            if (apuntador == null) return;

            prev.setNext(apuntador.getNext());
            apuntador = prev.getNext();
        }
    }
    public void mostrarTodos() {
        Estudiante apuntador = head;
        while (apuntador != null) {
            System.out.println("Nombre: " + apuntador.getNombre() + ", Promedio: " + apuntador.getPromedio());
            apuntador = apuntador.getNext();
        }
    }
    public void mostrarMayorProm() {
        Estudiante apuntador = head;
        while (apuntador != null) {
            if (apuntador.getPromedio() > 3) {
                System.out.println("Nombre: " + apuntador.getNombre() + ", Promedio: " + apuntador.getPromedio());
            }
            apuntador = apuntador.getNext();
        }
    }
    public void ordenarProm() {
        if (head == null || head.getNext() == null) {
            return;
        }

        boolean ordenado;
        do {
            ordenado = true;
            Estudiante anterior = null;
            Estudiante actual = head;
            Estudiante siguiente = head.getNext();

            while (siguiente != null) {
                if (actual.getPromedio() > siguiente.getPromedio()) {
                    if (anterior == null) {
                        head = siguiente;
                    } else {
                        anterior.setNext(siguiente);
                    }
                    actual.setNext(siguiente.getNext());
                    siguiente.setNext(actual);

                    anterior = siguiente;
                    siguiente = actual.getNext();
                    ordenado = false;
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.getNext();
                }
            }
        } while (!ordenado);
        Estudiante prev = null;
        Estudiante curr = head;
        Estudiante next;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}

